package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserDAOImpl implements UserDAO {
	
	static List<User> userData = new ArrayList<User>();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userData.add(user);
		
	}

	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return userData;
//		userData.stream().forEach(s -> System.out.println(s));
		
	}

	@Override
	public boolean findUser(String uname) {
		// TODO Auto-generated method stub
		for (User user : userData) {
			if(user.getName().equals(uname)) {
				return true;
			}
		}
		return false;
	}
	

}
