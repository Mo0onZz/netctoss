package com.tarena.netctoss.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,Constants,RequestAware{
	protected Map<String,Object> session;
	protected Map<String,Object> request;
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
}
