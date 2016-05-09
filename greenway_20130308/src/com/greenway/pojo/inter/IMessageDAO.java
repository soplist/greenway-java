package com.greenway.pojo.inter;

import java.util.List;

import com.greenway.pojo.impl.Message;
import com.greenway.pojo.impl.User;

public interface IMessageDAO {
	public List<Message> listMessageByUserId(User user);

	public void addMessage(Message message);
}
