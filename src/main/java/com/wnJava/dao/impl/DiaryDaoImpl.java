package com.wnJava.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.wnJava.bo.DiaryBO;
import com.wnJava.bo.DiaryReplyBO;
import com.wnJava.bo.UserBO;
import com.wnJava.dao.DiaryDao;
import com.wnJava.dao.template.DbUtilsTemplate;
import com.wnJava.util.DateUtil;

/**
 * 用户数据操作接口实现类
 * 
 * @author Kalor
 * @time 2012-12-17
 */
@Repository("diaryDao")
public class DiaryDaoImpl implements DiaryDao {
	@Resource
	private DbUtilsTemplate dbUtilsTemplate;

	@Override
	public String insertDiary(String title, String tags, String diaryContent,
			Long userId,String userName,String userPhoto) {
		String sql = "insert into diary(title,content,author_id,author_photo,author_name,publish_time,tags,status) values (?,?,?,?,?,now(),?,'normal')";
		Object[] params = {title,diaryContent,userId,userPhoto,userName,tags};
		dbUtilsTemplate.update(sql, params);
		return Integer.parseInt(dbUtilsTemplate.getLastActPriId()+"")+"";
	}

	@Override
	public List<DiaryBO> queryDiaryByStatusExcept(String status, String id) {
		String sql = "select * from diary where status = ? and id <> ?";
		Object[] params = {status,id};
		return dbUtilsTemplate.find(DiaryBO.class, sql,params);
	}

	@Override
	public List<DiaryBO> queryUserDiaryList(Long userId, int start, int end) {
		String sql = "select * from diary where author_id = ? and status != 'delete' order by publish_time desc limit ?,?";
		Object[] param = {userId,start,end};
		return dbUtilsTemplate.find(DiaryBO.class, sql, param);
	}

	@Override
	public List<DiaryBO> queryAllDiaryList(int start, int end) {
		String sql = "select * from diary where 1=1 and status != 'delete' order by publish_time desc limit ?,?";
		Object[] param = {start,end};
		return dbUtilsTemplate.find(DiaryBO.class, sql, param);
	}
	
	@Override
	public int queryDiaryNumByUserId(Long userId) {
		String sql = "select count(*) totalNum from diary where author_id = ? and status != 'delete'";
		Map<String,Object> result = dbUtilsTemplate.findFirst(sql, userId);
		return Integer.parseInt((Long)result.get("totalNum")+"");
		
	}

	@Override
	public String updateDiary(Long diaryId, String title, String tags,
			String diaryContent) {
		String sql = "update diary set title = ? ,tags = ?,content = ? where id = ?";
		Object[] params = {title,tags,diaryContent,diaryId};
		return dbUtilsTemplate.update(sql, params)+"";
	}

	@Override
	public DiaryBO queryDiaryById(Long diaryId) {
		String sql = "select * from diary where id = ?";
		return dbUtilsTemplate.findFirst(DiaryBO.class, sql,diaryId);
	}

	@Override
	public List<DiaryBO> queryDiaryByStatus(String status) {
		String sql = "select * from diary where status = ?";
		return dbUtilsTemplate.find(DiaryBO.class, sql,status);
	}

	@Override
	public int insertReply(String diaryId, String parentName, String parentId, String reply,
			UserBO user) {
		String sql = "insert into diary_reply (diary_id,user_id,user_name,reply,email,reply_time,parent_name,parent_id,user_photo,type) values(?,?,?,?,?,now(),?,?,?,?)";
		Object[] params = {diaryId,user.getId(),user.getName(),reply,user.getEmail(),parentName,parentId,user.getPhoto(),"1"};
		dbUtilsTemplate.update(sql, params);
		return Integer.parseInt(dbUtilsTemplate.getLastActPriId()+"");
	}

	@Override
	public int insertReply(String diaryId,String parentName, String parentId, String reply,
			String name, String email, String website) {
		String sql = "insert into diary_reply (diary_id,user_name,reply,email,website,reply_time,parent_name,parent_id,user_photo,type) values(?,?,?,?,?,now(),?,?,?,?)";
		Object[] params = {diaryId,name,reply,email,website,parentName,parentId,"/img/head/default/defaultGuest.jpg","0"};
		dbUtilsTemplate.update(sql, params);
		return  Integer.parseInt(dbUtilsTemplate.getLastActPriId()+""); 
	}

	@Override
	public DiaryReplyBO queryDiaryReplyById(Long id) {
		String sql =  "select * from diary_reply where id=?";
		return dbUtilsTemplate.findFirst(DiaryReplyBO.class, sql, id);
	}

	@Override
	public List<DiaryReplyBO> queryDiaryReplyListById(Long diaryid) {
		String sql =  "select * from diary_reply where diary_id=? order by parent_id asc";
		return dbUtilsTemplate.find(DiaryReplyBO.class, sql, diaryid);
	}

	@Override
	public int updateDiaryReplyNum(String diaryid) {
		String sql = "update diary set reply_num = reply_num + 1 where id = ?";
		return dbUtilsTemplate.update(sql, diaryid);
	}

	@Override
	public int updateDiaryRead(String diaryid) {
		String sql = "update diary set read_num = read_num + 1 where id = ?";
		return dbUtilsTemplate.update(sql, diaryid);
	}

	@Override
	public int queryTotalDiaryCount() {
		String sql = "select count(*) totalNum from diary where 1=1 and status != 'delete'";
		Map<String,Object> result = dbUtilsTemplate.findFirst(sql,null);
		return Integer.parseInt((Long)result.get("totalNum")+"");
	}

	@Override
	public int updateDiaryState(String diaryid,String state) {
		String sql = "update diary set diary.status = ? where id = ?";
		Object[] param = {state,diaryid};
		return dbUtilsTemplate.update(sql, param);
	}

	@Override
	public List<DiaryBO> queryDiaryOrderByReadNum(int start, int end) {
		String sql = "select * from diary where status != 'delete' order by read_num desc limit ?,?";
		Object[] param = {start,end};
		return dbUtilsTemplate.find(DiaryBO.class, sql, param);
	}

	@Override
	public List<String> queryAllTags() {
		String sql = "select tags from diary where status != 'delete'";
		List<Map<String,Object>> result = dbUtilsTemplate.find(sql);
		List<String> resultList = new ArrayList<String>();
		for(Map<String,Object> res:result) {
			String tag = (String) res.get("tags");
			resultList.add(tag);
		}
		return resultList; 
	}
}
