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
	<%	//声明一个列表用来存放已经存放被封的ID。list1
		List<UserInfo> current_locked_userinfo_list=SessionListeners.current_login_userinfo;
				
		//从浏览器地址获得用户名
		String LockedUserName=request.getParameter("user_name");
				
		for(int i=0;i<current_locked_userinfo_list.size();i++){

			UserInfo lockedUser=current_locked_userinfo_list.get(i);
		
			if(LockedUserName.equals(lockedUser.getLogin_name())){
				
				//将用户名（登陆账号）存入list1
				//current_login_user_id_list.add(needClosedUserName);
				
				current_locked_userinfo_list.remove(lockedUser);
				
				response.sendRedirect("unlockID.jsp");
				
				break;
			}	
	}
	%>
</body>
</html>