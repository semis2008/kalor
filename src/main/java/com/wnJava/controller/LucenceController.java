package com.wnJava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wnJava.search.IndexHolder;

@Controller
@RequestMapping(value = "/lucence")
public class LucenceController {
	
	@RequestMapping
	private ModelAndView showLucencePage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IndexHolder holder = IndexHolder.getInstance();
		
		
		
		return new ModelAndView("/lucence/index");
	}
}
