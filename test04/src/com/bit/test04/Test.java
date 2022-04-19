package com.bit.test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

class Stu {
	int stuid;
	String name, kor, eng, math;
}

public class Test {
	
	public static ArrayList<Stu> getDataList() {
		ArrayList<Stu> list = new ArrayList<Stu>();
		String sql = "select * from student";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Stu stu = new Stu();
				stu.stuid = rs.getInt(1);
				stu.name = rs.getString(2);
				stu.kor = rs.getString(3);
				stu.eng = rs.getString(4);
				stu.math = rs.getString(5);
				list.add(stu);
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
		return list;
	}
	
	public static boolean studentIdCheck(int stuid) {
		ArrayList<Stu> list = getDataList();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).stuid == stuid) return true;
		}
		return false;
	}
	
	public static boolean studentNameCheck(String name) {
		ArrayList<Stu> list = getDataList();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).name.equals(name)) return true;
		}
		return false;
	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password = "1234";

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = null;
		while (true) {
			System.out.print("1.보기 2.입력 3.수정 4.삭제 0.종료>");
			input = sc.nextLine();

			if (input.equals("0"))
				break;
			if (input.equals("1")) {
				String sql = "Select stuid, name, kor, eng, math, truncate((kor+eng+math)/3, 2) from student order by stuid";
				System.out.println("==============================================");
				System.out.println("학번\t이름\t국어\t영어\t수학\t평균");
				System.out.println("==============================================");
				
				Connection conn = getConnection();
				Statement stmt = null;
				ResultSet rs = null;
				try {
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						System.out.print(rs.getInt(1) + "\t");
						System.out.print(rs.getString(2) + "\t");
						System.out.print(rs.getString(3) + "\t");
						System.out.print(rs.getString(4) + "\t");
						System.out.print(rs.getString(5) + "\t");
						System.out.println(rs.getString(6));
					}
					System.out.println("==============================================");
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if (input.equals("2")) {
				String kor, eng, math;
				System.out.print("name>");
				String name = sc.nextLine();
				if(studentNameCheck(name)) {
					System.out.println("동명이인이 있습니다 계속 진행하시겠습니까?");
					System.out.print("1.계속 2.다시 >");
					if(sc.nextLine().equals("2")) {
						System.out.print("name>");
						name = sc.nextLine();
					}
				}
				while(true) {
					System.out.print("kor>");
					kor = sc.nextLine();
					if(Integer.parseInt(kor) < 0 || Integer.parseInt(kor) > 101) {
						System.out.println("올바른 점수를 입력해 주세요.");
						continue;
					}
					break;
				}
				while(true) {
					System.out.print("eng>");
					eng = sc.nextLine();
					if(Integer.parseInt(eng) < 0 || Integer.parseInt(eng) > 101) {
						System.out.println("올바른 점수를 입력해 주세요.");
						continue;
					}
					break;
				}
				while(true) {
					System.out.print("math>");
					math =  sc.nextLine();
					if(Integer.parseInt(math) < 0 || Integer.parseInt(math) > 101) {
						System.out.println("올바른 점수를 입력해 주세요.");
						continue;
					}
					break;
				}
				String sql = "insert into student (name, kor, eng, math) values ('" + name + "', '" + kor + "', '" + eng + "', '" + math + "')"; 
				
				Connection conn = null;
				Statement stmt = null;
				try {
					conn = getConnection();
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if(input.equals("3")) {
				System.out.print("수정할 학번 선택>");
				int stuid = Integer.parseInt(sc.nextLine());
				if(!studentIdCheck(stuid)) {
					System.out.println("학번이 없습니다 다시 입력해주세요.");
					continue;
				}
				System.out.print("국어>");
				String sql = "update student set kor = '" + sc.nextLine();
				System.out.print("영어>");
				sql += "', eng = '" + sc.nextLine();
				System.out.print("수학>");
				sql += "', math = '" + sc.nextLine() + "' where stuid = " + stuid;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					conn = getConnection();
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if(input.equals("4")) {
				System.out.print("삭제할 한번 선택>");
				int stuid = Integer.parseInt(sc.nextLine());
				if(!studentIdCheck(stuid)) {
					System.out.println("학번이 없습니다 다시 입력해주세요.");
					continue;
				}
				String sql = "delete from student where stuid = " + stuid;
				
				Connection conn = null;
				Statement stmt = null;
				try {
					conn = getConnection();
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
}
