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
		List<DiaryBO> diaries = diaryService.getNewDiaryList(4);
		// 获取应用统计信息
		AppInfoVO infoVO = new AppInfoVO();
		infoVO.setDiaryCount(diaryService.getTotalDiaryCount());
		infoVO.setNewsCount(26);
		infoVO.setSolutionCount(31);
		infoVO.setUserCount(userService.getUsers().size());
		//随机获取推荐日志
		DiaryBO topDiary = diaryService.getTopDiaryRand();	
		// 获取活跃用户
		List<UserBO> activeUsers = userService.getActiveUsers(8);
		// 获取热门日志
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(10);
		// 获取留言
		List<LeaveMsgBO> leaveMsgs = userService.getLeaveMsg(5);

		 
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
		
		

		req.setAttribute("appInfo", infoVO);
		req.setAttribute("topDiary", topDiary);
		req.setAttribute("latestDiaries", diaries);
		req.setAttribute("leaveMsgs", leaveMsgs);
		req.setAttribute("hotDiaries", hotDiaries);
		req.setAttribute("activeUsers", activeUsers);
		return new ModelAndView("index");
	}
	
	

}
