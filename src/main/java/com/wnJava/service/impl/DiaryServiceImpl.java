package com.wnJava.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.bo.UserBO;
import com.wnJava.dao.DiaryDao;
import com.wnJava.service.DiaryService;

/**
 * 日志业务处理接口实现类
 * 
 * @author kalor
 * @time 2013-1-24 at 下午04:14:37
 */
@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

	@Resource
	private DiaryDao diaryDao;
	 
	@Override
	public List<DiaryBO> getHotDiaries(int num) {
		List<DiaryBO> diaries = diaryDao.queryDiaryOrderByReadNum(0, num);
		 
		return diaries;
	}

	 
	@Override
	public List<DiaryBO> getNewDiaryList(int num) {
		return diaryDao.queryAllDiaryList(0, num);
	}

	@Override
	public DiaryBO getDiaryByID(String diaryId) {
		return diaryDao.queryDiaryById(Long.parseLong(diaryId));
	}
 

	@Override
	public DiaryReplyBO getDiaryReplyById(String replyId) {
		return diaryDao.queryDiaryReplyById(Long.parseLong(replyId));
	}

	@Override
	public List<DiaryReplyBO> getDiaryReplyListById(String diaryid) {
		return diaryDao.queryDiaryReplyListById(Long.parseLong(diaryid));
	}

	@Override
	public int updateDiaryRead(String diaryid) {
		return diaryDao.updateDiaryRead(diaryid);
	}

	@Override
	public int getTotalDiaryCount() {
		return diaryDao.queryTotalDiaryCount();
	}


	@Override
	public List<DiaryBO> getDiaryListByCategory(String category, int start, int end) {
		return diaryDao.queryAllDiaryList(start, end);
	}

}
