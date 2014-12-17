package com.shinowit.messageboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shinowit.messageboard.dao.IMessageDAO;
import com.shinowit.messageboard.model.Message;
import com.shinowit.messageboard.model.PageInfo;
import com.shinowit.messageboard.model.UserInfo;
import com.shinowit.messageboard.utils.BaseDAO;

public class MessageDAOImpl implements IMessageDAO {

	@Override
	public List<Message> queryForPage(int pageSize, int pageIndex) {
		List<Message> result=new ArrayList<Message>();
		
		String sql="select top "+pageSize+" message.*,userinfo.nick_name,userinfo.pic from message "
				+ " inner join userinfo on message.user_id=userinfo.user_id where message.msg_id not in "
				+ " ( select top "+(pageIndex-1)*pageSize+" message.msg_id from message order by post_time desc ) order by post_time desc";
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = BaseDAO.getConn();
			pstmt=conn.prepareStatement(sql);	
			rs=pstmt.executeQuery();
			while(rs.next()){
				Message msg=new Message();
				msg.setMsgId(rs.getInt("msg_id"));
				msg.setMsgContent(rs.getString("msg_content"));
				msg.setPostTime(rs.getTimestamp("post_time"));
				msg.setUserId(rs.getInt("user_id"));
				
				UserInfo userinfo=new UserInfo();
				userinfo.setNick_name(rs.getString("nick_name"));
				userinfo.setPic(rs.getString("pic"));
				
				msg.setUserInfo(userinfo);
				
				result.add(msg);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDAO.close(rs);
			BaseDAO.close(pstmt);
			BaseDAO.close(conn);
		}
		
		return result;
	}

	@Override
	public int getTotalMsgCount() {
		String sql="select count(0) from message";
		Integer size = BaseDAO.queryForInt(sql,new Object[] {}, new int[] {});
		return size;
	}

	@Override
	public PageInfo getPageInfo( int pageSize,int currentPageIndex) {
		String sql="select count(0) from message";
		int recordCount = BaseDAO.queryForInt(sql,new Object[] {}, new int[] {});
		PageInfo result=new PageInfo();
		result.setPageInfo(recordCount, pageSize, currentPageIndex);
		return result;
	}

	
	}
	
