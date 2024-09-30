package com.frontcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delegate.AppDelegate;

@RestController
@RequestMapping("/clientapp")
public class ClientApp {
	
	@Autowired
	private AppDelegate appDelegate;
	
	@GetMapping("/loadstudentdata/{loc}")
	public String loadStudent(@PathVariable String loc){
		return appDelegate.delegate(loc);
		
	}
	
	
	

}
