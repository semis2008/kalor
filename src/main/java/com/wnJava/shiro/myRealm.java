package com.wnJava.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.wnJava.bo.UserBO;
import com.wnJava.service.UserService;
import com.wnJava.util.StringUtil;

public class myRealm extends AuthorizingRealm {
	@Resource
	UserService userService;

	public myRealm() {
		super();
		// 设置认证token的实现类
		setAuthenticationTokenClass(UsernamePasswordToken.class);
		// 设置加密算法
//		setCredentialsMatcher(new HashedCredentialsMatcher(Md5Hash.ALGORITHM_NAME));
	}

	// 授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
		UserBO user = userService.getUserByName(loginName);
		if (null == user) {
			return null;
		} else {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Group group : CroupManager.getGroupByUserLevel(user.getUser_level())) {
				info.addStringPermissions(group.getPermissionList());
			}
			return info;
		}
	}

	// 认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		UserBO user = userService.getUserByName(upToken.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), getName());
		}
		return null;
	}
}