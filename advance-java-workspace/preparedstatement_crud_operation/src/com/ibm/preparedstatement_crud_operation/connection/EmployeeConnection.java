package com.ibm.preparedstatement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class EmployeeConnection {
	public static Connection getEmployeeConnection()
	{
//		step 1: load/register driver
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
//			step 2: create connection with url,user,pass
			String url = "jdbc:mysql://localhost:3306/jdbc-a2";
			String user = "root";
			String pass = "nitish&0088";
			return DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
