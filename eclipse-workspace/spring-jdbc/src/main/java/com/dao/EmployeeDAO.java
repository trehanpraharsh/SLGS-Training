package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {
	
	public void saveEmployee(Employee employee);
	
	public List<Employee> printEmployee();
	
	public Employee getEmpByID(int empID);
	
	

}
