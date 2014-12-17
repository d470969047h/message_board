package com.shinowit.messageboard.dao;

import java.util.List;

import com.shinowit.messageboard.model.Message;
import com.shinowit.messageboard.model.PageInfo;

public interface IMessageDAO {
	List<Message> queryForPage(int pageSize,int pageIndex);
	
	int getTotalMsgCount();
	
	public PageInfo getPageInfo(int pageSize,int currentPageIndex);
}
