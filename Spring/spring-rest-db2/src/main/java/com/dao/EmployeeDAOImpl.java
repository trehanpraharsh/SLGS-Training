package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.entity.Project;
import com.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	@Autowired
	public EmployeeRepo repo;
	
	//static List<User> userData = new ArrayList<User>();


	@Override
	@Transactional
	public void addUser(Employee employee) {
		// TODO Auto-generated method stub
		repo.save(employee);
		
	}
	

}
