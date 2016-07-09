package main.com.njupt.kb.domain;

import java.util.List;

public class PageModel {
	
	private int pageNo;		//页号数
	private int pageSize;	//每页大小
	private int totalRecords; //总的记录条数
	private String keyword;//查询的关键词
	private List list;	//存放数据
	
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	/**
	 * 返回首行记录位置
	 * @return
	 */
	public int firstResult(){
		return (pageNo-1)*pageSize;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
