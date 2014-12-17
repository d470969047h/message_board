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

public class EditMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//设置编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				
				//拿到各个字段值
				HttpSession session=request.getSession(true);
				UserInfo userinfo=(UserInfo)session.getAttribute("current_login_user");
				int  current_edit_user_id=userinfo.getUser_id();
				int edited_content_id=Integer.valueOf(request.getParameter("msg_id"));
				String edit_msg_content=request.getParameter("msg");
				
				String sql="update reply_msg set reply_content=? where msg_id=? and user_id=?";
				
				//调用方法插入数据库
				int i=BaseDAO.update(sql,new Object[]{edit_msg_content,edited_content_id,current_edit_user_id},new int[]{Types.VARCHAR,Types.INTEGER,Types.INTEGER});
					if(i>0){
						request.setAttribute("error_msg","修改留言成功！！");
						request.getRequestDispatcher("/index.jsp").include(request, response);
						//response.sendRedirect(request.getContextPath()+"/index.jsp");	
					}else{
						request.setAttribute("error_msg","修改留言失败，请重新修改！");
						request.getRequestDispatcher("/edit.jsp").forward(request, response);
						
					}
				
			}
	}

