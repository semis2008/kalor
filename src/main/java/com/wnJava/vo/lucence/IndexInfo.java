package com.wnJava.vo.lucence;

import java.util.List;

import com.wnJava.search.Searchable;

public class IndexInfo {
	private int maxDocCount;
	private int delDocCount;
	private int docCount;

	private String name;//索引的实体名
	private List<Searchable> searchables;//实体类
	
	public String getName() {
		return name;
	}
	public List<Searchable> getSearchables() {
		return searchables;
	}
	public void setSearchables(List<Searchable> searchables) {
		this.searchables = searchables;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxDocCount() {
		return maxDocCount;
	}
	public void setMaxDocCount(int maxDocCount) {
		this.maxDocCount = maxDocCount;
	}
	public int getDelDocCount() {
		return delDocCount;
	}
	public void setDelDocCount(int delDocCount) {
		this.delDocCount = delDocCount;
	}
	public int getDocCount() {
		return docCount;
	}
	public void setDocCount(int docCount) {
		this.docCount = docCount;
	}
	
	
	
	
}
