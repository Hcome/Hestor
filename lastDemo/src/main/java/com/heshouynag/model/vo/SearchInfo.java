package com.heshouynag.model.vo;

import java.io.Serializable;

/**
 * 后端分页插件需要的两个关键参数
 * @author Administrator
 *
 */
public class SearchInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer currentPage;
	
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage > 0 ? currentPage : 1;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null ? 4:pageSize;
	}

	public SearchInfo(Integer currentPage, Integer pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public SearchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SearchInfo [currentPage=" + currentPage + ", pageSize=" + pageSize + "]";
	}
	
	
}
