package com.dao;

import java.util.List;
import java.util.Optional;

import com.entity.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public List<User> loadUsers();
//	
//	public boolean checkLogin(User user);
//	
	public Optional<User> findUser(String uname);
//	
	public boolean deleteUser(String uname);
	
	//public boolean updateUser(String uname, User user);
	public boolean updateUser(String email, String uname);


}
