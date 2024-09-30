package com.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.BankAccount;

import jakarta.annotation.PostConstruct;


@Repository
public class BankAccountDAOImpl extends JdbcDaoSupport implements BankAccountDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void init() {
		setDataSource(dataSource);
	}
	

	@Override
	public void addAccount(BankAccount account) {
		// TODO Auto-generated method stub
		String insertCode = "insert into bank values(?,?,?)";
		getJdbcTemplate().update(insertCode, new Object[] {
			account.getEmpID(), account.getEmpName(), account.getOrgName()	
		});
		
	}

	
	
}
