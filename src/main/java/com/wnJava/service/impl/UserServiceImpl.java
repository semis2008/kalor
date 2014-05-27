package com.wnJava.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.wnJava.bo.LeaveMsgBO;
import com.wnJava.bo.UserBO;
import com.wnJava.dao.UserDao;
import com.wnJava.service.UserService;

/**
 * 用户业务处理接口实现类
 * 
 * @author Kalor
 * @time 2012-12-17
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public List<UserBO> getActiveUsers(int num) {
		return userDao.queryUsersOrderByLoginTime(num);
	}

	@Override
	public UserBO getUserByID(String id) {
		return userDao.queryUserByID(id);
	}

	@Override
	public List<LeaveMsgBO> getLeaveMsg(int num) {
		return userDao.queryLeaveMsg(0, num);
	}

	@Override
	public List<UserBO> getUsers() {
		return userDao.queryUsers();
	}
}
