/**
 * 
 */
package com.wnJava.search.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import com.wnJava.search.IndexHolder;
import com.wnJava.search.SearchHelper;
import com.wnJava.search.Searchable;

/**
 * 测试索引过程
 * 
 * @author Winter Lau
 */
public class LuceneTester {
	/**
	 * 测试添加索引
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException {
		IndexHolder holder = IndexHolder.getInstance();
		Post post = new Post();
		holder.optimize(post.getClass());
		post.setId(11l);
		post.setTitle("北京欢迎你");
		post.setBody("天气正好");
		holder.add(Arrays.asList(post));
		// holder.delete(Arrays.asList(post));
		Query q = SearchHelper.makeQuery(SearchHelper.FN_CLASSNAME, "Post.class", 1.0f);
		List<Searchable> hits = holder.find(Post.class, q, null, new Sort(), 1, 100);
		for (Searchable searchable : hits) {
			Post p = (Post) searchable;
			System.out.println(p.getId() + ";" + p.getTitle() + ";" + p.getBody());
		}
		
		//测试数据
		IndexSearcher indexSearcher = IndexHolder.getInstance().getSearcher(Post.class);
		System.out.print(indexSearcher.getIndexReader().maxDoc());//总数
		System.out.print(indexSearcher.getIndexReader().numDeletedDocs());//删除数
		System.out.print(indexSearcher.getIndexReader().numDocs());//有效数
		
		
	}
}
