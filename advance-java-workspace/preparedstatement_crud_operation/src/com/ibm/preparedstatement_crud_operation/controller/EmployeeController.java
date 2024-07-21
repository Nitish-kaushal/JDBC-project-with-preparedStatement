package com.ibm.preparedstatement_crud_operation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.ibm.preparedstatement_crud_operation.connection.EmployeeConnection;
import com.ibm.preparedstatement_crud_operation.entity.Employee;

public class EmployeeController {
	public static void main(String[] args)
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			Connection conn=EmployeeConnection.getEmployeeConnection();
			System.out.println("1.INSERT\n2.DISPLAY\n3.DELETe\n4.UPDATE\n5.EXIT");
			System.out.println("Enter Your Option");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:{
				System.out.println("enter emp id");
				int id=sc.nextInt();
				System.out.println("enter emp name");
				String name=sc.next();
				System.out.println("enter emp email");
				String email=sc.next();
				System.out.println("enter emp phone");
				Long phone=sc.nextLong();
				System.out.println("enter emp joining date");
				//yyyy-mm-dd
				String doj=sc.next();
				//LocalDate doj=LocalDate.parse() ;
				Employee employee = new Employee (id, name, email, phone, LocalDate.parse(doj));
				String insertQuery="insert into employee(id,name,email,phone,doj)values(?,?,?,?,?)";
				try {
					PreparedStatement ps=conn.prepareStatement(insertQuery); 
					ps.setInt(1, employee.getId());
					ps.setString(2, employee.getName());
					ps.setString(3, employee.getEmail());
					ps.setLong(4, employee.getPhone());
					ps.setObject(5, employee.getDoj());
					
					ps.execute();
				}catch(SQLDataException e) {
					e.printStackTrace();
					System.out.println("data not stored pls check your code");
				}
			}
			break;
			case 2:{
				String  displayQuery="SELECT* FROM employee";
				Employee emp=null;
				Employee employee[] = new Employee[3];
				
				try {
					PreparedStatement ps=conn.prepareStatement(displayQuery);
					ResultSet set=ps.executeQuery();
					while(set.next()) {
						int id =set.getInt("id");
						String name=set.getString("name");
						String email=set.getString("email");
						Long phone=set.getLong("phone");
						LocalDate doj=set.getDate("doj").toLocalDate();
					  Employee  emp = new Employee(id,name,email,phone,doj);
					 
				    	employee [i]=emp;
					    i++;
					} 
					for(Employee employee2: employee)
					{
						System.out.println(employee2);
					}
					
					}catch(SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			break;
			case 3:{
				System.out.println("enter employee id");
				int id=sc.nextInt();
				try {
					PreparedStatement ps=conn.prepareStatement("delete from employee where id=?");
				ps.setInt(1, id);
				int a=ps.executeUpdate();
				String msg=(a!=0)?"data deleted":"given id not found";
				System.out.println(msg);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			
			}
			break;
			case 4:{
				System.out.println("enter employee id");
				int id =sc.nextInt();
				System.out.println("enter employee name");
				String name=sc.nextLine();
				try {
					PreparedStatement ps=conn.prepareStatement("update employee set name=? where id=?");
					ps.setInt(1,id);
					ps.setString(1, name);
					int a=ps.executeUpdate();
					String msg=(a!= 0)?"data not updated": "given id not found";
					System.out.println(msg);
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			}
			break;
			case 5:{
				System.exit(0);
				
			}
			break;
			}
		}
	}
}


