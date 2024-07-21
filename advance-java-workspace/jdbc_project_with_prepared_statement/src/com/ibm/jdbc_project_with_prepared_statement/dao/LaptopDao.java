package com.ibm.jdbc_project_with_prepared_statement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ibm.jdbc_project_with_prepared_statement.connection.LaptopConnection;
import com.ibm.jdbc_project_with_prepared_statement.dto.Laptop;

public class LaptopDao {
	Connection connection=LaptopConnection.getLaptopConnection();
	final String INSERT_LAPTOP_QUERY="INSERT INTO laptop(id,name,color,price,mfd)values(?,?,?,?,?)";
	final String DELETE_LAPTOP_QUERY="DELETE from laptop where id=?";
	final String UPDATE_LAPTOP_QUERY="update laptop set name=? where id=?";
	final String DISPLAY_ALL_LAPTOP_QUERY="SELECT* FROM laptop";
	final String DISPLAY_SINGLE_LAPTOP_QUERY="SELECT*FROM laptop where id=?";
	public Laptop saveLaptopDao(Laptop laptop) {
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_LAPTOP_QUERY);
			ps.setInt(1,laptop.getId());
			ps.setString(2,laptop.getName());
			ps.setString(3,laptop.getColor());
			ps.setDouble(4,laptop.getPrice());
			ps.setObject(5,laptop.getMfd());
			ps.execute();
			return laptop;
		}catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public Laptop deleteLaptop(Laptop laptop)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(DELETE_LAPTOP_QUERY);
			ps.setInt(1, laptop.getId());
			ps.setString(2, laptop.getName());
			ps.setString(3, laptop.getColor());
			ps.setDouble(4, laptop.getPrice());
			ps.setObject(5, laptop.getMfd());
			ps.execute();
			return laptop;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	public List<Laptop> displayAllLaptopDao(){
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_ALL_LAPTOP_QUERY);
			ResultSet set=ps.executeQuery();
			List<Laptop> laptops=new ArrayList<Laptop>();
			
			while(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				String color=set.getString("color");
				double price=set.getDouble("price");
				LocalDate mfd=set.getDate("mfd").toLocalDate();
				
				Laptop laptop =new Laptop(id,name,color,price,mfd);
				
				laptops.add(laptop);
			}
			return laptops;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	public int deleteLaptopByIdDao(int laptopId) {
		try {
			PreparedStatement ps=connection.prepareStatement(DELETE_LAPTOP_QUERY);
			ps.setInt(1, laptopId);
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public int updateLaptopDao(int laptopId,String name)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_LAPTOP_QUERY);
			ps.setInt(2, laptopId);
			ps.setString(1, name);
			
			return ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	public Laptop displayLaptopByIdDao(int id1) {
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_SINGLE_LAPTOP_QUERY);
			ps.setInt(1, id1);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				String color=set.getString("color");
				Double price=set.getDouble("price");
				LocalDate mfd=set.getDate("mfd").toLocalDate();
				
				return new Laptop(id,name,color,price,mfd);
				
			}else {
				return null;
			}		
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
