package com.wnJava.controller;

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

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.service.DiaryService;
import com.wnJava.service.UserService;
import com.wnJava.util.DateUtil;
import com.wnJava.util.JsonUtil;
import com.wnJava.util.StringUtil;
import com.wnJava.util.WebUtil;
import com.wnJava.vo.TagVO;
import com.wnJava.vo.UserVO;

/**
 * blog
 * 
 * @author wn
 * @version 1.0.0 BlogController.java 2014-6-4 下午5:28:16
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private DiaryService diaryService;
	@Resource
	private UserService userService;

	/**
	 * 显示博客列表
	 * 
	 * @autor: wn 2014-5-27 下午3:11:12
	 * @param req
	 * @param resp
	 * @param category
	 * @return
	 * @throws Exception
	 */
	@RequestMapping
	private ModelAndView showList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<DiaryBO> diaries = diaryService.getDiaryList(0, 5);
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(4);
		for (DiaryBO bo : diaries) {
			bo.setContent(StringUtil.escapeHtmlTags(bo.getContent()));
		}
		List<TagVO> hotTags = diaryService.getHotTags();
		UserVO userVO = WebUtil.getLoginUserInfo(userService, diaryService);
		req.setAttribute("loginUser", userVO);
		req.setAttribute("diaries", diaries);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("hotTags", hotTags);
		return new ModelAndView("blog/list");
	}

	/**
	 * 显示博客详情
	 * 
	 * @autor: wn 2014-6-9 下午3:58:04
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}")
	private ModelAndView showBlog(HttpServletRequest req, HttpServletResponse resp, @PathVariable
	String id) throws Exception {
		DiaryBO bo = diaryService.getDiaryByID(id);
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(4);
		bo.setContent(StringUtil.escapeHtmlTags(bo.getContent()));
		List<TagVO> hotTags = diaryService.getHotTags();
		List<DiaryReplyBO> replyBOs = diaryService.getDiaryReplyListById(id);
		UserVO userVO = WebUtil.getLoginUserInfo(userService, diaryService);
		req.setAttribute("loginUser", userVO);
		req.setAttribute("diary", bo);
		req.setAttribute("replyList", replyBOs);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("hotTags", hotTags);
		return new ModelAndView("blog/detail");
	}

	@RequestMapping(value = "/ajax/list")
	private void getDiaryListByLastTime(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String index = (String) req.getParameter("index");
		String time = (String) req.getParameter("firstTime");
		List<DiaryBO> hotDiaries = diaryService.getDiaryList(Integer.parseInt(index), 2);
		Map<String, Object> param = new HashMap<String, Object>();
		// 第一次访问，返回时间参数，用于下一次访问时判断是否有新blog
		if (time.equals("0"))
			param.put("time", DateUtil.getTimeNow());
		param.put("success", true);
		JsonUtil.outputDTOToJSON(hotDiaries, param, resp);
	}
}
