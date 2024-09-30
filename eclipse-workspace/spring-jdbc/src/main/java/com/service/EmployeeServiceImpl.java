package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BankAccountDAO;
import com.dao.EmployeeDAO;
import com.dao.InsuranceDAO;
import com.model.BankAccount;
import com.model.Employee;
import com.model.Insurance;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO empDao;
	
	@Autowired
	private InsuranceDAO insDao;
	
	@Autowired
	private BankAccountDAO bnkDao;

	@Override
	//used for it to handle the transactions using ACID properties
	@Transactional
	public void saveEmployeetoOrg(Employee employee, Insurance insurance, BankAccount account) {
		// TODO Auto-generated method stub
		empDao.saveEmployee(employee);
		if(employee.getEmpID() == 105) {
			throw new NumberFormatException("Employee is not allowed");
		}
		insDao.addInsurance(insurance);
		bnkDao.addAccount(account);
		
	}

	@Override
	public List<Employee> printEmployeetoDB() {
		// TODO Auto-generated method stub
		return empDao.printEmployee();
	}

	@Override
	public Employee getEmpByIDtoDB(int empID) {
		// TODO Auto-generated method stub
		return empDao.getEmpByID(empID);
		
	}

}
