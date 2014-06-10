package com.wnJava.bo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wnJava.search.Searchable;
import com.wnJava.util.DateUtil;

public class DiaryBO implements Searchable{
	private Long id;
	private String title;
	private String content;
	private Long author_id;
	private String author_name;
	private Date publish_time;
	private String tags;
	private Long read_num;
	private Long reply_num;
	private String status;
	private String author_photo;
	private String time_before;

	public String getTime_before() {
		return DateUtil.getPassedTime(publish_time);
	}

	public void setTime_before(String time_before) {
		this.time_before = time_before;
	}
	
	public String getAuthor_photo() {
		return author_photo;
	}
	public void setAuthor_photo(String author_photo) {
		this.author_photo = author_photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRead_num() {
		return read_num;
	}
	public void setRead_num(Long read_num) {
		this.read_num = read_num;
	}
	public Long getReply_num() {
		return reply_num;
	}
	public void setReply_num(Long reply_num) {
		this.reply_num = reply_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getTags() {
		return tags;
	} 
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(Searchable o) {
		return 0;
	}

	@Override
	public long id() {
		return this.id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public List<String> storeFields() {
		return Arrays.asList("title","author_id","author_name","publish_time","tags","read_num","reply_num","author_photo");
	}

	@Override
	public List<String> indexFields() {
		return Arrays.asList("title","author_name","tags","content");
	}

	@Override
	public float boost() {
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