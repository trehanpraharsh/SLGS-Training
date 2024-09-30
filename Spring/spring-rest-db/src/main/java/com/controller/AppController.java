package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.UserDAO;
import com.entity.User;


@Controller
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	private UserDAO dao;
	
	@PostMapping("/register")
	@ResponseBody
	public String userRegister(@RequestBody User user) {
		
		//Bl to add the user to the list
		dao.addUser(user);
		return user.getUname() + " Registered Successfully......";
	}
	
////	@RequestMapping(value="/login", method=RequestMethod.POST)
//	@PostMapping("/login")
//	public String userLogin(@ModelAttribute User user) {
//		//BL to check for the existing user and redirect to success page
//		if(dao.checkLogin(user)) {
//			return "loginSuccess";
//		}
//		return "login";
//	}
//
	@GetMapping("/loadUsers")
	@ResponseBody
	public List<User> loadUserDetails(){
		return dao.loadUsers();
	}
//	
	@GetMapping("/finduser/{uname}")
	@ResponseBody
	public String findUser(@PathVariable String uname) {
		if(!dao.findUser(uname).isEmpty()) {
			return uname + " found...!";
		}
		return "User not found";
		
	}
	
	@DeleteMapping("/deleteUser/{uname}")
	@ResponseBody
	public String deleteUser(@PathVariable String uname) {
		if(dao.deleteUser(uname)) {
			return uname + " deleted...!";
		}
		return uname + " not found!";
	}
	
	
//	@PutMapping("/updateUser/{uname}")
//	@ResponseBody
//	public String updateUser(@PathVariable String uname, @RequestBody User user) {
//		if(dao.updateUser(uname, user)) {
//			return uname + " was updated successfully...!";
//		}
//		return uname + " was not found! Please enter correct details";
//	}
	
	@PutMapping("/updateUser/{uname}/{email}")
	@ResponseBody
	public String updateUser(@PathVariable String uname, @PathVariable String email) {
		if(dao.updateUser(uname, email)) {
			return uname + " was updated successfully...!";
		}
		return uname + " was not found! Please enter correct details";
	}
	
}
