<%@page import="com.shinowit.messageboard.model.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.shinowit.messageboard.web.SessionListeners"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	if(session.getAttribute("current_login_admin")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");}
	
		//SessionListeners.current_login_user.add(current_session);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%	//声明一个列表用来存放要封的用户的用户名。list1
		List<UserInfo> current_login_userinfo_list=SessionListeners.current_login_userinfo;
		
		//用于存放在线session的列表。list2
		List<HttpSession> current_oline_sessin_list=SessionListeners.current_login_user;
		
		
		//从浏览器地址获得用户名
		String needClosedUserName=request.getParameter("user_name");
		
		
		//拿到用户名
		//String loginName=userinfo.getLogin_name();
				
		for(int i=0;i<current_oline_sessin_list.size();i++){
		HttpSession current_session=current_oline_sessin_list.get(i);
		//当前登陆用户信息
		UserInfo userinfo=(UserInfo)current_session.getAttribute("current_login_user");
			
			if(needClosedUserName.equals(userinfo.getLogin_name())){
				
				//将用户名（登陆账号）存入list1
				current_login_userinfo_list.add(userinfo);
				
				current_oline_sessin_list.remove(current_session);
				
				current_session.invalidate();
				
				response.sendRedirect("manage.jsp");
				
				break;
			}	
	}
	%>
</body>
</html>