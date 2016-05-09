package com.greenway.struts.action.impl;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.greenway.exception.PasswordException;
import com.greenway.exception.UsernameException;
import com.greenway.pojo.impl.User;
import com.opensymphony.xwork2.ActionSupport;
import com.greenway.service.impl.UserService;
import com.greenway.service.inter.IMessageService;
import com.greenway.service.inter.IUserService;
import com.greenway.pojo.impl.User;

public class UserAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String password;
    private String email;
    
	private javax.servlet.http.HttpServletRequest request;
    
    private IUserService userService;
    private IMessageService messageService;
    
    
	@Override
	public String execute() throws Exception
    {
    	boolean result = userService.validate(name, password);
		//find and store login user id.
    	
		// TODO Auto-generated catch block
    	if(result){
    		User user = userService.getUserByName(name);
    		int user_id = user.getId();
    		System.out.println(user_id);
    		request.getSession().setAttribute("user_id",user_id);
    		request.getSession().setAttribute("user",user);
    		request.getSession().setAttribute("messages",messageService.listMessageByUserId(user));
    		return SUCCESS;
    	}
    	else{
    		clearFieldErrors();
    		addFieldError("username.error",getText("user or password error"));
    		return INPUT;
    	}
    	
	}
    public String regist() throws Exception
    {
    	User user = new User();
    	user.setName(name);
    	user.setPassword(password);
    	user.setEmail(email);
    	user.setState(1);
    	userService.saveRegisterUser(user);
    	return SUCCESS;
    }
	@Override
	public void validate(){
		//clear field error last time.
		clearFieldErrors();
		//username and password must be input
		if(getName()==null||getName().trim().equals("")){
			addFieldError("username.error",getText("username.required"));
			return;
		}
		if(getPassword()==null||getPassword().trim().equals("")){
		    addFieldError("password.error",getText("password.required"));
		    return;
		}
		
			
	}
	public IMessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
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
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
