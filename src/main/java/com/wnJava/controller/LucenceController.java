package com.wnJava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.bo.DiaryBO;
import com.wnJava.search.IndexHolder;
import com.wnJava.search.SearchHelper;
import com.wnJava.search.Searchable;
import com.wnJava.service.DiaryService;
import com.wnJava.vo.lucence.IndexInfo;

@Controller
@RequestMapping(value = "/lucence")
public class LucenceController {
	
	@Resource
	private DiaryService diaryService;
	
	@RequestMapping
	private ModelAndView showLucencePage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IndexInfo indexInfo = getIndexInfo(DiaryBO.class);
		
		req.setAttribute("blogInfo", indexInfo);
		return new ModelAndView("/lucence/index");
	}

	@RequestMapping(value="/initBlogIndex")
	private void initBlogIndex(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IndexHolder holder = IndexHolder.getInstance();
		List<DiaryBO> bos = diaryService.getDiaryList(0, 100);
		holder.add(bos);
	}

	
	
	@SuppressWarnings("unchecked")
	private IndexInfo getIndexInfo(Class clazz) throws IOException {
		IndexHolder holder = IndexHolder.getInstance();
		IndexInfo indexInfo = new IndexInfo();
		/*
		 * 设置实体
		 */
		List<Searchable> diaries = new ArrayList<Searchable>();
		Query q = SearchHelper.makeQueryAll(1.0f);
		List<Searchable> hits = holder.find(clazz, q, null, new Sort(), 1, 100);
		for (Searchable searchable : hits) {
			DiaryBO d = (DiaryBO) searchable;
			diaries.add(d);
		}
		indexInfo.setSearchables(diaries);
		/*
		 * 设置统计信息
		 */
		IndexSearcher indexSearcher = IndexHolder.getInstance().getSearcher(clazz);
		indexInfo.setMaxDocCount(indexSearcher.getIndexReader().maxDoc());//总数
		indexInfo.setDelDocCount(indexSearcher.getIndexReader().numDeletedDocs());//删除数
		indexInfo.setDocCount(indexSearcher.getIndexReader().numDocs());//有效数
		return indexInfo;
	}
}
