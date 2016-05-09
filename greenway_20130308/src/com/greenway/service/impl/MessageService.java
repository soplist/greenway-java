package com.greenway.service.impl;

import java.util.List;

import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.MessageDAO;
import com.greenway.pojo.impl.User;
import com.greenway.pojo.inter.IMessageDAO;
import com.greenway.service.inter.IMessageService;

public class MessageService implements IMessageService{
	private IMessageDAO messageDAO;
	
	
	public void addMessage(Message message){
		messageDAO.addMessage(message);
	}
	public List<Message> listMessageByUserId(User user) {
		// TODO Auto-generated method stub
		return messageDAO.listMessageByUserId(user);
	}
	
	public IMessageDAO getMessageDAO() {
		return messageDAO;
	}
	public void setMessageDAO(IMessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}
}
