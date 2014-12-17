<%@page import="com.shinowit.messageboard.model.UserInfo"%>
<%@page import="com.shinowit.messageboard.dao.impl.*"%>
<%@page import="com.shinowit.messageboard.dao.*"%>
<%@page import="com.shinowit.messageboard.model.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
UserInfo current_user_info=(UserInfo)session.getAttribute("current_login_user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>启奥留言板设计案例_编辑留言</title>
<%@ include file="/common/common_header1.jsp" %>
<%@ include file="common/common_login_status_check.jsp" %>
<script type="text/javascript" src="<%=path %>/js/post_msg.js"></script>
</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=path %>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=path %>/layout.jsp">退出</a>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <div id="log">
			<form id="loginForm" method="post" action="<%=path %>/EditMessageServlet">
			<input type="hidden" name="msg_id" value="<%=request.getParameter("msg_id")%>"/>
			<%-- <input type="hidden" name="current_user_id" value="<%=current_user_info.getUser_id()%>"/>--%>
        	<div id="ctopd">编辑留言</div>   
			<div id="cmopd">
				<ul>	
					<%	
					
						MessageReply msgReply=new MessageReply();
						msgReply.getReply_content();			
					%>			
					<li><strong class="lts">昵称：</strong><label><%out.print(current_user_info.getNick_name());%></label></li>
					<li><strong class="lts">邮箱：</strong><label><%out.print(current_user_info.getQues_email_addr());%></label></li>
					<li><strong class="lts">内容：</strong><textarea name="msg" id="msg" class="ltxs"><%=msgReply.getReply_content()==null?"":msgReply.getReply_content()%></textarea></li>				
				</ul>			
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="修改留言" onclick="check_post_msg_valid()"/>
				<input type="button" class="btn_res" value="返 回" onclick="javascript:window.history.back();" />
			</div>
			</form>
        </div>
		<div id="footer">
			<img src="<%=path %>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
    <script type="text/javascript">
    <%
    	if(null!=request.getAttribute("error_msg")){
    		out.print("alert('"+request.getAttribute("error_msg")+"');");
    	}
    %>
    
    </script>
</body>
</html>
