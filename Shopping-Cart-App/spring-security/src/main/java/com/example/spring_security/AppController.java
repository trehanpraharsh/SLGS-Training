package com.example.spring_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/emp")
	public String emp() {
		return "emp";
	}
	
	@GetMapping("/common")
	public String common() {
		return "common";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/ad")
	public String ad() {
		return "ad";
	}
	
	
}
