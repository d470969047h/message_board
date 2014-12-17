package com.shinowit.messageboard.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.messageboard.dao.IUserInfoDAO;
import com.shinowit.messageboard.dao.impl.UserInfoDAOImpl;
import com.shinowit.messageboard.model.UserInfo;


public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String user_inputed_valid_code=request.getParameter("validcode");	
		
		//管理员登陆
		if((username.equals("admin"))&&(userpass.equals("admin"))){
			request.getSession(true).setAttribute("current_login_admin","admin");
			request.getRequestDispatcher("/manage.jsp").forward(request, response);	
			return;
		}
		
		
		
		String real_valid_code=(String)request.getSession(true).getAttribute("rand");
		
		if((null!=user_inputed_valid_code)&&(!user_inputed_valid_code.equals(real_valid_code))){
		request.setAttribute("err_msg", "服务器说：验证码输入错误，请重新输入！");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return;
		}	
		//判断黑名单用户
		List<UserInfo> current_login_user_id_list=SessionListeners.current_login_userinfo;
		for(int i=0;i<current_login_user_id_list.size();i++){
			UserInfo currentUserInfo=current_login_user_id_list.get(i);
			if(currentUserInfo.getLogin_name().equals(username)){
				request.setAttribute("err_msg", "服务器说：您已经被封ID！请联系管理员！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;	
			}
		}
			
		
		
		if(null==username || username.trim().length()<1){
			request.setAttribute("err_msg", "服务器说：用户名不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
			}
		
		if(null==userpass || userpass.trim().length()<1){
			request.setAttribute("err_msg", "服务器说：登陆密码不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		if(null==user_inputed_valid_code|| user_inputed_valid_code.trim().length()<1){
			request.setAttribute("err_msg", "服务器说：验证码不能为空！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		
		IUserInfoDAO user_info_dao=new UserInfoDAOImpl();
		UserInfo UserInfoFromDb=user_info_dao.queryByLoginName(username);
			
		if(null==UserInfoFromDb){
			request.setAttribute("err_msg", "服务器说：用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
			}else{
				if((UserInfoFromDb.getLogin_pass()==null)&&(!UserInfoFromDb.getLogin_pass().equals(userpass))){
					request.setAttribute("err_msg", "服务器说：用户名或密码错误，请重新输入！");
					request.getRequestDispatcher("/login.jsp");
					return;	
				}else{
					request.getSession(true).setAttribute("current_login_user", UserInfoFromDb);
					request.getSession(true).setAttribute("login_time", new Date());
					request.getSession(true).setAttribute("login_name", UserInfoFromDb.getLogin_name());
					request.getSession(true).setAttribute("ip", request.getRemoteAddr());
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					return;
			}
		}
		
		}
}
