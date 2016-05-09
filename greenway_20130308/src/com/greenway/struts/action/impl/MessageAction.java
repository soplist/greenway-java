package com.greenway.struts.action.impl;



import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.Message1;
import com.greenway.pojo.impl.User;
import com.greenway.service.impl.MessageService;
import com.greenway.service.inter.IMessageService;
import com.greenway.service.inter.IUserService;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class MessageAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware{
	   /**
		 * 
		 */
	   private static final long serialVersionUID = 99L;
	   private Message message;
	   private String result;
	   private IMessageService messageService;
	   private IUserService userService;
	   
	private javax.servlet.http.HttpServletRequest request;
	   private javax.servlet.http.HttpServletResponse response;
	   private SessionMap session;  
	public String sendMessage() throws Exception{
		   
		try{
		   response.setContentType("text/html");
		   User user = (User) request.getSession().getAttribute("user");
		   User getUser = userService.getUserById(user.getId());
		   message.setUser(getUser);
			   System.out.println("id"+user.getId()+",name"+user.getName());
		   //System.out.println("id"+user.getId()+"name:"+user.getName()+"email:"+user.getEmail()+"group size:"+user.getGros().size());
		   Date date = new Date();  
		   Timestamp t = new Timestamp(date.getTime()); 
		   message.setDate(t);
		   
		   messageService.addMessage(message);
		   
		   //JsonConfig cfg = new JsonConfig();
		   //cfg.setIgnoreDefaultExcludes(false); 
		   //cfg.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  
		   //cfg.setExcludes(new String[]{"user"}); 
		   //shielding user,beacuse user cause cycle
		   JsonConfig jsonConfig = new JsonConfig();
		   jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
		   public boolean apply(Object source, String name, Object value) {
		      if(name.equals("user")){
		          return true;
		         } else {
		         return false;
		        }
		      }
		   });
		   
		   System.out.println("id:"+message.getId()+",name:"+",content:"+message.getContent());
		   String jsonString = JSONObject.fromObject(message,jsonConfig).toString();
		   
		   this.result = "["+jsonString+"]";//message.getContent();
		   System.out.println(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	       return "success";
	   }
	   public IUserService getUserService() {
		   return userService;
	   }
	   public void setUserService(IUserService userService) {
		   this.userService = userService;
	   }
	   public IMessageService getMessageService() {
		   return messageService;
	   }
	   public void setMessageService(IMessageService messageService) {
		   this.messageService = messageService;
	   }
	   public Message getMessage() {
		   return message;
	   } 
	   public void setMessage(Message message) {
		   this.message = message;
	   }
	   
	   public String getResult() {
	       return result;
	   }

	   public void setResult(String result) {
	       this.result = result;
	   }
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		 this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 this.request=request;
	}
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) map;
	}

	}
