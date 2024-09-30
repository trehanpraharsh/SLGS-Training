package com.client;

import java.util.ArrayList;
import java.util.List;

import com.dao.EmployeeDAO;
import com.exception.DaoException;
import com.exception.EmployeeDAOImpl;
import com.exception.EmployeeNotFound;
import com.model.Employee;

public class Client {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		//Insert the values by passing here
//		Employee emp = new Employee(102, "Adarsh", "OD");
//		try {
////			dao.saveEmployee(emp);
////			List<Employee> al = dao.loadEmps();
////			al.stream().forEach(s-> System.out.println(s));
//
//			
//			
//		} //catch (DaoException e) {
////			System.out.println(e.getMessage());
////		}
//		catch (EmployeeNotFound e) {
//			System.out.println(e.getMessage());
//		}
		
		//Delete func
//		try {
//			dao.deleteEmp("Adarsh");
//			
//		} catch (EmployeeNotFound e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		
		try {
			System.out.println(dao.updateEmp("PT", 101));
		} catch (EmployeeNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
