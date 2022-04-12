package com.bit.db;

import java.sql.*;

public class Ex04 {

	public static void printList() {
		String sql = "select * from dept";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = Ex02.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(Ex02.equals("10", rs.getString(1)));
				System.out.println(Ex02.equals("ACCOUNTING", rs.getString(2)));
				System.out.println(Ex02.equals("NEW YORK", rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		printList();
	}

}
