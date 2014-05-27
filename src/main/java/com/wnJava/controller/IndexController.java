package com.wnJava.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.LeaveMsgBO;
import com.wnJava.bo.UserBO;
import com.wnJava.service.DiaryService;
import com.wnJava.service.UserService;
import com.wnJava.vo.AppInfoVO;

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
		List<DiaryBO> diaries = diaryService.getNewDiaryList(12);
		// 获取应用统计信息
		AppInfoVO infoVO = new AppInfoVO();
		infoVO.setDiaryCount(diaryService.getTotalDiaryCount());
		infoVO.setNewsCount(26);
		infoVO.setSolutionCount(31);
		infoVO.setUserCount(userService.getUsers().size());
		
		// 获取活跃用户
		List<UserBO> activeUsers = userService.getActiveUsers(16);
		// 获取热门日志
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(12);
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

		req.setAttribute("appInfo", infoVO);
		req.setAttribute("latestDiaries", diaries);
		req.setAttribute("leaveMsgs", leaveMsgs);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("activeUsers", activeUsersList);
		return new ModelAndView("index");
	}
	
	

}
