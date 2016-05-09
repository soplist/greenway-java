package com.greenway.struts.action.test;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction  extends ActionSupport implements ServletRequestAware{
	
	private javax.servlet.http.HttpServletRequest request;
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Override
	public String execute() throws Exception
    {
		String ip = getIpAddr(this.request);
		System.out.println("ip:"+ip);
        return NONE;
    }
	
	public String getIpAddr(HttpServletRequest request) {      
	    String ip = request.getHeader("x-forwarded-for");      
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	         ip = request.getHeader("Proxy-Client-IP");      
	    }      
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	         ip = request.getHeader("WL-Proxy-Client-IP");      
	    }      
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
	         ip = request.getRemoteAddr();      
	    }      
	    return ip;      
	}   
}
