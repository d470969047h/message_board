<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.shinowit.messageboard.model.UserInfo"%>
<%@page import="com.shinowit.messageboard.web.SessionListeners"%>
<%@page import="com.shinowit.messageboard.web.SessionListener"%>
<%@page import="java.util.List"%>
<%@page import="com.shinowit.messageboard.web.SessionListeners"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	if(session.getAttribute("current_login_admin")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");	
	}

	String path = request.getContextPath();
	List<UserInfo> current_login_userinfo_list=SessionListeners.current_login_userinfo;
	int unlckedID_count=current_login_userinfo_list.size();
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>启奥留言板设计案例</title>
<link href="css/style.jsp" rel="stylesheet" type="text/css" />
<script src="<%=path %>/js/index.js"></script>
</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=path %>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=path %>/login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;
                <a href="<%=path %>/layout.jsp"">退出</a>
            </div>
        </div>
        <div id="content">
        	<div id="cheader">    	
			</div>
            <div id="cmenu">
            	黑名单人数：<%=unlckedID_count%>人
            	<a href="<%=path %>/unlockID.jsp">【刷新】</a>
				<a href="<%=path %>/manage.jsp">【返回】</a>
			</div>		
				<%	
				for(int i=0;i<current_login_userinfo_list.size();i++){	
					
					UserInfo lockedUser=current_login_userinfo_list.get(i);					
							
							String lockedID_NickName=lockedUser.getNick_name();
							String loginName=lockedUser.getLogin_name();
							String loginPass=lockedUser.getLogin_pass();
							String Email=lockedUser.getQues_email_addr();														
				%>
			<div class="ccon">
				<div class="info">
					<strong>昵称：<%=lockedID_NickName %></strong><br>
				</div>
				<div class="liuy">
					<div class="liuyan">
					<font class="hf">[登陆账号]</font><%=loginName %>
					<font class="hf">[登陆密码]</font><%=loginPass %>
					<font class="hf">[邮箱]</font><%=Email %>					
						<div class="com">
							<a href="<%=path %>/unlockUserID.jsp?user_name=<%=loginName%>">解封ID</a>&nbsp;&nbsp;&nbsp;
						</div>
					</div>
				</div>
			</div>
					<%} %>	
			
			<div class="page">
				共 20 条留言 / 分 2 页显示 / 当前第 1 页 / 1 2 3 4 5
			</div>
            <div id="cfooter"></div>
        </div>
		<div id="footer">
			<img src="<%=path %>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
</html>