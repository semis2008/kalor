package com.wnJava.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.vo.TagVO;

/**
 * 日志业务处理类
 * 
 * @author kalor
 * @time 2013-1-24 at 下午04:12:06
 */
public interface DiaryService {

	List<DiaryBO> getDiaryList(int start,int end);
	
	List<TagVO> getHotTags();
	
	/**
	 * 获取最新日志列表 (取前4条)
	 * 
	 * @return
	 */
	List<DiaryBO> getNewDiaryList(int num);

	/**
	 * 通过日志id获取日志信息
	 * 
	 * @param diaryId
	 *            日志id
	 * @return 日志实体类
	 */
	DiaryBO getDiaryByID(String diaryId);

	/**
	 * 获取指定日志的所有回复
	 * 
	 * @param diaryid
	 *            日志id
	 * @return
	 */
	List<DiaryReplyBO> getDiaryReplyListById(String diaryid);

	/**
	 * 获取热门日志
	 * @return
	 */
	List<DiaryBO> getHotDiaries(int num);
	
	/**
	 * 获取指定id的回复
	 * 
	 * @param replyId
	 * @return
	 */
	DiaryReplyBO getDiaryReplyById(String replyId);

	/**
	 * 更新日志的阅读数
	 * 
	 * @param diaryid
	 *            日志id
	 * @return
	 */
	int updateDiaryRead(String diaryid);
	/**
	 * 依据状态获取日志
	 * @param status
	 * @return
	 */
	DiaryBO getTopDiaryRand();
	/**
	 * 获取系统日志总数
	 * 
	 * @return
	 */
	int getTotalDiaryCount();
	
	/**
	 * 
	  * 获取所有的tag
	  *
	  * @autor: wn  2014-5-29 下午3:30:35
	  * @return
	 */
	List<String> getAllTags();

}
