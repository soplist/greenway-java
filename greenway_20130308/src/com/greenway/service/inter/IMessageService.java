package com.greenway.service.inter;

import java.util.List;

import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.User;

public interface IMessageService  {
	public List<Message> listMessageByUserId(User user);
	public void addMessage(Message message);
}
