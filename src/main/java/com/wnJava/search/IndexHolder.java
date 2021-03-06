package com.wnJava.search;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.MultiReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TotalHitCountCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 索引库管理
 * 
 * @author Winter Lau
 */
public class IndexHolder {
	private final static Log log = LogFactory.getLog(IndexHolder.class);
	private final static IKAnalyzer analyzer = new IKAnalyzer();
	private final static int MAX_COUNT = 1000;
	private static String INDEX_DIR = "D:\\TEST";
	private static String indexPath;
	private static IndexHolder instance;

	private IndexHolder() {
		try {
			init();
		} catch (IOException e) {
			log.error("初始化");
			e.printStackTrace();
		}
	}

	public static IndexHolder getInstance() {
		if (instance == null) {
			synchronized (IndexHolder.class) {
				if (instance == null) {
					instance = new IndexHolder();
				}
			}
		}
		return instance;
	}

	/**
	 * 构造索引库管理实例
	 * 
	 * @param idx_path
	 * @return
	 * @throws IOException
	 */
	private static void init() throws IOException {
		INDEX_DIR = FilenameUtils.normalize(INDEX_DIR);
		File file = new File(INDEX_DIR);
		if (!file.exists() || !file.isDirectory())
			throw new FileNotFoundException(INDEX_DIR);
		if (!INDEX_DIR.endsWith(File.separator))
			INDEX_DIR += File.separator;
		indexPath = INDEX_DIR;
	}

	public IndexWriter getWriter(Class<? extends Searchable> objClass) throws IOException {
		Directory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
		config.setOpenMode(OpenMode.CREATE_OR_APPEND);
		return new IndexWriter(dir, config);
	}

	public IndexSearcher getSearcher(Class<? extends Searchable> objClass) throws IOException {
		Directory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
		return new IndexSearcher(DirectoryReader.open(dir));
	}

	/**
	 * 多个资料库的搜索
	 * 
	 * @param objClasses
	 * @return
	 * @throws IOException
	 */
	private IndexSearcher getSearchers(List<Class<? extends Searchable>> objClasses) throws IOException {
		IndexReader[] readers = new IndexReader[objClasses.size()];
		int idx = 0;
		for (Class<? extends Searchable> objClass : objClasses) {
			FSDirectory dir = FSDirectory.open(new File(indexPath + objClass.getSimpleName()));
			readers[idx++] = DirectoryReader.open(dir);
		}
		return new IndexSearcher(new MultiReader(readers, true));
	}

	/**
	 * 优化索引库
	 * 
	 * @param objClass
	 * @throws IOException
	 */
	public void optimize(Class<? extends Searchable> objClass) throws IOException {
		IndexWriter writer = getWriter(objClass);
		try {
			writer.forceMerge(1);
			writer.commit();
		} finally {
			writer.close();
			writer = null;
		}
	}

	/**
	 * 多库搜索
	 * 
	 * @param objClasses
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	public List<Searchable> find(List<Class<? extends Searchable>> objClasses, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		IndexSearcher searcher = getSearchers(objClasses);
		return find(searcher, query, filter, sort, page, count);
	}

	/**
	 * 单库搜索
	 * 
	 * @param objClass
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	public List<Searchable> find(Class<? extends Searchable> objClass, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		IndexSearcher searcher = getSearcher(objClass);
		List<Searchable> results = find(searcher, query, filter, sort, page, count);
		return results;
	}

	/**
	 * 多库搜索
	 * 
	 * @param objClasses
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	public int count(List<Class<? extends Searchable>> objClasses, Query query, Filter filter) throws IOException {
		IndexSearcher searcher = getSearchers(objClasses);
		return count(searcher, query, filter);
	}

	/**
	 * 搜索
	 * 
	 * @param beanClass
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	public int count(Class<? extends Searchable> objClass, Query query, Filter filter) throws IOException {
		IndexSearcher searcher = getSearcher(objClass);
		return count(searcher, query, filter);
	}

	/**
	 * 搜索
	 * 
	 * @param searcher
	 * @param query
	 * @param filter
	 * @param sort
	 * @param page
	 * @param count
	 * @return
	 * @throws IOException
	 */
	private List<Searchable> find(IndexSearcher searcher, Query query, Filter filter, Sort sort, int page, int count) throws IOException {
		try {
			TopDocs hits = null;
			if (filter != null && sort != null)
				hits = searcher.search(query, filter, MAX_COUNT, sort);
			else if (filter != null)
				hits = searcher.search(query, filter, MAX_COUNT);
			else if (sort != null)
				hits = searcher.search(query, MAX_COUNT, sort);
			else
				hits = searcher.search(query, MAX_COUNT);
			if (hits == null)
				return null;
			List<Searchable> results = new ArrayList<Searchable>();
			int nBegin = (page - 1) * count;
			int nEnd = Math.min(nBegin + count, hits.scoreDocs.length);
			for (int i = nBegin; i < nEnd; i++) {
				ScoreDoc s_doc = (ScoreDoc) hits.scoreDocs[i];
				Document doc = searcher.doc(s_doc.doc);
				Searchable obj = SearchHelper.doc2obj(doc);
				if (obj != null && !results.contains(obj)) {
					results.add(obj);
				}
			}
			return results;
		} catch (IOException e) {
			log.error("Unabled to find via query: " + query, e);
		}
		return null;
	}

	/**
	 * 根据查询条件统计搜索结果数
	 * 
	 * @param searcher
	 * @param query
	 * @param filter
	 * @return
	 * @throws IOException
	 */
	private int count(IndexSearcher searcher, Query query, Filter filter) throws IOException {
		try {
			TotalHitCountCollector thcc = new TotalHitCountCollector();
			if (filter != null)
				searcher.search(query, filter, thcc);
			else
				searcher.search(query, thcc);
			return Math.min(MAX_COUNT, thcc.getTotalHits());
		} catch (IOException e) {
			log.error("Unabled to find via query: " + query, e);
			return -1;
		}
	}

	/**
	 * 批量添加索引
	 * 
	 * @param docs
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public int add(List<? extends Searchable> objs) throws IOException {
		if (objs == null || objs.size() == 0)
			return 0;
		int doc_count = 0;
		IndexWriter writer = null;
		try {
			writer = getWriter(objs.get(0).getClass());
			for (Searchable obj : objs) {
				Document doc = SearchHelper.obj2doc(obj);
				writer.addDocument(doc);
				doc_count++;
			}
			writer.commit();
		} finally {
			writer.close();
			writer = null;
		}
		return doc_count;
	}

	/**
	 * 批量删除索引
	 * 
	 * @param docs
	 * @throws IOException
	 */
	public int delete(List<? extends Searchable> objs) throws IOException {
		if (objs == null || objs.size() == 0)
			return 0;
		int doc_count = 0;
		IndexWriter writer = getWriter(objs.get(0).getClass());
		try {
			for (Searchable obj : objs) {
				writer.deleteDocuments(new Term(SearchHelper.FN_ID, String.valueOf(obj.id())));
				doc_count++;
			}
			writer.commit();
		} finally {
			writer.close();
			writer = null;
		}
		return doc_count;
	}

	/**
	 * 批量更新索引
	 * 
	 * @param docs
	 * @throws IOException
	 */
	public void update(List<? extends Searchable> objs) throws IOException {
		delete(objs);
		add(objs);
	}
}
