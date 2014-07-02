package com.wnJava.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.wnJava.bo.UserBO;
import com.wnJava.service.DiaryService;
import com.wnJava.service.UserService;
import com.wnJava.vo.UserVO;

public class WebUtil {
	public static UserVO getLoginUserInfo(UserService userService, DiaryService diaryService) {
		Subject currentUser = SecurityUtils.getSubject();
		UserBO user = userService.getUserByName((String) currentUser.getPrincipal());
		if (user == null) {
			return null;
		} else {
			UserVO userVO = user.toVO();
			userVO.setBlogNum(diaryService.getDiaryCountByUser(user.getId()));
			return userVO;
		}
	}
}
