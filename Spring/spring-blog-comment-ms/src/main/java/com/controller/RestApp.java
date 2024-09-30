package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AppDAO;
import com.entity.Owner;


@RestController
@RequestMapping("/mainapp")
public class RestApp {
	@Autowired
	private AppDAO dao;
	
	@PostMapping("/addowner")
	public String addOwner(@RequestBody Owner owner) {
		dao.addOwner(owner);
		return "owner Registered...!";
	}
	
	
	@PostMapping("/addblogs")
	public String addBlogs(@RequestParam(name = "id") Integer id) {
		dao.addBlogs(id);
		return "Blogs Created and Registered to the owner...!";
	}

	
	@PostMapping("/addownerandblogs")
	public String addOwnerAndBlogs(@RequestBody Owner owner) {
		dao.addOwnerAndBlogs(owner);
		return "owner Registered...!";
	}
	
	
	@GetMapping("/loadownerdetails/{ownerID}")
	public Owner loadOwnerDetails(@PathVariable Integer ownerID) {
		return dao.loadOwnerData(ownerID); 
	}
	
	
	@GetMapping("/loadblogdetails/{blogID}")
	public Object loadBlogDetails(@PathVariable Integer blogID) {
		return dao.loadBlogData(blogID);
	}
	
	
	@PostMapping("/deleteowner/{ownerID}")
	public String deleteOwner(@PathVariable Integer ownerID) {
		dao.deleteOwner(ownerID); 
		return "Owner Deleted";
	}
	
	@PostMapping("/addownerblogsandcomments")
	public String addOwnerBlogsAndComments(@RequestBody Owner owner) {
		dao.addOwnerBlogAndComments(owner);
		return "owner created with blog and comments...!";
	}
	
	
	@GetMapping("/findcommentsbyowner/{ownerID}")
	public List<Object[]> findCommentsByOwner(@PathVariable Integer ownerID) {
		return dao.findComments(ownerID);
	}
	
}
