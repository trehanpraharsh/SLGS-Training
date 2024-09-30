package com.dao;

import org.springframework.stereotype.Service;

import com.model.User;
import com.model.Users;

@Service
public class UserService {
	
	private static Users users = new Users();
	
	static {
		users.getUsers().add(new User("admin", "admin", "admin@mail.com", "pune"));
		users.getUsers().add(new User("manager", "manager", "manager@mail.com", "delhi"));
	}
	
	public Users loadAll(){
		return users;
	}

}
