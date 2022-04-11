package com.bit.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Ex01 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test01";
//		String sql = "insert into bbs01 values (7, 'test7', 'tester', 'test')";
//		String sql = "update bbs01 set content='test' where num=6";
		String sql = "delete from bbs01 where num=6";
		
		// io&map 동시
		java.util.Properties info = new Properties();
		info.setProperty("user", "user01");
		info.setProperty("password", "1234");
		
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			java.sql.Connection conn = null;
			conn = DriverManager.getConnection(url, info);
			
			java.sql.Statement stmt = null;
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			System.out.println("DML 수행 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
