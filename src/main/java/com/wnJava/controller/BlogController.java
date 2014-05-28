package com.wnJava.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.service.DiaryService;
import com.wnJava.util.EscapedHtmlUtil;
import com.wnJava.util.StringUtil;

/**
 * Lucence监听控制
 * @author Kalor
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private DiaryService diaryService;
	
	/**
	 * 
	  * 显示博客列表
	  *
	  * @autor: wn  2014-5-27 下午3:11:12
	  * @param req
	  * @param resp
	  * @param category
	  * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/{category}")
	private ModelAndView showList(HttpServletRequest req, HttpServletResponse resp, @PathVariable String category) throws Exception {
		List<DiaryBO> diaries = diaryService.getDiaryListByCategory(category,0,5);
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(5);
		for(DiaryBO bo:diaries) {
			bo.setContent(StringUtil.escapeHtmlTags(bo.getContent()));	
		}
		req.setAttribute("diaries", diaries);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("category", category);
		return new ModelAndView("blog/list");
	}
	
	/**
	 * 
	  * 显示博客详情
	  *
	  * @autor: wn  2014-5-28 下午2:28:31
	  * @param req
	  * @param resp
	  * @param category
	  * @param id
	  * @return
	  * @throws Exception
	 */
	@RequestMapping(value="/{category}/{id}")
	private ModelAndView showDetail(HttpServletRequest req, HttpServletResponse resp, @PathVariable String category, @PathVariable String id) throws Exception {
		DiaryBO  diary = diaryService.getDiaryByID(id);
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(5);
		req.setAttribute("diary", diary);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("category", category);
		return new ModelAndView("blog/detail");
	}
	
	@RequestMapping(value="/reply/{id}")
	private void getDairyReply(HttpServletRequest req, HttpServletResponse resp, @PathVariable String id){
		List<DiaryReplyBO> replyList = diaryService.getDiaryReplyListById(id);
		
		PrintWriter out;
		Gson gson = new Gson();
		try {
			resp.setContentType("text/plain;charset=utf-8");
			out = resp.getWriter();
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("success", Boolean.TRUE);
			resultMap.put("replyList", replyList);
			out.print(gson.toJson(resultMap));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
