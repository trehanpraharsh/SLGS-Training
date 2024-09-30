package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.Insurance;

import jakarta.annotation.PostConstruct;

@Repository
public class InsuranceDAOImpl extends JdbcDaoSupport implements InsuranceDAO{
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void init() {
		setDataSource(dataSource);
	}
	

	@Override
	public void addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		String insertCode = "insert into insurance values(?,?,?)";
		getJdbcTemplate().update(insertCode, new Object[] {
			insurance.getEmpID(), insurance.getScheme(), insurance.getAmount()	
		});
		
	}
	

}
