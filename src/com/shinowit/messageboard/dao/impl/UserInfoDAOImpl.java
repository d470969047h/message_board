package com.shinowit.messageboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


import com.shinowit.messageboard.dao.IUserInfoDAO;
import com.shinowit.messageboard.model.UserInfo;
import com.shinowit.messageboard.utils.BaseDAO;
import com.shinowit.messageboard.utils.IMapObject;

public class UserInfoDAOImpl implements IUserInfoDAO {

	@Override
	public boolean create(UserInfo user) {
		boolean result = false;
		String sql = "insert into userinfo(sex_type_code,login_name,login_pass,pass_question,pass_ques_answer,birthday,nick_name,ques_email_addr,pic) values(?,?,?,?,?,?,?,?,null)";
		int i = BaseDAO.update(sql,
				new Object[] { user.getSex_type_code(), user.getLogin_name(),
						user.getLogin_pass(), user.getPass_question(),
						user.getPass_ques_answer(), user.getBirthday(),
						user.getNick_name(), user.getQues_email_addr() },
				new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
						Types.VARCHAR, Types.VARCHAR, Types.DATE,
						Types.VARCHAR, Types.VARCHAR });
		result = i > 0;
		return result;
	}

	@Override
	public UserInfo queryByLoginName(String login_name) {
		
//		UserInfo result=null;
//		String sql="select login_name from userinfo where login_name=?";
//		final UserInfo userinfo = BaseDAO.queryForObject(sql,new Object[] {login_name}, new int[] { Types.VARCHAR },new IMapObject<UserInfo>() {
//					@Override
//					public UserInfo mapping(ResultSet rs) {
//						UserInfo userinfo = new UserInfo();
//						try {
//							userinfo.setLogin_name(rs.getString("login_name"));
//							userinfo.setLogin_pass(rs.getString("login_pass"));
//							userinfo.setNick_name(rs.getString("nick_name"));
//							userinfo.setUser_id(rs.getInt("user_id"));
//							userinfo.setQues_email_addr(rs.getString("ques_email_addr"));
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						return userinfo;
//					}
//				});	
//		return result=userinfo;
//	}
		UserInfo result=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = BaseDAO.getConn();
			pstmt=conn.prepareStatement("select * from userInfo where login_name=?");
			pstmt.setObject(1, login_name, Types.VARCHAR);
			rs=pstmt.executeQuery();
			if (rs.next()){
				result=new UserInfo();
				result.setLogin_name(login_name);
				result.setLogin_pass(rs.getString("login_pass"));
				result.setNick_name(rs.getString("nick_name"));
				result.setUser_id(rs.getInt("user_id"));
				result.setQues_email_addr(rs.getString("ques_email_addr"));
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
	
}
	


	

