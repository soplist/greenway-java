package com.greenway.struts.action.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.greenway.pojo.impl.User;
import com.greenway.pojo.impl.Userinfo;
import com.greenway.service.inter.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport  implements ServletRequestAware,ServletResponseAware{

	private javax.servlet.http.HttpServletRequest request;
	
	private javax.servlet.http.HttpServletResponse response;
	
	private IUserService userService;
	
	private String name;
    

	private String password;
	
	Logger log=Logger.getLogger(LoginAction.class); 
	
	private User user;
	
	private Userinfo userinfo;


	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public String execute() throws Exception
    {
		response.setCharacterEncoding("utf-8");  
        PrintWriter pw=null;  
		boolean result = userService.validate(user.getName(), user.getPassword());
		//find and store login user id.
    	name=user.getName();
		try {  
            pw = response.getWriter();  
            if(result){
        		User user = userService.getUserByName(name);
        		System.out.println("=====");
        		request.getSession().setAttribute("user",user);
        		pw.write("1"); 
        	}
        	else{
        		pw.write("0");
        	}
        } catch (IOException e) {  
            log.error(e.getMessage(),e.fillInStackTrace());  
        }  
        //response.setCharacterEncoding("utf-8");  
        pw.flush();  
        pw.close();  
		
		// TODO Auto-generated catch block
    	return null;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
		
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
