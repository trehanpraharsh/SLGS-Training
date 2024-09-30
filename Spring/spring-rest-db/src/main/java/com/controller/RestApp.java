package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.UserDAO;
import com.entity.User;

@Controller
@RequestMapping("/mainapp")
public class RestApp {
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	@GetMapping("/register")
	public String userRegisterPage() {
		return "register";
	}
	

	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String userLoginPage() {
//		return "login";
//	}
	
	

}
