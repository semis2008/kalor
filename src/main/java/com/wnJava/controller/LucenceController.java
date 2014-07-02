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
import com.wnJava.service.UserService;
import com.wnJava.util.JsonUtil;
import com.wnJava.util.WebUtil;
import com.wnJava.vo.UserVO;
import com.wnJava.vo.lucence.DiaryVO;
import com.wnJava.vo.lucence.IndexInfo;

@Controller
@RequestMapping(value = "/lucence")
public class LucenceController {
	
	@Resource
	private DiaryService diaryService;
	@Resource
	private UserService userService;
	@RequestMapping
	private ModelAndView showLucencePage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IndexInfo indexInfo = getIndexInfo(new DiaryVO());
		UserVO userVO = WebUtil.getLoginUserInfo(userService, diaryService);
		req.setAttribute("loginUser", userVO);
		req.setAttribute("blogInfo", indexInfo);
		return new ModelAndView("/lucence/index");
	}

	@RequestMapping(value="/initBlogIndex")
	private void initBlogIndex(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IndexHolder holder = IndexHolder.getInstance();
		List<DiaryBO> bos = diaryService.getDiaryList(0, 100);
		List<DiaryVO> vos = new ArrayList<DiaryVO>();
		for(DiaryBO bo:bos) {
			DiaryVO vo = DiaryVO.getVO(bo);
			vos.add(vo);
		}
		holder.add(vos);
		JsonUtil.outputDTOToJSON(null, resp);
	}

	@RequestMapping(value="/ajax/search")
	private void search(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String key = (String) req.getParameter("key") ;
		String value = (String) req.getParameter("value");
		
		IndexHolder holder = IndexHolder.getInstance();
		Query q = SearchHelper.makeQuery(key, value);
		
		List<DiaryVO> vos = new ArrayList<DiaryVO>();
		List<Searchable> hits = holder.find(DiaryVO.class, q, null, new Sort(), 1, 100);
		for (Searchable searchable : hits) {
			DiaryVO v = (DiaryVO) searchable;
			vos.add(v);
		}
		JsonUtil.outputDTOToJSON(vos, resp);
	}

	
	
	@SuppressWarnings("unchecked")
	private IndexInfo getIndexInfo(Searchable clazz) throws IOException {
		IndexHolder holder = IndexHolder.getInstance();
		IndexInfo indexInfo = new IndexInfo();
		/*
		 * 设置实体
		 */
		Query q = SearchHelper.makeQueryAll(1.0f);
		List<Searchable> hits = holder.find(clazz.getClass(), q, null, new Sort(), 1, 100);
		indexInfo.setSearchables(hits);
		/*
		 * 设置统计信息
		 */
		IndexSearcher indexSearcher = IndexHolder.getInstance().getSearcher(clazz.getClass());
		indexInfo.setMaxDocCount(indexSearcher.getIndexReader().maxDoc());//总数
		indexInfo.setDelDocCount(indexSearcher.getIndexReader().numDeletedDocs());//删除数
		indexInfo.setDocCount(indexSearcher.getIndexReader().numDocs());//有效数
		return indexInfo;
	}
}
