package com.ibm.jdbc_project_with_prepared_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class LaptopConnection {
	public static Connection getLaptopConnection() {
		try {
			//step 1: load/register Driver 
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			//step 2: create connection
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a2","root","nitish&0088");
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
			
			}
		}
	}

