package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;

//@Service
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
	public boolean checkLogin(User user) {
		// TODO Auto-generated method stub
		for (User usr : userData) {
			if(usr.getUname().equals(user.getUname()) && usr.getPass().equals(user.getPass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean findUser(String uname) {
		// TODO Auto-generated method stub
		for (User user : userData) {
			if(user.getUname().equals(uname)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(String uname) {
		// TODO Auto-generated method stub
		boolean result = findUser(uname);
		if(result) {
			for (User user : userData) {
				if(user.getUname().equals(uname)) {
					userData.remove(user);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(String uname, User user) {
		// TODO Auto-generated method stub
		boolean isUserPresent = findUser(uname);
		if(isUserPresent) {
			for (User user2 : userData) {
				if(user2.getUname().equals(uname)) {
					user2.setUname(user.getUname());
					user2.setPass(user.getPass());
					user2.setEmail(user.getEmail());
					user2.setCity(user.getCity());
					return true;
				}
			}
		}
		return false;
	}
	

}
