package com.service;

import java.util.List;

import com.model.BankAccount;
import com.model.Employee;
import com.model.Insurance;

public interface EmployeeService {
	
	public void saveEmployeetoOrg(Employee employee, Insurance insurance, BankAccount account);
	
	public List<Employee> printEmployeetoDB();
	
	public Employee getEmpByIDtoDB(int empID);

}
