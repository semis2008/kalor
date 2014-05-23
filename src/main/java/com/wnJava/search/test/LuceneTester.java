/**
 * 
 */
package com.wnJava.search.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.AtomicReaderContext;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.DocIdSet;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeFilter;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermRangeFilter;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Bits;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.wnJava.search.IndexHolder;
import com.wnJava.search.SearchHelper;
import com.wnJava.search.Searchable;


/**
 * 测试索引过程
 * @author Winter Lau
 */
public class LuceneTester {

	/**
	 * 测试添加索引
	 * @param args
	 * @throws IOException
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		IndexHolder holder = IndexHolder.init("D:\\TEST");
		Post post = new Post();
		
		post.setId(11l);
		post.setTitle("1234");
		
		holder.add(Arrays.asList(post));
		holder.delete(Arrays.asList(post));
		
		Query q = SearchHelper.makeQuery("title", "1234", 1.2f) ;
		 List<Searchable> hits = holder.find(Post.class, q, null, new Sort(), 1, 100);
		 System.out.println(hits.size());
	}

}

