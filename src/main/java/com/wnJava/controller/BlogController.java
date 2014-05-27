package com.wnJava.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.bo.DiaryBO;
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
	private ModelAndView showIndex(HttpServletRequest req, HttpServletResponse resp, @PathVariable String category) throws Exception {
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
}
