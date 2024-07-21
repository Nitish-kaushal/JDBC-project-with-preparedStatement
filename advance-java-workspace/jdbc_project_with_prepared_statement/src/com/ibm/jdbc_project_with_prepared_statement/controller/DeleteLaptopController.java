package com.ibm.jdbc_project_with_prepared_statement.controller;

import com.ibm.jdbc_project_with_prepared_statement.dao.LaptopDao;

public class DeleteLaptopController {
	public static void main(String[] args) {
		LaptopDao dao=new LaptopDao();
		int num=dao.deleteLaptopByIdDao(1233);
		String msg=(num!=0)?"delete":"give id not found";
		System.out.println(msg);
	}

}
