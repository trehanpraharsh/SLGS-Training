package com.frontcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delegate.AppDelegate2;

@RestController
@RequestMapping("/clientapp2")
public class ClientApp2 {
	
	@Autowired
	private AppDelegate2 appDelegate2;
	
	@GetMapping("/loadownerdetails/{id}")
	public String loadOwner(@PathVariable Integer id){
		return appDelegate2.delegate(id);
		
	}
	
	
	@GetMapping("/loadblogdetails/{id}")
	public String loadBlog(@PathVariable Integer id){
		return appDelegate2.delegate2(id);
		
	}
	
	
	@GetMapping("/loadcommentdetails/{id}")
	public String loadComment(@PathVariable Integer id){
		return appDelegate2.delegate3(id);
		
	}
	
	
}