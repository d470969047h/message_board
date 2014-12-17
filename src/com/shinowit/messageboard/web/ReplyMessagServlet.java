package com.shinowit.messageboard.web;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.messageboard.utils.BaseDAO;

public class ReplyMessagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//设置编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				//拿到各个字段值
				int  current_post_user_id=Integer.valueOf(request.getParameter("post_user_id"));
				int msg_id=Integer.valueOf(request.getParameter("msg_id"));
				String reply_content=request.getParameter("msg");
				
				String sql="insert into reply_msg(user_id,msg_id,reply_time,reply_content) values(?,?,getdate(),?)";
				
				//调用方法插入数据库
				int i=BaseDAO.update(sql,new Object[]{current_post_user_id,msg_id,reply_content},new int[]{Types.INTEGER,Types.INTEGER,Types.VARCHAR});
					if(i>0){
						request.setAttribute("error_msg","回复留言成功！");
					response.sendRedirect(request.getContextPath()+"/index.jsp");	
					}else{
						request.setAttribute("error_msg","回复留言失败，请重新发表！");
						request.getRequestDispatcher("/reply_msg.jsp").forward(request, response);
						
					}
				
			}

	}


