package com.wnJava.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnJava.bo.LeaveMsgBO;
import com.wnJava.bo.UserBO;
import com.wnJava.bo.UserInfoBO;

/**
 * 用户业务处理接口
 * @author Kalor
 * @time 2012-12-17
 */
public interface UserService {
	
	/**
	 * 依据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户实体类
	 */
	UserBO getUserByID(String id);
	
	/**
	 * 依据用户id查询用户信息
	 * @param id 用户id
	 * @return 用户实体类
	 */
	UserBO getUserByName(String name);
	
	/**
	 * 获取活跃用户
	 * @param num 数目
	 * @return
	 */
	List<UserBO> getActiveUsers(int num);
	
	/**
	 * 获取系统前几条留言
	 * 
	 * @param num 数目
	 * @return
	 */
	List<LeaveMsgBO> getLeaveMsg(int num);
	
	/**
	 * 获取系统所有用户
	 * @return
	 */
	List<UserBO> getUsers();
	
}
