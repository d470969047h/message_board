<%@page import="java.util.List"%>
<%@page import="com.shinowit.messageboard.web.SessionListeners"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%	
	List<HttpSession> current_oline_sessin_list=SessionListeners.current_login_user;
	
	String need_quiet_session_id=request.getParameter("sid");

	for(int i=0;i<current_oline_sessin_list.size();i++){

	HttpSession current_session=current_oline_sessin_list.get(i);

	if(need_quiet_session_id.equals(current_session.getId())){
		current_oline_sessin_list.remove(current_session);
		current_session.invalidate();	
		response.sendRedirect(request.getContextPath()+"/manage.jsp");
		
	}
	
	}
	
%>
</body>
</html>