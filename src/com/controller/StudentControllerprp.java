package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//udf student  --> list -->steam api -->pstmt..

import com.util.DBConnection;

public class StudentControllerprp {

	public void addStudent() {

		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			String insertSQL = "insert into student(sname,sage)values(?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				System.out.println("enter name");
				String name = sc.next();
				System.out.println("enter age");
				int age = sc.nextInt();
				pstmt.setString(1, name);
				pstmt.setInt(2, age);
				int res = pstmt.executeUpdate();
				if (res > 0) {

					System.out.println(res + "rows inserted..");
				} else {
					System.out.println("No rows inserted...");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteStudent() {

		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			// System.out.println("enter student id to delete :");
			// int id = sc.nextInt();

			System.out.println("enter stduent id to delete");
			int id = sc.nextInt();
			try {
				String deleteSQL = "delete from student where sid = ?";
				PreparedStatement pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setInt(1, id);
				int res = pstmt.executeUpdate();
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

	public void bulkInsertStudent() {

		Connection conn = DBConnection.getDbConnection();
		Scanner sc = new Scanner(System.in);
		if (conn != null) {

			String insertSQL = "insert into student(sname,sage)values(?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);

//				System.out.println("enter name");
//				String name = sc.next();
//				System.out.println("enter age");
//				int age = sc.nextInt();
//				pstmt.setString(1, name);
//				pstmt.setInt(2, age);
//				pstmt.addBatch();
//				System.out.println("enter name");
//				name = sc.next();
//				System.out.println("enter age");
//				age = sc.nextInt();
//				pstmt.setString(1, name);
//				pstmt.setInt(2, age);
//				pstmt.addBatch();
				int flag = 0;
				do {

					System.out.println("enter name");
					String name = sc.next();
					System.out.println("enter age");
					int age = sc.nextInt();
					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					pstmt.addBatch();
					System.out.println("want to add more??? if yes press 0 if no press 1");
					flag = sc.nextInt();
					

				} while (flag ==0);
				int res[] = pstmt.executeBatch();
				if (res.length > 0) {
					System.out.println("rows inserted...");
				} else {

					System.out.println("no row inserted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		StudentControllerprp studentControllerprp = new StudentControllerprp();
		// studentControllerprp.addStudent();
		// studentControllerprp.deleteStudent();
		studentControllerprp.bulkInsertStudent();

	}
}
