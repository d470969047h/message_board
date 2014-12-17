<%@page import="com.shinowit.messageboard.dao.impl.*"%>
<%@page import="com.shinowit.messageboard.dao.*"%>
<%@page import="com.shinowit.messageboard.model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/common_login_status_check.jsp" %>
	<%
	String path = request.getContextPath();
	
	IMessageDAO message_dao=new MessageDAOImpl();
	
	int pageSize=5;//每页显示记录条数
	
	int currentPageIndex=1;//当前显示几页
	
	//当前显示第几页
	if(request.getParameter("pageNum")!=null){
		currentPageIndex=Integer.valueOf(request.getParameter("pageNum"));
	}	
	
	List<Message> msg_list=message_dao.queryForPage(pageSize,currentPageIndex);
	
	PageInfo pageinfo=message_dao.getPageInfo(pageSize, currentPageIndex);
	
	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<link href="css/style.jsp" rel="stylesheet" type="text/css" />
<script src="<%=path %>/js/index.js"></script>
</head>
<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=path %>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=path %>/layout.jsp">退出</a>&nbsp;&nbsp;&nbsp;
                <a href="<%=path %>/reg.jsp">注册</a>
            </div>
        </div>
        <div id="content">
        	<div id="cheader"></div>
            <div id="cmenu">
				<a href="<%=path %>/post_msg.jsp">【我要留言】</a>
				<!-- <a href="<%=path %>/">【查看所有留言】</a> -->
			</div>	
<%
	IMessageReplyDAO reply_dao=new MessageReplyDAOImpl();
 for(int msg_index=0;msg_index < msg_list.size();msg_index++){
	 Message msg_info=msg_list.get(msg_index);
	 String user_photo=path+"/images/photo/templogo.gif";
	 if((msg_info.getUserInfo().getPic()!=null)&&(msg_info.getUserInfo().getPic().length()>0)){
		 user_photo=path+msg_info.getUserInfo().getPic();
	 }	 %> 
			<div class="ccon">
				<div class="info">
				<!-- 头像 -->
					<img src="<%=user_photo%> "alt="" />
					<!-- 留言人昵称 -->
					<strong><%=msg_info.getUserInfo().getNick_name() %></strong>
					<!-- 留言的系统时间 -->
					<span><%=msg_info.getPostTimeString() %></span>
				</div>
				<div class="liuy">
					<div class="liuyan">
					<!-- 留言内容 -->
						<font style="font-weight: bold;"><%=msg_info.getMsgContent().toString().trim() %></font>						
						<div class="com">
							<a href="<%=path %>/reply_msg.jsp?msg_id=<%=msg_info.getMsgId()%>">回复此留言</a>&nbsp;&nbsp;&nbsp;
							<a href="<%=path %>/DeletePostMessageServlet?msg_id=<%=msg_info.getMsgId()%>">删除</a>
						</div>						
					</div>					
					<%
						List<MessageReply> reply_list=reply_dao.queryForReplyByMsgId(msg_info.getMsgId());
						for(int reply_index=0;reply_index<reply_list.size();reply_index++)
						{
							MessageReply msgReply=reply_list.get(reply_index);
							
					%>
					<div class="huifu">
						<font class="hf">[回复]</font><br> [回复人]：<%=msgReply.getReplayUserInfo().getNick_name() %><br>[回复时间]：<%=msgReply.getReplyTimeString() %><br>[回复内容]：<%=msgReply.getReply_content() %>
						<%
							UserInfo current_user=(UserInfo)session.getAttribute("current_login_user");
							if(current_user.getUser_id()==msgReply.getUser_id()){
						%>
						<div class="com">
							<a href="<%=path %>/edit.jsp?msg_id=<%=msg_info.getMsgId()%>">修改此回复</a>&nbsp;&nbsp;&nbsp;
							<a href="<%=path %>/DeleteReplyMessageServlet?reply_msg_id=<%=msgReply.getReply_msg_id()%>">删除</a>
						</div>
						<%}%>
					</div>
					<% } %>
				</div>
			</div>
<%
 }
%>
			<div class="page">
				共<%=pageinfo.getRecordCount() %>条留言 / 分 <%=pageinfo.getPageCount() %>页显示 / 当前第 <%=pageinfo.getCurrentPageIndex() %> 页 /&nbsp;
				
				<input type="text" name="pageNum" id="pageNum" value="<%=pageinfo.getCurrentPageIndex() %>" style="width:25px;"/>&nbsp;
				
				<input type="button" value="Go" onclick="gotoPage(<%=pageinfo.getPageCount() %>)"/>
				
				<%if(pageinfo.hasPriorPage()){ %>
				<a href="<%=path %>/index.jsp?pageNum=<%=pageinfo.getCurrentPageIndex()-1 %>" style="color:black;">上一页</a>&nbsp;
				<%} %>
				
				<%if(pageinfo.hasNextPage()){ %>
				<a href="<%=path %>/index.jsp?pageNum=<%=pageinfo.getCurrentPageIndex()+1 %>" style="color:black;">下一页</a>
				<%} %>
			</div>
            <div id="cfooter"></div>
        </div>

		<div id="footer">
			<img src="<%=path %>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
<script type="text/javascript">
    <%
    	if(null!=request.getAttribute("error_msg")){
    		out.print("alert('"+request.getAttribute("error_msg")+"');");
    	}
    %>
    
    </script>
</html>