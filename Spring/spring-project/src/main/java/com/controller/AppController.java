package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.UserDAO;
import com.model.User;


@Controller
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	private UserDAO dao;
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	@ResponseBody
	public String userRegister(@RequestBody User user) {
		
		//Bl to add the user to the list
		dao.addUser(user);
//		List<User> userData = dao.loadUsers();
//		userData.stream().forEach(s -> System.out.println(s));
		return user.getName() + " Registered Successfully......";
	}

	@GetMapping("/loadUsers")
	@ResponseBody
	public List<User> loadUserDetails(){
		return dao.loadUsers();
	}
	
	@GetMapping("/finduser/{uname}")
	@ResponseBody
	public String findUser(@PathVariable String uname) {
		if(dao.findUser(uname)) {
			return uname + " found...!";
		}
		return "User not found";
		
	}
	
}
