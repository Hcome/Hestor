package com.hqyj.model.vo;

public class SearchInfo {

	private Integer currentPage;
	private Integer pageSize;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null ? 4 : pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage > 0 ? currentPage : 1;
	}

	@Override
	public String toString() {
		return "SearchInfo [currentPage=" + currentPage + ", pageSize=" + pageSize + "]";
	}

}
