package com.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public List<User> loadUsers();
	
	public boolean findUser(String uname);


}
