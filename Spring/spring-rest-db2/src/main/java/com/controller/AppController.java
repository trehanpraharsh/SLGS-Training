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

import com.dao.EmployeeDAO;
import com.entity.Employee;
import com.entity.Project;


@Controller
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	private EmployeeDAO dao;
	
	@PostMapping("/register")
	@ResponseBody
	public String userRegister(@RequestBody Employee employee) {
		
		//Bl to add the user to the list
		dao.addUser(employee);
		return employee.getEmpName() + " Registered Successfully......";
	}
	
}
