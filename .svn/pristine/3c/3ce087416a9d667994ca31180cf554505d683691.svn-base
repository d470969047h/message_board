package com.shinowit.messageboard.model;

public class PageInfo {
	
	private int pageSize;//每页显示记录条数
	
	private int currentPageIndex;//当前显示哪一页
	
	private int recordCount;//总记录数
	
	private int pageCount;//总页数
	
	
	public void setPageInfo(int recordCount,int pageSize,int currentPageIndex ){
		this.currentPageIndex=currentPageIndex;
		this.pageSize=pageSize;
		this.recordCount=recordCount;
		
		//计算总页数，每页分pageSize条记录
		this.pageCount=recordCount/pageSize;
			if(recordCount % pageSize>0){
				pageCount++;
			}
		}
	

	/**
	 * 取前一页页号
	 * @return
	 */
	public int getPriorPageNumber(){
		currentPageIndex=currentPageIndex-1;
		if(currentPageIndex<1){
			currentPageIndex=1;
		}
		return currentPageIndex;
	}
	
	/**
	 * 取后一页页号
	 * @return
	 */
	public int getNextPageNumber(){
		currentPageIndex=currentPageIndex+1;
		if(currentPageIndex>pageCount){
			currentPageIndex=pageCount;
		}
		return currentPageIndex;
	}

	/**
	 * 判断是否有前一页
	 * @return
	 */
	public boolean hasPriorPage(){
		return currentPageIndex<=1?false:true;
	}
	
	/**
	 * 判断是否有后一页
	 * @return
	 */
	public boolean hasNextPage(){
		return currentPageIndex>=pageCount?false:true;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
