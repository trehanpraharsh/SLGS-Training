package com.exception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dao.EmployeeDAO;
import com.db.ConnectionTest;
import com.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection conn;
	public EmployeeDAOImpl() {
		ConnectionTest ct = new ConnectionTest();
		conn = ct.getConnection();
		
	}
	
	String insertQuery = "insert into Employee values(?,?,?)";
	String loadEmpsQuery = "select * from Employee";
	String findEmpQuery = "select * from Employee where empName = ?";
	String deleteEmpQuery = "delete from Employee where empName = ?";
	String updateEmpQuery = "update Employee set empName = ? where empID = ? ";

	@Override
	public Employee saveEmployee(Employee employee) throws DaoException {
		// TODO Auto-generated method stub
		
//		ConnectionTest ct = new ConnectionTest();
//		Connection conn = ct.getConnection();
		
		//PreparedStatement is used to take input from the user
		try {
			PreparedStatement pst = conn.prepareStatement(insertQuery);
			pst.setInt(1, employee.getEmpID());
			pst.setString(2, employee.getEmpName());
			pst.setString(3, employee.getEmpLocation());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			//Passing the error message to client and error object to backend
			throw new DaoException("Employee not saved!", e);
		}
		
		
		return null;
	}

	@Override
	public List<Employee> loadEmps() throws DaoException {
		// TODO Auto-generated method stub
		List<Employee> empData = new ArrayList<Employee>();
		try {
			
//			ConnectionTest ct = new ConnectionTest();
//			Connection conn = ct.getConnection();
			PreparedStatement pst = conn.prepareStatement(loadEmpsQuery);
			//Resultset is used storing the data
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
				empData.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Employee did not load", e);
		}
		
		
		
		
		return empData;
	}

	@Override
	public Optional<Employee> findEmp(String name) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = conn.prepareStatement(findEmpQuery);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
				return Optional.of(emp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeNotFound("The searched Employee does not exist, kindly check the name!");
		
		}
		
		
		
		return Optional.empty();
		
	}

	@Override
	public Optional<Employee> deleteEmp(String name) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		Optional<Employee> isfound = findEmp(name);
		
		if(isfound != null) {
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(deleteEmpQuery);
				ps.setString(1, name);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<Employee> updateEmp(String name, int ID) throws EmployeeNotFound {
		// TODO Auto-generated method stub
		
		Optional<Employee> isFound = findEmp(name);
		
		if(isFound != null) {
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(updateEmpQuery);
				ps.setString(1, name);
				ps.setInt(2, ID);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Wrong name");
		}
		
		return Optional.empty();
	}

}
