package com.greenway.service.inter;

import java.util.List;

import com.greenway.exception.PasswordException;
import com.greenway.exception.UsernameException;
import com.greenway.pojo.impl.User;

public interface IUserService {
	public User getUserById(java.lang.Integer id);
	public User getUserByName(String name);
	public void addUser(User user);
	public boolean validate(String username,String password);
	public void saveRegisterUser(User user);
}