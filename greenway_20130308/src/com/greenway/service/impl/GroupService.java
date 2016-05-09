package com.greenway.service.impl;

import java.util.List;

import com.greenway.pojo.inter.IGroDAO;
import com.greenway.service.inter.IGroupService;
import com.greenway.pojo.impl.Gro;
import com.greenway.pojo.impl.User;

public class GroupService implements IGroupService {
    private IGroDAO groDao;
    public List<Gro> getGroupsByUserID(Integer userID){
    	return groDao.findByProperty("user_id", userID);
    }
	public List<Gro> listGroupsByUserId(User user){
		return groDao.listGroupsByUserId(user);
	}
	public IGroDAO getGroDao() {
		return groDao;
	}

	public void setGroDao(IGroDAO groDao) {
		this.groDao = groDao;
	}
	

}
