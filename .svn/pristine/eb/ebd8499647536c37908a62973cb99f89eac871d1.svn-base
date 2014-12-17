package com.shinowit.messageboard.web;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.messageboard.utils.BaseDAO;

public class PostMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//拿到各个字段值
		int  current_login_user_id=Integer.valueOf(request.getParameter("current_user_id"));
		String post_msg_content=request.getParameter("msg");
		
		String sql="insert into message(user_id,post_time,msg_content) values(?,getdate(),?)";
		
		//调用方法插入数据库
		int i=BaseDAO.update(sql,new Object[]{current_login_user_id,post_msg_content},new int[]{Types.INTEGER,Types.VARCHAR});
			if(i>0){
			response.sendRedirect(request.getContextPath()+"/index.jsp");	
			}else{
				request.setAttribute("error_msg","发表留言失败，请重新发表！");
				request.getRequestDispatcher("/post_msg.jsp").forward(request, response);
				
			}
		
	}

}
