package com.wnJava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Lucence监听控制
 * @author Kalor
 *
 */
@Controller
@RequestMapping("/lucence")
public class LucenceController {
	 
	/**
	 * 
	  * 显示lucence监听主页
	  *
	  * @autor: wn  2014-5-23 下午1:39:51
	  * @param req
	  * @param resp
	  * @return
	 */
	@RequestMapping
	private ModelAndView showIndex(HttpServletRequest req, HttpServletResponse resp) {
		//获取当前配置信息
		//获取field条目以及对应的索引数目
		//获取删除的索引信息
		
		return new ModelAndView("lucence/index");
	}
}
