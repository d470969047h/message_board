package com.shinowit.messageboard.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Message {
	private int msgId;
		
	private int	 userId;
	
	private Timestamp postTime;
	
	private String  msgContent;
	
	//一对一关系
	private UserInfo userInfo;
	
	//一对多关系，在一的地方写一个list列表
	private List<MessageReply> reply_list;

	public List<MessageReply> getReply_list() {
		return reply_list;
	}

	public void setReply_list(List<MessageReply> reply_list) {
		this.reply_list = reply_list;
	}

	public int getUserId() {
		return userId;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public 	String getPostTimeString(){
		String result=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date= new Date(postTime.getTime());
		result=sdf.format(date);
		return result;
		
	}
	
	
	
}
