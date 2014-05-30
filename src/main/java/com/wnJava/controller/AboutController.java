package com.wnJava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 关于--页面跳转
 * 
 * @author wn
 * @version 1.0.0 AboutController.java 2014-5-30 下午4:03:12
 */
@Controller
@RequestMapping("/about")
public class AboutController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/timeLine")
	public ModelAndView timeLine(HttpServletRequest req, HttpServletResponse resp) {
		return new ModelAndView("about/timeLine");
	}
}
