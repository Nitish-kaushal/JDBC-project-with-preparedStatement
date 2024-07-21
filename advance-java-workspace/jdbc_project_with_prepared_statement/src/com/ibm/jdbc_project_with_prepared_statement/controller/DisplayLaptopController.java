package com.ibm.jdbc_project_with_prepared_statement.controller;

import java.util.List;

import com.ibm.jdbc_project_with_prepared_statement.dao.LaptopDao;
import com.ibm.jdbc_project_with_prepared_statement.dto.Laptop;

public class DisplayLaptopController {
	public static void main(String[] args) {
		LaptopDao dao=new LaptopDao();
		List<Laptop> laptops=dao.displayAllLaptopDao();
		for(Laptop laptop:laptops) {
			System.out.println(laptop);
		}
	}
}
