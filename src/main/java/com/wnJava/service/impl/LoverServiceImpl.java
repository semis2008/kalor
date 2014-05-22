package com.wnJava.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.wnJava.bo.LoverInfoBO;
import com.wnJava.bo.TimeNodeBO;
import com.wnJava.dao.LoverDao;
import com.wnJava.service.LoverService;
import com.wnJava.util.DateUtil;
import com.wnJava.vo.LoveRoadVO;

@Service("loverService")
public class LoverServiceImpl implements LoverService {
	
	@Resource
	private LoverDao loverDao;

	 
	@Override
	public String saveMemmory(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String description = req.getParameter("detail");
		String position = req.getParameter("place");
		String weather = req.getParameter("weather");
		String dress = req.getParameter("dress");
		String mood = req.getParameter("mood");
		String time = req.getParameter("time");

		return loverDao.insertMemmory(name, description, position, weather,
				dress, mood, time) + "";
	}

	@Override
	public List<TimeNodeBO> getTimeNodes() {
		return loverDao.queryTimeNodes();
	}

	@Override
	public String uploadImg(String nodeId, String photo) {
		return loverDao.updateTimeNodeImg(nodeId,photo);
	}

	@Override
	public LoveRoadVO getLoveRoadInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		LoveRoadVO vo = new LoveRoadVO();
		// TODO 获取登录人的lover信息
		LoverInfoBO bo = loverDao.queryLoverInfo(1l);
		// 相识时间
		String passDayMeet = DateUtil.getPassedTime(bo.getMeetTime());
		if (!"".equals(passDayMeet)) {
			vo.setMeetDayPast(passDayMeet);
			vo.setMeetTime(bo.getMeetTime());
		}
		// 相爱时间
		String passDayLove = DateUtil.getPassedTime(bo.getLoveTime());
		if (!"".equals(passDayLove)) {
			vo.setLoveDayPast(passDayLove);
			vo.setLoveTime(bo.getLoveTime());
		}
		// 结婚时间
		String passDayMarriage = DateUtil.getPassedTime(bo.getMarriageTime());
		if (!"".equals(passDayMarriage)) {
			vo.setLoveDayPast(passDayMarriage);
			vo.setLoveTime(bo.getMarriageTime());
		}
		return vo;
	}

	@Override
	public String saveLoverInfo(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String birthday = req.getParameter("birthday");
		String meetTime = req.getParameter("meetTime");
		// TODO 一个用户只能添加一个记录，已经存在的记录会进行更新
		// 获取当前登录用户，目前默认是1
		LoverInfoBO bo = loverDao.queryLoverInfo(1l);
		if (bo == null) {
			return loverDao.insertLoverInfo(1l, name, gender, birthday,
					meetTime) + "";
		} else {
			return loverDao.updateLoverInfo(1l, name, gender, birthday,
					meetTime) + "";
		}
	}

	@Override
	public LoverInfoBO getLoverInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		return loverDao.queryLoverInfo(1l);
	}

}
