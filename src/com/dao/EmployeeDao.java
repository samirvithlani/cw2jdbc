package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.EmployeeBean;
import com.util.DBConnection;

public class EmployeeDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public int addEmployee(EmployeeBean employeeBean) {
		int res = 0;
		conn = DBConnection.getDbConnection();
		if (conn != null) {
			String insertSQL = "insert into employee(ename,eemail,eage)values(?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, employeeBean.geteName());
				pstmt.setString(2, employeeBean.geteEmail());
				pstmt.setInt(3, employeeBean.geteAge());

				res = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return res;
	}

}
