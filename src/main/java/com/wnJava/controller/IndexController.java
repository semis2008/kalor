package com.wnJava.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.wnJava.util.DateUtil;
import com.wnJava.util.UserUtil;
import com.wnJava.vo.AppInfoVO;
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
	 * 
	 * @param req
	 * @param resp
	 */
	private ModelAndView showMainPage(HttpServletRequest req,
			HttpServletResponse resp) {
		UserBO user = new UserBO();
		/*
		 * 默认访问kalor的主页
		 */
		// 查询访问用户基本信息，返回前台
		// user = userService.getUserByID(param);
		// 将被访问的用户信息放入session
		UserUtil.addVisitedUserSession(req, user);
		// 查询访问用户详细信息，返回前台
		// UserInfoBO info = userService.getUserInfoByID(param);
		// 获取用户的最新日志信息
		// FIXME 最新图册信息需要在开发完图册模块之后再开发
		List<DiaryBO> newDiaryList = diaryService
				.getUserNewDiaryList(req, resp);
		// 获取给该用户的留言
		List<LeaveMsgBO> leaveMsgList = userService.getUserLeaveMsg(user
				.getId());

		req.setAttribute("leaveMsgList", leaveMsgList);
		req.setAttribute("newDiaryList", newDiaryList);
		req.setAttribute("visitedUser", user);
		// req.setAttribute("visitedUserInfo", info);
		return new ModelAndView("mainPage");
	}

	/**
	 * 显示主页
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping
	private ModelAndView showIndex(HttpServletRequest req,
			HttpServletResponse resp) {
		// 获取最新日志
		List<DiaryBO> diaries = diaryService.getNewDiaryList();
		// 随机获取推荐日志
		DiaryBO topDiary = diaryService.getTopDiaryRand();
		// 获取应用统计信息
		AppInfoVO infoVO = new AppInfoVO();
		infoVO.setDiaryCount(diaryService.getTotalDiaryCount());
		infoVO.setNewsCount(26);
		infoVO.setSolutionCount(31);
		infoVO.setUserCount(userService.getUsers().size());
		
		// 获取活跃用户
		List<UserBO> activeUsers = userService.getActiveUsers(16);
		// 获取热门日志
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries();
		// 获取留言
		List<LeaveMsgBO> leaveMsgs = userService.getLeaveMsg(10);

		// 构造前台所需的Activeuserlist
		List<List<UserBO>> activeUsersList = new ArrayList<List<UserBO>>();
		for (int i = 0; i < activeUsers.size(); i += 2) {
			List<UserBO> rowUsers = new ArrayList<UserBO>();
			rowUsers.add(activeUsers.get(i));
			rowUsers.add(activeUsers.get(i + 1));
			activeUsersList.add(rowUsers);
		}

		// 拼装vo
		List<DiaryBO> latestDiaries = new ArrayList<DiaryBO>();
		for (DiaryBO bo : diaries) {
			Date date = bo.getPublish_time();
			bo.setTime_before(DateUtil.getPassedTime(date));
			latestDiaries.add(bo);
		}
		List<DiaryBO> hotDiariesList = new ArrayList<DiaryBO>();
		for (DiaryBO bo : hotDiaries) {
			Date date = bo.getPublish_time();
			bo.setTime_before(DateUtil.getPassedTime(date));
			hotDiariesList.add(bo);
		}

		req.setAttribute("appInfo", infoVO);
		req.setAttribute("latestDiaries", latestDiaries);
		req.setAttribute("leaveMsgs", leaveMsgs);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("activeUsers", activeUsersList);
		return new ModelAndView("new/index");
	}

	/**
	 * 显示主页右侧内容
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	private String showIndexRight(HttpServletRequest req,
			HttpServletResponse resp) {
//		// 随机获取推荐日志
//		DiaryBO topDiary = diaryService.getTopDiaryRand();
//		// 获取热门日志
//		Map<String, List<DiaryBO>> hotDiaries = diaryService.getHotDiaries();
//		// 用于留言判断
//		UserBO user = UserUtil.getLoginUser(req, resp);
//		if (user != null) {
//			req.setAttribute("hasLogin", "true");
//		} else {
//			req.setAttribute("hasLogin", "false");
//		}
//		req.setAttribute("hotDiaries", hotDiaries);
//		req.setAttribute("topDiary", topDiary);
		return "/jsp/indexPageHtml.jsp";
	}

	/**
	 * 日志业务处理
	 * 
	 * @param req
	 * @param resp
	 */
	private String showDiary(HttpServletRequest req, HttpServletResponse resp) {
		List<DiaryBO> diaries = new ArrayList<DiaryBO>();
		diaries = diaryService.getAllDiaryList(req, resp);
		req.setAttribute("diaries", diaries);
		return "/jsp/diaryPageHtml.jsp";
	}

	/**
	 * 显示写日志页面
	 * 
	 * @param req
	 * @param resp
	 */
	private String showNewDiary(HttpServletRequest req, HttpServletResponse resp) {
		return "/jsp/newDiaryHtml.jsp";
	}

	/**
	 * 显示编辑日志页面
	 * 
	 * @param req
	 * @param resp
	 */
	private String showEditDiary(HttpServletRequest req,
			HttpServletResponse resp) {
		// 获取日志信息，代入
		String diaryId = req.getParameter("p1");
		DiaryBO diary = diaryService.getDiaryByID(diaryId);
		req.setAttribute("diary", diary);
		return "/jsp/editDiary.jsp";
	}

	/**
	 * 日志详情业务处理
	 * 
	 * @param req
	 * @param resp
	 */
	private String showDiaryDetail(HttpServletRequest req,
			HttpServletResponse resp) {
		String param = req.getParameter("p1");
		/*
		 * 参数是日志id,获取日志详情信息
		 */
		// 获取日志主要内容
		DiaryBO diary = diaryService.getDiaryByID(param);
		// 获取日志回复信息
		List<DiaryReplyBO> replies = diaryService.getDiaryReplyListById(param);
		// 更新日志的阅读数
		diaryService.updateDiaryRead(param);
		req.setAttribute("replies", replies);
		req.setAttribute("diary", diary);
		return "/jsp/diaryDetailHtml.jsp";
	}

}
