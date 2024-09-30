package com.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.BankAccount;
import com.model.Employee;
import com.model.Insurance;
import com.service.EmployeeService;

@SpringBootApplication
@ComponentScan("com")
public class EmployeeClient {

	@Autowired
	private EmployeeService service;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmployeeClient.class, args);
		
		EmployeeService ser = ctx.getBean(EmployeeService.class);
		
//		Employee employee = new Employee(102, "emp2", "chennai");
		
//		ser.saveEmployeetoDB(employee);
		
		
		//code to print all the members of DB
//		List<Employee> empData = ser.printEmployeetoDB();
//		for(Employee emp : empData) {
//			System.out.println(emp);
//		}
		
		//search by ID
		//System.out.println(ser.getEmpByIDtoDB(101));
		
		//add employee to org with an insurance
		Employee employee = new Employee(105, "emp4", "punjab");
		Insurance insurance = new Insurance(105, "Family", 500000);
		BankAccount account = new BankAccount(105, "emp4", "SLGS");
		ser.saveEmployeetoOrg(employee, insurance, account);
		
		
	}
	
	
}
