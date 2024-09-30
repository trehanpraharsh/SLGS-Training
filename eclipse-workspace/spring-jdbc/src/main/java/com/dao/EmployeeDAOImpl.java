package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.Employee;

import jakarta.annotation.PostConstruct;


@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	//setDataSource does the all 4 steps like initialize driver, write statement etc.
	private void init() {
		setDataSource(dataSource);
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String insertCode = "insert into employee values(?,?,?)";
		//the update function uses PreparatoryStatement by default
		getJdbcTemplate().update(insertCode, new Object[] {employee.getEmpID(), employee.getEmpName(), employee.getEmpLocation()});
		
	}

	@Override
	public List<Employee> printEmployee() {
		// TODO Auto-generated method stub
		String insertQuery = "select * from employee";
		List<Employee> employeeDetailList = new ArrayList<Employee>();
		
		getJdbcTemplate().query(insertQuery, new ResultSetExtractor<List<Employee>>() {
			
			public List<Employee> extractData(ResultSet rs){
				
				try {
					while(rs.next()) {
						Employee employee = new Employee();
						try {
							employee.setEmpID(rs.getInt(1));
							employee.setEmpName(rs.getString(2));
							employee.setEmpLocation(rs.getString(3));
							employeeDetailList.add(employee);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return employeeDetailList;
				
			}
			
			
		});
		return employeeDetailList;
	}

	
	@Override
	public Employee getEmpByID(int empID) {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from employee where empID=?";
		
		return getJdbcTemplate().queryForObject(sqlQuery, new Object[] {empID}, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee = new Employee(rs.getInt("empID"), rs.getString("empName"), rs.getString("empLocation"));
				return employee;
			}
			
		});
		
	}
	
	

}
