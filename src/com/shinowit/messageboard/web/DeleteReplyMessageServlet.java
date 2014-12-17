package com.shinowit.messageboard.web;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.messageboard.model.MessageReply;
import com.shinowit.messageboard.model.UserInfo;
import com.shinowit.messageboard.utils.BaseDAO;


public class DeleteReplyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		//拿到各个字段值
		HttpSession session = request.getSession(true);
		UserInfo userinfo = (UserInfo) session.getAttribute("current_login_user");
		int  current_delete_user_id=userinfo.getUser_id();
		
		int delete_reply_msg_id=Integer.valueOf(request.getParameter("reply_msg_id"));	
		
		String sql="delete from reply_msg where reply_msg_id=? and user_id=?  ";
		
		//调用方法插入数据库
		int i=BaseDAO.update(sql,new Object[]{delete_reply_msg_id,current_delete_user_id},new int[]{Types.INTEGER,Types.INTEGER});
			if(i>0){
				request.setAttribute("error_msg","删除留言成功！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}else{  
				request.setAttribute("error_msg","删除留言失败！");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
					
			}
	}
   

}
