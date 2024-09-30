package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDAO;
import com.dao.UserService;
import com.model.User;
import com.model.Users;

@RestController
@RequestMapping("/mainapp")
public class RestApp {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/loadusers")
	public Users userLoad(
			@RequestHeader(name = "X-COM-PERSIST", required = true)String hdata,
			@RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA")String loc) {
		return service.loadAll();

	}
	
	

}
