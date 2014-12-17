<%@page import="com.shinowit.messageboard.model.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
UserInfo current_user_info=(UserInfo)session.getAttribute("current_login_user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>启奥留言板设计案例_发布留言</title>
<%@ include file="/common/common_header1.jsp" %>
<%@ include file="common/common_login_status_check.jsp" %>
<script type="text/javascript" src="<%=path %>/js/post_msg.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=path %>/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=path %>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
    
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
			<form id="loginForm" method="post" action="<%=path %>/PostMessageServlet">
		  	<input type="hidden" name="current_user_id" value="<%=current_user_info.getUser_id()%>"/>
        	<input type="hidden" name="msg" id="msg" value="<%=request.getParameter("msg")==null?"":request.getParameter("msg")%>"/>
        	<div id="ctopd">发表留言</div>
			<div id="cmopd">
				<ul>
						
					<li><strong class="lts">昵称：</strong><label><%out.print(current_user_info.getNick_name());%></label></li>
					<li><strong class="lts">邮箱：</strong><label><%out.print(current_user_info.getQues_email_addr());%></label></li>
					
					<li><strong class="lts">内容：</strong>
					 <script id="editor" type="text/plain" style="width:486px;height:200px;"></script>
					</li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="发布留言" onclick="check_post_msg_valid()"/>
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
    <script type="text/javascript">
    var ue = UE.getEditor('editor');
    </script>
    
</body>
</html>
