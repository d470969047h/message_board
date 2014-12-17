<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/common_header1.jsp" %>
<script src="<%=path %>/js/login.js"></script>
<title>启奥留言板设计案例</title>
</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=path %>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;
                <a href="reg.jsp">注册</a>
            </div>
        </div>
        <div id="log">
			<form id="loginForm" method="post" action="<%=path %>/CheckLoginServlet">
        	<div id="ctopd">用户登录</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">登录名：</strong><input type="text" name="username" id="username" value="<%=request.getParameter("username")==null?"":request.getParameter("username") %>" class="ltx" /></li>
					<li><strong class="ltt">密 码：</strong><input type="password" name="userpass" id="userpass" value="<%=request.getParameter("userpass")==null?"":request.getParameter("userpass") %>" class="ltx" /></li>
					<li><strong class="ltt">验证码：</strong><input type="text" name="validcode" id="validcode" maxlength="4"  class="lty" /><img id="validImage" src="<%=path %>/validCode.jsp" onclick="reload_valid_image()"/></li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="submit" class="btn_sub" value="登 录" onclick="return check_login_valid()"/>
				<input type="button" class="btn_res" value="返 回" onclick="javascript:window.history.back();"/>
			</div>
			</form>
        </div>

		<div id="footer">
			<img src="<%=path %>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
    <script type="text/javascript">
   
    <%
    if(request.getAttribute("err_msg")!=null){
    		out.println("alert('"+request.getAttribute("err_msg")+"')");
    	}    	
    %>
    </script>

</body>
</html>