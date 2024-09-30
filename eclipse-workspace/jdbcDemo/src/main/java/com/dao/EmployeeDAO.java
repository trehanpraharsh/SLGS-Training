package com.dao;

import java.util.List;
import java.util.Optional;

import com.exception.DaoException;
import com.exception.EmployeeNotFound;
import com.model.Employee;

public interface EmployeeDAO {
	
	public Employee saveEmployee(Employee employee) throws DaoException;
	
	public List<Employee> loadEmps() throws DaoException;
	
	public Optional<Employee> findEmp(String name) throws EmployeeNotFound;
	
	public Optional<Employee> deleteEmp(String name) throws EmployeeNotFound;
	
	public Optional<Employee> updateEmp(String name, int ID) throws EmployeeNotFound;

}
