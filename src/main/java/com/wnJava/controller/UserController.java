package com.wnJava.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.LeaveMsgBO;
import com.wnJava.bo.UserBO;
import com.wnJava.service.DiaryService;
import com.wnJava.service.UserService;
import com.wnJava.util.JsonUtil;
import com.wnJava.util.StringUtil;
import com.wnJava.vo.AppInfoVO;
import com.wnJava.vo.TagVO;

/**
 * 用户相关处理类
 * 
 * @author Kalor
 * @time 2012-12-14
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private DiaryService diaryService;

	/**
	 * 登陆
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajax/login")
	private void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String email = (String) req.getParameter("email");
		String password = (String) req.getParameter("password");
		// 1. 接受提交的当事人和证书：
		AuthenticationToken token = new UsernamePasswordToken(email, StringUtil.passEncrypt(password));
		// 2. 获取当前Subject：
		Subject currentUser = SecurityUtils.getSubject();
		// 3. 登录：
		try {
			currentUser.login(token);
		} catch (IncorrectCredentialsException ice) {
			JsonUtil.outputDTOToJSON("密码错误", false, resp);
		} catch (LockedAccountException lae) {
			JsonUtil.outputDTOToJSON("账户被锁定", false, resp);
		} catch (AuthenticationException ae) {
			JsonUtil.outputDTOToJSON("授权失败", false, resp);
		}
		JsonUtil.outputDTOToJSON(null, true, resp);
	}

	/**
	 * 显示主页
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	private ModelAndView showLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 获取热门日志
		List<DiaryBO> hotDiaries = diaryService.getHotDiaries(18);
		List<DiaryBO> leftHotList = hotDiaries.subList(0, 8);
		List<DiaryBO> rightHotList = hotDiaries.subList(9, 17);
		req.setAttribute("leftHotDiary", leftHotList);
		req.setAttribute("rightHotDiary", rightHotList);
		return new ModelAndView("login");
	}

	/**
	 * 显示主页
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist")
	private ModelAndView showRegist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 获取活跃用户
		List<UserBO> activeUsers = userService.getActiveUsers(8);
		// 获取留言
		List<LeaveMsgBO> leaveMsgs = userService.getLeaveMsg(5);
		req.setAttribute("leaveMsgs", leaveMsgs);
		req.setAttribute("activeUsers", activeUsers);
		return new ModelAndView("regist");
	}
}
