package com.bit.test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password = "1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("학생성적관리프로그램(ver 0.9.0)");
		String input = null;
		
		while(true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료>");
			input = sc.nextLine();
			if(input.equals("0")) break;
			if(input.equals("1")) {
				String sql = "select num, name, kor, eng, math, truncate((kor+eng+math)/3, 2) from stu01";
				try {
					conn = DriverManager.getConnection(url, user, password);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					
					while(rs.next()) {
						System.out.print(rs.getInt(1) +"\t");
						System.out.print(rs.getNString(2) + "\t");
						System.out.print(rs.getInt(3) + "\t");
						System.out.print(rs.getInt(4) + "\t");
						System.out.print(rs.getInt(5) + "\t");
						System.out.println(rs.getString(6));
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
		}
		System.out.println("이용해주셔서 감사합니다.");
	}

}
