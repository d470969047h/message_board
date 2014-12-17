package com.shinowit.messageboard.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.shinowit.messageboard.model.UserInfo;

public class SessionListeners implements HttpSessionListener {
	
	public static final List<HttpSession> current_login_user=new ArrayList<HttpSession>();
	public static final List<UserInfo> current_login_userinfo=new ArrayList<UserInfo>();
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {

	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
				current_login_user.remove(event.getSession());
					
			}
	}
