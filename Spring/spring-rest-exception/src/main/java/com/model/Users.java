package com.model;

import java.util.ArrayList;
import java.util.List;

public class Users {
	
	public List<User> users;

	public List<User> getUsers() {
		if(users == null) 
			users = new ArrayList<User>();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
