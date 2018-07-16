package com.ybl.net.commom.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页VO
 * 
 * @author 
 * @data 2017年4月17日
 */
@SuppressWarnings("serial")
public class PageVo<T> implements Serializable {

	//private static final long serialVersionUID = 1L;

	/**
	 * 总记录数
	 */
	private int totalRecort;
	
	/**
	 * 总页面数
	 */
	private int totalPage;

	/**
	 * 当前页
	 */
	private int currentPage;
	
	/**
	 * 上一页
	 */
	private int prevPage;
	
	/**
	 * 下一页
	 */
	private int nextPage;

	/**
	 * 每页最大记录数，默认为20
	 */
	private int pageSize = 20;

	/**
	 * 记录开始查询下标
	 */
	private int startRecordIndex;

	/**
	 * 记录
	 */
	private List<T> entrys;
	
	public boolean isHasNextPage(){
		return totalRecort > pageSize ? true:false;
	}
	
	public PageVo(int currentPage){
		this.setCurrentPage(currentPage);
	}

	public int getTotalRecort() {
		return totalRecort;
	}

	public void setTotalRecort(int totalRecort) {
		this.totalRecort = totalRecort;
		int n = totalRecort % pageSize;
		totalPage = n > 0 ? totalRecort / pageSize+1:totalRecort / pageSize;
		if(totalRecort > 0){
			currentPage = currentPage > totalPage ? totalPage:currentPage;
		} else {
			currentPage = 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if(currentPage <= 0) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRecordIndex() {
		startRecordIndex = (this.currentPage - 1) * this.pageSize;
		return startRecordIndex;
	}
	
	public int getNextPage() {
		nextPage = currentPage >= totalPage ? totalPage:currentPage+1;
		return nextPage;
	}

	public int getPrevPage() {
		prevPage = currentPage-1 <= 0 ? 1:currentPage-1;
		return prevPage;
	}

	public List<T> getEntrys() {
		return entrys;
	}

	public void setEntrys(List<T> entrys) {
		this.entrys = entrys;
	}

	public int getTotalPage() {
		return totalPage;
	}
}
