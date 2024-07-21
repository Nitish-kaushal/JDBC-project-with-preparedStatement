package com.tcs.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DisplayStudentByIdController {
	public static void main(String[] args)
	{
		//fetch only single students whos id is 109
		 Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // step 2: create connection
	            String url = "jdbc:mysql://localhost:3306/jdbc-a2";
	            String user = "root";
	            String pass = "nitish&0088";
	            connection = DriverManager.getConnection(url, user, pass);
	            System.out.println("Connection established: " + connection);
	            // step 3: create statement to execute query
	            Statement statement = connection.createStatement();
	            // step 4: query to display all students
	            String displayAllStudent = "SELECT * FROM student where id=109";
	            ResultSet set = statement.executeQuery(displayAllStudent);
	            // step 5: process the result set and display data
	            while (set.next()) {
	                int id = set.getInt("id");
	                String name = set.getString("name");
	                String email = set.getString("email");
	                String gender = set.getString("gender");
	                String phone = set.getString("phone");
	                LocalDate dob = set.getDate("dob").toLocalDate();
	                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Gender: " + gender + ", Phone:"+phone+", DOB: " + dob);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // step 6: close connection
	            try {
	                if (connection != null) {
	                    connection.close();
	                    System.out.println("Connection closed.");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	


	}
