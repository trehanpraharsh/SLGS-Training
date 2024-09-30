package com.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	

}
