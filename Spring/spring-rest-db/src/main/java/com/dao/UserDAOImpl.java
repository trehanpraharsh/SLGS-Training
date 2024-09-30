package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	public UserRepo repo;
	
	//static List<User> userData = new ArrayList<User>();

	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
//		userData.add(user);
		repo.save(user);
		
	}

	@Override
	@Transactional
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return (List<User>) repo.findAll();

//		userData.stream().forEach(s -> System.out.println(s));
		
	}
//
//	@Override
//	public boolean checkLogin(User user) {
//		// TODO Auto-generated method stub
//		for (User usr : userData) {
//			if(usr.getUname().equals(user.getUname()) && usr.getPass().equals(user.getPass())) {
//				return true;
//			}
//		}
//		return false;
//	}
//
	@Override
	public Optional<User> findUser(String uname) {
		// TODO Auto-generated method stub
		return repo.findById(uname);
		
	}

	@Override
	public boolean deleteUser(String uname) {
		// TODO Auto-generated method stub
		Optional<User> result = findUser(uname);
		if(!result.isEmpty()) {
			repo.deleteById(uname);
			return true;
		}
		return false;
	}

	
	//This method is also correct but there is a better approach to this
//	@Override
//	public boolean updateUser(String uname, User user) {
//		// TODO Auto-generated method stub
//		Optional<User> isUserPresent = findUser(uname);
//		if(!isUserPresent.isEmpty()) {
//			
//			isUserPresent.get().setUname(user.getUname());
//			isUserPresent.get().setPass(user.getPass());
//			isUserPresent.get().setEmail(user.getEmail());
//			isUserPresent.get().setCity(user.getCity());
//			return true;
//		}
//		return false;
//		
//	}
	
	@Override
	public boolean updateUser(String uname, String email) {
		// TODO Auto-generated method stub
		Optional<User> isUserPresent = findUser(uname);
		if(!isUserPresent.isEmpty()) {
			
			repo.updateUser(uname, email);
			return true;
		}
		return false;
		
	}
	

}
