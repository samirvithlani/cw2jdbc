package com.controller;

import java.util.Scanner;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

public class EmployeeController {

	//controller...
	
	public void addEmployee() {
		
		EmployeeBean employeeBean = new EmployeeBean();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter employee name");
		String name = sc.next();
		System.out.println("enter employee email");
		String email = sc.next();
		System.out.println("enter employee age");
		int age = sc.nextInt();
		
		//wrap
		employeeBean.seteName(name);
		employeeBean.seteAge(age);
		employeeBean.seteEmail(email);
		
		EmployeeDao employeeDao = new EmployeeDao();
		int res = employeeDao.addEmployee(employeeBean);
		if(res>0) {
			System.out.println("raws inserted..");
		}
		else {
			System.out.println("no rows inserted...");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		EmployeeController employeeController = new EmployeeController();
		employeeController.addEmployee();
	}
	
	
}
