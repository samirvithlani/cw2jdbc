package com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class StudentController {

	// load driver
	// getting connection with database
	// create statement
	// create query
	// submit query
	// get result
	// [op] trancation management

	// statement java.sql.Statement interface
	// to compile query

	void insertStudent() {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			// create statement
			try {
				Statement stmt = conn.createStatement();
				// create query
				System.out.println("enter age");
				int age = sc.nextInt();
				System.out.println("enter name");
				String name = sc.next();
				String insertSQL = "insert into student(sname,sage)values('" + name + "'," + age + ")";
				// submit
				/// 3 methods avaialbe for submit query
				// stmt.execute(sql) -->DDL DML
				// stmt.executeUpdate(sql) row manuplate
				// stmt.executeQuery(sql) select
				/// stmt.executeLargeUpdate(sql)
				int res = stmt.executeUpdate(insertSQL);
				if (res > 0) {
					System.out.println(res + "rows inserted ");
				} else {
					System.out.println("No rows affected...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("connection failed...");
		}

	}

	public void deleteStudent() {

		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			// System.out.println("enter student id to delete :");
			// int id = sc.nextInt();

			System.out.println("enter stduent name to delete");
			String name = sc.next();
			try {
				Statement stmt = conn.createStatement();
				String deleteSQL = "delete from student where sname = '" + name + "' ";
				int res = stmt.executeUpdate(deleteSQL);
				if (res > 0) {

					System.out.println(res + " Rows deleted...");
				} else {
					System.out.println("no rows deleted...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateStudent() {
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			try {
				Statement stmt = conn.createStatement();
				System.out.println("enter id to update");
				int id = sc.nextInt();
				System.out.println("enter name to update");
				String name = sc.next();
				System.out.println("enter age to update");
				int age = sc.nextInt();
				String updateSQL = "update student set sname ='" + name + "',sage =" + age + " where sid  = " + id + " ";
				int res = stmt.executeUpdate(updateSQL);
				if (res > 0) {

					System.out.println(res + " Rows updated...");
				} else {
					System.out.println("no rows updated...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	
	public void getAllRecordFormDb() {
		
		Connection conn = DBConnection.getDbConnection();
		
		
		if(conn!=null) {
			
			try {
				Statement stmt = conn.createStatement();
				String selectSQL = "select * from student where sage>=45";
				ResultSet rs = stmt.executeQuery(selectSQL);
				System.out.println("ID\tNAME\tAGE");
				System.out.println("--\t----\t---");
				while(rs.next()) {
					//System.out.println(rs.getInt("sid"));
					System.out.print(""+rs.getInt(1));
					System.out.print("\t"+rs.getString(2));
					System.out.print("\t"+rs.getInt(3));
					System.out.println();
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {

		StudentController studentController = new StudentController();
		 //studentController.insertStudent();
		//studentController.deleteStudent();
		//studentController.updateStudent();
		studentController.getAllRecordFormDb();
	}

}
