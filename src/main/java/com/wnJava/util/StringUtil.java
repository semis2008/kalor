package com.wnJava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * String对象操作的辅助类
 * 
 * @author kalor
 * @time 2012-12-17
 */
public class StringUtil {
	/**
	 * 对用户密码进行加密
	 * 
	 * @param password
	 * @return
	 */
	public static String passEncrypt(String password) {
		String temp = EncryptUtil.Encrypt(password, null);
		password = temp + "asdasd";
		return EncryptUtil.Encrypt(password, null);
	}
	
	/**
	 * 
	  * 过滤Str中全部的html标签及内容,
	  *
	  * @autor: wn  2014-4-14 上午11:50:05
	  * @param srcStr
	  * @return    
	  * @return String 会对Str中转码的html信息反转：&lt;--> '<'
	 */
	public static String escapeHtmlTags(String srcStr) {
		String tarStr = "";
		Pattern p = Pattern.compile("<[^>]+>");
		Matcher m = p.matcher(srcStr);
		tarStr = StringEscapeUtils.unescapeHtml(m.replaceAll(""));
		return tarStr;
	}
}
