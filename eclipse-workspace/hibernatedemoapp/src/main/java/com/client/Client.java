package com.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.sf.FactoryProvider;

public class Client {
	
	public static void main(String[] args) {
		
		Session session = FactoryProvider.getSession();
//		Session session2 = FactoryProvider.getSession();
		
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee(101, "Praharsh", "Gujarat");
		session.save(employee);
		transaction.commit();
		System.out.println("Employee added...!");
		
		//query to load or display the records
//		Query query = session.createQuery("from Employee");
//		List<Employee> data = query.list();
//		for(Employee emp : data) {
//			System.out.println(emp);
//		}
		
		//to implement select by empID
//		Employee employee = session.load(Employee.class, new Integer(101));
//		System.out.println(employee);
		
		
		//to check the cache of the sessions
//		Employee employee = session.load(Employee.class, new Integer(101));
//		System.out.println(employee);
//		
//		Employee employee2 = session2.load(Employee.class, new Integer(101));
//		System.out.println(employee2);
		
		

		
	}

}
