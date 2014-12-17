<%@ page language="java" import="java.util.*" 
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<title>启奥留言板设计案例</title>
<%@ include file="/common/common_header1.jsp" %>
<script src="<%=path %>/js/my97/WdatePicker.js"></script>
<script src="<%=path %>/js/fckeditor/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/reg.js"></script>
</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=path %>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=path %>/login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;
                <a href="<%=path %>/reg.jsp">注册</a>
            </div>
        </div>
        <div id="log" style="margin-top:10px;">
			<form id="loginForm" method="post" action="<%=path %>/UserInfoRegServlet">
        	<div id="ctopd">用户注册</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">登录名：</strong><input type="text" name="username" id="username" value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>" class="ltx" /></li>
					<li><strong class="ltt">登录密码：</strong><input type="password" name="userpass" id="userpass" class="ltx" /></li>
					<li><strong class="ltt">确认密码：</strong><input type="password" name="userpass1" id="userpass1" class="ltx" /></li>
					<li><strong class="ltt">密码保护问题：</strong><input type="text" name="pass_question" id="pass_question" value="<%=request.getParameter("pass_question")==null?"":request.getParameter("pass_question") %>" class="ltx" /></li>
					<li><strong class="ltt">您的答案：</strong><input type="text" name="pass_ques_answer" id="pass_ques_answer" value="<%=request.getParameter("pass_ques_answer")==null?"":request.getParameter("pass_ques_answer") %>" class="ltx" /></li>
					<li><strong class="ltt">出生日期：</strong><input type="text" name="birthday" id="birthday"  class="ltx" onclick="WdatePicker()"readonly="redonly"  /></li>
					<li><strong class="ltt">性 别：</strong><input type="radio" name="sex_type_code" id="sex_type_code" value="1" checked="checked" />男<input type="radio" name="sex_type_code" id="sex_type_code" value="2" />女</li>
					<li><strong class="ltt">昵 称：</strong><input type="text" name="nick_name" id="nick_name" value="<%=request.getParameter("nick_name")==null?"":request.getParameter("nick_name") %>" class="ltx" /></li>
					<li><strong class="ltt">密保邮箱：</strong><input type="text" name="ques_email_addr" id="ques_email_addr"  value="<%=request.getParameter("ques_email_addr")==null?"":request.getParameter("ques_email_addr") %>" class="ltx" /></li>
					<li><strong class="ltt">验证码：</strong><input type="text" name="validcode" id="validcode" maxlength="4" class="lty" /><img src="<%=path%>/validCode.jsp" id="validImage" onclick="reload_valid_image()" /></li>
					<li><label style="margin-left:80px;">戴晖:好好学习java以后一定会有好结果的，你同意吗？</label></li>
					<li><strong class="ltt">&nbsp;</strong><input type="checkbox" name="agree" id="agree" class="ltc" />同意服务条款</li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="登 录" onclick="return check_reg_valid()"/>
				<input type="reset" class="btn_res" value="重置" />
			</div>
			</form>
        </div>
		<div id="footer">
			<img src="<%=path %>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
    <script type="text/javascript" >
    <%
    if(request.getAttribute("error_msg")!=null){
    	List<String> error_msg_list=(List<String>)request.getAttribute("error_msg");
    	for(String s:error_msg_list){
    		out.println("alert('"+s+"')");
    	}    	
    }
    %>
    </script>
</body>
</html>
