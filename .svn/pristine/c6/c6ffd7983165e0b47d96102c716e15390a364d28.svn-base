package com.shinowit.messageboard.web;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.messageboard.model.UserInfo;
import com.shinowit.messageboard.utils.BaseDAO;

public class DeletePostMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//拿到各个字段值
		HttpSession session = request.getSession(true);
		UserInfo userinfo = (UserInfo) session.getAttribute("current_login_user");
		
		int delete_msg_id=Integer.valueOf(request.getParameter("msg_id"));
		int cruuent_user_id=userinfo.getUser_id();
		// MessageReply mr=new MessageReply();
		// int delete_reply_msg_id=mr.getReply_msg_id();	
		//	String reply_content=request.getParameter("msg");	
		
		String sql_delete="delete from reply_msg where msg_id=?;delete from message where msg_id=? and user_id=?";
		
		//调用方法插入数据库
//		int i=BaseDAO.update(sql_reply,new Object[]{delete_msg_id,current_delete_user_id},new int[]{Types.INTEGER,Types.INTEGER});
//			if(i>0){
					int j=BaseDAO.update(sql_delete,new Object[]{delete_msg_id,delete_msg_id,cruuent_user_id},new int[]{Types.INTEGER,Types.INTEGER,Types.INTEGER});
						if(j>0){
							request.setAttribute("error_msg","删除留言成功！");
							request.getRequestDispatcher("/index.jsp").forward(request, response);
								}
//						else{
//							request.setAttribute("error_msg","删除留言失败！");
//							request.getRequestDispatcher("/index.jsp").forward(request, response);	
//						}
//					} 
			else{  
				request.setAttribute("error_msg","删除留言失败！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);					
				}
	}

}
