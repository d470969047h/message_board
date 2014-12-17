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
	int people_count=SessionListeners.current_login_user.size();
	
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
                <a href="<%=path %>/layout.jsp">退出</a>
            </div>
        </div>
        <div id="content">
        	<div id="cheader">    	
			</div>
            <div id="cmenu">
            	在线人数：<%=people_count%>人
            	<a href="<%=path %>/manage.jsp">【刷新】</a>
				<a href="<%=path %>/unlockID.jsp">【解封ID】</a>	
				<a href="">【发布公告】</a>
				
			</div>		
				<%
				for(int i=0;i<SessionListeners.current_login_user.size();i++){
					HttpSession current_list=SessionListeners.current_login_user.get(i);
					
					UserInfo userinfo=(UserInfo)current_list.getAttribute("current_login_user");
					String user_id=current_list.getId();
					
					String ip=(String)current_list.getAttribute("ip");
					Date login_time=(Date)current_list.getAttribute("login_time");
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					int count=SessionListeners.current_login_user.size();
				%>
			<div class="ccon">
				<div class="info">
					<strong>昵称：<%=userinfo.getNick_name() %></strong><br>
					<strong><span>登录时间：<br><%=sdf.format(login_time) %></span></strong>
				</div>
				<div class="liuy">
					<div class="liuyan">
					<font class="hf">[IP]</font><%=ip %>
					<font class="hf">[登陆账号]</font><%=userinfo.getLogin_name() %>
					<font class="hf">[登陆密码]</font><%=userinfo.getLogin_pass() %>
					<font class="hf">[邮箱]</font><%=userinfo.getQues_email_addr() %>
						
						<div class="com">
							<a href="<%=path %>/closeID.jsp?user_name=<%=userinfo.getLogin_name()%>">封其ID</a>&nbsp;&nbsp;&nbsp;
							<a href="<%=path %>/quiet.jsp?sid=<%=user_id %>">踢出此人</a>
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