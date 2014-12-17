<%@page import="com.shinowit.messageboard.model.UserInfo"%>
<%@page import="com.shinowit.messageboard.dao.impl.UserInfoDAOImpl"%>
<%@page import="com.shinowit.messageboard.dao.IUserInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="utf-8"%>
<%
	IUserInfoDAO user_dao=new UserInfoDAOImpl();

	UserInfo userInfo=user_dao.queryByLoginName(request.getParameter("username"));
	 if(userInfo!=null){		 
		 out.print("{\"status:\":true,\"msg\":\"数据库中已有同名的用户了！\"}");
	 }else{
		 out.print("{\"status:\":false,\"msg\":\"\"}");
	 }
%>
