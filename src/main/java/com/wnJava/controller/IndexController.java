package com.wnJava.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.bo.LeaveMsgBO;
import com.wnJava.bo.UserBO;
import com.wnJava.service.DiaryService;
import com.wnJava.service.UserService;
import com.wnJava.util.UserUtil;
import com.wnJava.vo.TagVO;

/**
 * 系统响应处理类
 * 
 * @author Kalor
 * @time 2012-12-14
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private DiaryService diaryService;

	
	/**
	 * 个人主页业务处理
	 * @param req
	 * @param resp
	 */
	private ModelAndView showMainPage(HttpServletRequest req, HttpServletResponse resp) {
		UserBO user = new UserBO();
		/*
		 * 默认访问kalor的主页
		 */
		//查询访问用户基本信息，返回前台
//		user = userService.getUserByID(param);
		//将被访问的用户信息放入session
		UserUtil.addVisitedUserSession(req, user);
		//查询访问用户详细信息，返回前台
//		UserInfoBO info = userService.getUserInfoByID(param);
		//获取用户的最新日志信息
		//FIXME 最新图册信息需要在开发完图册模块之后再开发
		List<DiaryBO> newDiaryList = diaryService.getUserNewDiaryList(req,resp);
		//获取给该用户的留言 
		List<LeaveMsgBO> leaveMsgList = userService.getUserLeaveMsg(user.getId()); 
		
		req.setAttribute("leaveMsgList", leaveMsgList);
		req.setAttribute("newDiaryList", newDiaryList);
		req.setAttribute("visitedUser", user);
//		req.setAttribute("visitedUserInfo", info);
		return new ModelAndView("mainPage");
	}
	
	/**
	 * 显示主页
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping
	private ModelAndView showIndex(HttpServletRequest req, HttpServletResponse resp) {
		//获取最新日志
		List<DiaryBO> diaries = diaryService.getNewDiaryList();
		//随机获取推荐日志
		DiaryBO topDiary = diaryService.getTopDiaryRand();	
		//获取活跃用户
		List<UserBO> activeUsers = userService.getActiveUsers(8);
		//获取热门日志
		Map<String,List<DiaryBO>> hotDiaries = diaryService.getHotDiaries();
		//获取留言
		List<LeaveMsgBO> leaveMsgs = userService.getLeaveMsg(4);
		//获取热门tag
		//FIXME hotTag的计算需要进一步完善，目前只是写死的 
		List<TagVO> hotTags = new ArrayList<TagVO>();
		hotTags.add(new TagVO("Js","2"));
		hotTags.add(new TagVO("Java","4"));
		hotTags.add(new TagVO("Linux","1"));
		hotTags.add(new TagVO("Html5","1"));
		hotTags.add(new TagVO("测试","2"));
		hotTags.add(new TagVO("MySql","2"));
		hotTags.add(new TagVO("转载","3"));
		hotTags.add(new TagVO("公告","4"));
		hotTags.add(new TagVO("面试","3"));
		hotTags.add(new TagVO("CSS","3"));
		hotTags.add(new TagVO("开发计划","3"));
		
		req.setAttribute("hotTags", hotTags);
		req.setAttribute("latestDiaries", diaries);
		req.setAttribute("leaveMsgs", leaveMsgs);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("activeUsers", activeUsers);
		req.setAttribute("topDiary", topDiary);
		return new ModelAndView("new/index");
	}
	/**
	 * 显示主页右侧内容
	 * @param req
	 * @param resp
	 * @return
	 */
	private String showIndexRight(HttpServletRequest req, HttpServletResponse resp) {
		//随机获取推荐日志
		DiaryBO topDiary = diaryService.getTopDiaryRand();	
		//获取热门日志
		Map<String,List<DiaryBO>> hotDiaries = diaryService.getHotDiaries();
		//用于留言判断
		UserBO user = UserUtil.getLoginUser(req, resp);
		if(user!=null) {
			req.setAttribute("hasLogin", "true");
		}else {
			req.setAttribute("hasLogin", "false");
		}
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("topDiary", topDiary);
		return "/jsp/indexPageHtml.jsp";
	}
	
	/**
	 * 日志业务处理
	 * @param req
	 * @param resp
	 */
	private String showDiary(HttpServletRequest req, HttpServletResponse resp) {
		List<DiaryBO> diaries =new ArrayList<DiaryBO>();
		diaries = diaryService.getAllDiaryList(req,resp);
		req.setAttribute("diaries", diaries);
		return "/jsp/diaryPageHtml.jsp";
	}
	
	/**
	 * 显示写日志页面
	 * @param req
	 * @param resp
	 */
	private String showNewDiary(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/newDiaryHtml.jsp";
	}
	
	/**
	 * 显示编辑日志页面
	 * @param req
	 * @param resp
	 */
	private String showEditDiary(HttpServletRequest req, HttpServletResponse resp) {
		//获取日志信息，代入
		String diaryId = req.getParameter("p1");
		DiaryBO diary = diaryService.getDiaryByID(diaryId);
		req.setAttribute("diary", diary);
		return "/jsp/editDiary.jsp";
	}
	
	/**
	 * 日志详情业务处理
	 * @param req
	 * @param resp
	 */
	private String showDiaryDetail(HttpServletRequest req, HttpServletResponse resp) {
		String param = req.getParameter("p1");
		/*
		 * 参数是日志id,获取日志详情信息
		 */
		//获取日志主要内容
		DiaryBO diary = diaryService.getDiaryByID(param);
		//获取日志回复信息
		List<DiaryReplyBO> replies = diaryService.getDiaryReplyListById(param);
		//更新日志的阅读数
		diaryService.updateDiaryRead(param);
		req.setAttribute("replies", replies);
		req.setAttribute("diary", diary);
		return "/jsp/diaryDetailHtml.jsp";
	}
	
}
