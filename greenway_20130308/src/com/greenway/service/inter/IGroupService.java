package com.greenway.service.inter;

import java.util.List;

import com.greenway.pojo.impl.User;

public interface IGroupService {
	public List getGroupsByUserID(Integer userID);
	public List listGroupsByUserId(User user);
}
