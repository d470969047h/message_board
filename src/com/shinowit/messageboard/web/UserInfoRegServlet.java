package com.shinowit.messageboard.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.messageboard.dao.IUserInfoDAO;
import com.shinowit.messageboard.dao.impl.UserInfoDAOImpl;
import com.shinowit.messageboard.model.UserInfo;

public class UserInfoRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");		
		UserInfo user=new UserInfo();
			
		user.setLogin_name(request.getParameter("username"));
		user.setLogin_pass(request.getParameter("userpass"));
		user.setPass_question(request.getParameter("pass_question"));
		user.setPass_ques_answer(request.getParameter("pass_ques_answer"));
		//将字符串类型数据转换为数据库中的Date类型
		String birthday_string=request.getParameter("birthday");	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(birthday_string!=null){
			try {
				Date date=sdf.parse(birthday_string);
				user.setBirthday(new java.sql.Date(date.getTime()));
				} catch (Exception e) {
					e.printStackTrace();  
				}
		}
		user.setSex_type_code(Integer.valueOf(request.getParameter("sex_type_code")));
		user.setNick_name(request.getParameter("nick_name"));
		user.setQues_email_addr(request.getParameter("ques_email_addr"));
	
		IUserInfoDAO user_info_dao=new UserInfoDAOImpl();
		//查询数据库,查找与登录名称相同的记录
		UserInfo UserInfoFromDb=user_info_dao.queryByLoginName(user.getLogin_name());
		
		List<String> error_msg=new ArrayList<String>();
		//首先先对验证码进行服务器校验		
			//取用户输入的验证码
		String user_input_valid_code=request.getParameter("validcode");
			//从session中取验证码
		String real_valid_code=(String)request.getSession(true).getAttribute("rand");
			//对验证码进行比较验证
		if((null!=user_input_valid_code)&&(!user_input_valid_code.equals(real_valid_code))){
			error_msg.add("服务器说：验证码输入错误，请重新输入！");
		}
		
		
		
		//服务器端数据合法性验证
		if(null==user.getLogin_name() || user.getLogin_name().trim().length()<1){
			error_msg.add("服务器说：用户名不能为空！");
			}
		
		if(null==user.getLogin_pass()|| user.getLogin_pass().trim().length()<1){
			error_msg.add("服务器说：用密码不能为空！");
		}
			
		if(null==user.getPass_question() || user.getPass_question().trim().length()<1){
			error_msg.add("服务器说：密码保护问题不能为空！");
		}
			
		if(null==user.getPass_ques_answer() || user.getPass_ques_answer().trim().length()<1){
			error_msg.add("服务器说：密码保护答案不能为空！");
		}
		
		if(null==user.getBirthday()){
			error_msg.add("服务器说：出生日期不能为空！");
		}
				
		if(null==user.getNick_name() || user.getNick_name().trim().length()<1){
			error_msg.add("服务器说：昵称不能为空！");
		}
		
		if(null==user.getQues_email_addr() || user.getQues_email_addr().trim().length()<1){
			error_msg.add("服务器说：密保邮箱不能为空！");
		}
		
		if(null!=UserInfoFromDb){
			error_msg.add("服务器说：数据库中有名称为:"+user.getLogin_name()+"的用户！");
		}
		if(error_msg.size()>0){
			request.setAttribute("error_msg",error_msg);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		

		boolean status=user_info_dao.create(user);
		if (true==status){
			response.sendRedirect(request.getContextPath()+"/login.jsp?regok=true");
		}else{
		}
	}

	}
	
