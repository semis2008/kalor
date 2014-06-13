package com.wnJava.vo.lucence;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wnJava.bo.DiaryBO;
import com.wnJava.search.Searchable;
import com.wnJava.util.DateUtil;

public class DiaryVO implements Searchable {
	private Long id;
	private String title;
	private String author_id;
	private String author_name;
	private String publish_time;
	private String tags;
	private String read_num;
	private String reply_num;
	private String author_photo;
	private String all_have;
	
	
	public static DiaryVO getVO(DiaryBO bo) {
		DiaryVO vo = new DiaryVO();
		vo.setId(bo.getId());
		vo.setTitle(bo.getTitle());
		vo.setAuthor_id(bo.getAuthor_id()+"");
		vo.setAuthor_name(bo.getAuthor_name());
		vo.setPublish_time(DateUtil.formatDate(bo.getPublish_time(),3));
		vo.setTags(bo.getTags());
		vo.setRead_num(bo.getRead_num()+"");
		vo.setReply_num(bo.getReply_num()+"");
		vo.setAuthor_photo(bo.getAuthor_photo());
		return vo;
	}
	
	
	

	public String getAll_have() {
		return all_have;
	}

	public void setAll_have(String all_have) {
		this.all_have = all_have;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getRead_num() {
		return read_num;
	}

	public void setRead_num(String read_num) {
		this.read_num = read_num;
	}

	public String getReply_num() {
		return reply_num;
	}

	public void setReply_num(String reply_num) {
		this.reply_num = reply_num;
	}

	public String getAuthor_photo() {
		return author_photo;
	}

	public void setAuthor_photo(String author_photo) {
		this.author_photo = author_photo;
	}

	@Override
	public int compareTo(Searchable o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long id() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> storeFields() {
		return Arrays.asList("all_have", "title", "author_id", "author_name", "publish_time", "tags", "read_num", "reply_num", "author_photo");
	}

	@Override
	public List<String> indexFields() {
		return Arrays.asList("title", "author_name", "tags");
	}

	@Override
	public float boost() {
		// TODO Auto-generated method stub
		return 1.0f;
	}

	@Override
	public Map<String, String> extendStoreDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> extendIndexDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Searchable> ListAfter(long id, int count) {
		// TODO Auto-generated method stub
		return null;
	}
}