package com.shinowit.messageboard.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageReply {
	
	private int  reply_msg_id;
	
	private int msg_id;
	
	private int user_id;
	
	private Timestamp reply_time;
	
	private String reply_content;
	
	private UserInfo replayUserInfo;

	public int getReply_msg_id() {
		return reply_msg_id;
	}

	public void setReply_msg_id(int reply_msg_id) {
		this.reply_msg_id = reply_msg_id;
	}

	public int getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getReply_time() {
		return reply_time;
	}

	public void setReply_time(Timestamp reply_time) {
		this.reply_time = reply_time;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public UserInfo getReplayUserInfo() {
		return replayUserInfo;
	}

	public void setReplayUserInfo(UserInfo replayUserInfo) {
		this.replayUserInfo = replayUserInfo;
	}
	
	public 	String getReplyTimeString(){
		String result=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date= new Date(reply_time.getTime());
		result=sdf.format(date);
		return result;
		
	}
}
