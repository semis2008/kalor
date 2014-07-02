package com.wnJava.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import com.wnJava.util.StringUtil;
import com.wnJava.vo.TagVO;

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
	public DiaryBO getTopDiaryRand() {
		List<DiaryBO> topDiaries = diaryDao.queryDiaryByStatus("top");
		int index = 0;
		index = (int) (Math.random()*(topDiaries.size()+1))-1;
		if(index<0) {
			index=0;
		}else if(index==topDiaries.size()) {
			index--;	
		}
		return topDiaries.get(index);
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
	public List<DiaryBO> getDiaryList(int start, int end) {
		return diaryDao.queryAllDiaryList(start, end);
	}


	@Override
	public List<String> getAllTags() {
		List<String> tagStrs = diaryDao.queryAllTags();
		List<String> tags = new ArrayList<String>();
		for(String tagStr:tagStrs) {
			String[] tagArr = tagStr.split("_") ;
			for(String tag:tagArr) {
				if(!tag.equals(""))
					tags.add(tag);
			} 
		}
		return StringUtil.removeDuplicate(tags);
	}
	@Override
	public List<TagVO> getHotTags() {
		List<TagVO> hotTags = new ArrayList<TagVO>();
		hotTags.add(new TagVO("Js","2"));
		hotTags.add(new TagVO("Java","4"));
		hotTags.add(new TagVO("Linux","1"));
		hotTags.add(new TagVO("Html5","1"));
		hotTags.add(new TagVO("测试","2"));
		hotTags.add(new TagVO("MySql","2"));
		hotTags.add(new TagVO("转载","3"));
		hotTags.add(new TagVO("公告","4"));
		hotTags.add(new TagVO("面试","3"));
		hotTags.add(new TagVO("CSS","3"));
		hotTags.add(new TagVO("开发计划","3"));
		return hotTags;
		
	}
	@Override
	public int getDiaryCountByUser(Long userId) {
		return diaryDao.queryDiaryNumByUserId(userId);
	}

}
