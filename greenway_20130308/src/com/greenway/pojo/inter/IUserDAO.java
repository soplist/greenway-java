package com.greenway.pojo.inter;

import java.util.List;

import com.greenway.pojo.impl.UserGroupStructure;
import com.greenway.pojo.impl.User;

public interface IUserDAO {
	public void saveRegisterUser(User user);
	
	public User findById(java.lang.Integer id);
	
	public List findByName(Object name);
	
	public void save(User transientInstance);
	
	public List listUsers();
	
	public List findByEmail(Object email);
	
	public List listUsersByEmail();
	
}