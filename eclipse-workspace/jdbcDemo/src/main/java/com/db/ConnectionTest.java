package com.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
	
	private String driver = prop.getProperty("driver");
	private String connString = prop.getProperty("connString");
	private Connection conn;
	private String userName = prop.getProperty("userName");;
	private String userPassword = prop.getProperty("userPassword");;
	
	static Properties prop = new Properties();
	static {
		try {
			prop.load(new FileInputStream("db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	//Initializing this will load the driver
	public ConnectionTest() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
		try {
			if(conn == null) {
				
				conn = DriverManager.getConnection(connString, userName, userPassword);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
		
	}

}
