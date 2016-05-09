package com.greenway.service.impl;

import java.util.List;

import com.greenway.exception.PasswordException;
import com.greenway.exception.UsernameException;
import com.greenway.pojo.inter.IUserDAO;
import com.greenway.service.inter.IUserService;
import com.greenway.pojo.impl.User;

public class UserService implements IUserService{
    private IUserDAO userDAO;

	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		List list = userDAO.findByName(name);
		if(list.size() == 0)
			 return null;
		else
		     return (User) list.get(0);
	}
	public IUserDAO getuserDAO() {
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
    public boolean validate(String username,String password){
    	boolean v = false;
    	List list = userDAO.findByName(username);
    	//if user list does not equals null,username is exist 
    	 if(0 != list.size()){
    	     User user = (User)list.get(0);
    	     //if username is exist,then compare password 
             if(user.getPassword().equals(password))
             {
            	 v = true;
             }
             else
             {
                 v = false;            
             }
    	 }
    	 else{
    		 v = false;
    	 }
    	 return v;
    }
	public void saveRegisterUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveRegisterUser(user);
	}

}






















