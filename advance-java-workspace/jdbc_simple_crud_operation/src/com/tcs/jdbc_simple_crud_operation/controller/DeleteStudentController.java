package com.tcs.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentController {
	public static void main(String[] args)
	// step 1:load register driver
	{
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2: create connection
			String url = "jdbc:mysql://localhost:3306/jdbc-a2";
			String user = "root";
			String pass = "nitish&0088";
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println(connection);
			// step 3: create statement to execute query
			Statement statement = connection.createStatement();
			// step 4: delete Query
			String deleteStudentQuery = "delete from student where id=123";
			
			statement.executeUpdate(deleteStudentQuery);
			System.out.println("deleteQuery is successfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			// step 5: close connection
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



