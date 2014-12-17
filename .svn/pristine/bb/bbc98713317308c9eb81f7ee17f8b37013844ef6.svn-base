package com.shinowit.messageboard.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener  {
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		String attrName=event.getName();
		//Object attrValue=event.getValue();	
		//System.out.println("监测到了session当中setAttribute数据值，数据值toString="+attrValue.toString());
		if(("current_login_user").equals(attrName)){
			HttpSession current_session=event.getSession();	
			SessionListeners.current_login_user.add(current_session);
					
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
				                                                                                                                                                              
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
				
	}	
}
