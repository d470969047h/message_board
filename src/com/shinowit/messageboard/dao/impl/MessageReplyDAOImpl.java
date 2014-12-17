package com.shinowit.messageboard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.shinowit.messageboard.dao.IMessageReplyDAO;
import com.shinowit.messageboard.model.MessageReply;
import com.shinowit.messageboard.model.UserInfo;
import com.shinowit.messageboard.utils.BaseDAO;
import com.shinowit.messageboard.utils.IMapListObject;



public class MessageReplyDAOImpl implements IMessageReplyDAO {

	@Override
	public List<MessageReply> queryForReplyByMsgId(int msg_id) {
		final List<MessageReply> result=new ArrayList<MessageReply>();
		String sql="select * from reply_msg inner join userinfo on reply_msg.user_id=userinfo.user_id  where reply_msg.msg_id=? ";
		BaseDAO.queryForList(sql, new Object[]{msg_id}, new int[]{Types.INTEGER},new IMapListObject() {
			
			@Override
			public List mappingToList(ResultSet rs) throws SQLException {
				try {
					while(rs.next()){
						MessageReply msgReply=new MessageReply();
						
						msgReply.setMsg_id(rs.getInt("msg_id"));
						msgReply.setReply_msg_id(rs.getInt("reply_msg_id"));
						msgReply.setReply_time(rs.getTimestamp("reply_time"));
						msgReply.setReply_content(rs.getString("reply_content"));
						msgReply.setUser_id(rs.getInt("user_id"));
						
						UserInfo userinfo=new UserInfo();
						userinfo.setLogin_name(rs.getString("login_name"));
						userinfo.setNick_name(rs.getString("nick_name"));
						userinfo.setUser_id(rs.getInt("user_id"));
						userinfo.setPic(rs.getString("pic"));
						
						msgReply.setReplayUserInfo(userinfo);
						
						result.add(msgReply);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			}
		}); 			
		return result;
	}

	}
	
