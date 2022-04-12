package com.bit.db;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.Driver;

public class Ex01 {

	public static void main(String[] args) {
		Logger log = Logger.getGlobal();
		
		log.setLevel(Level.INFO);
//		log.setLevel(Level.WARNING);
//		log.setLevel(Level.SEVERE);
		
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
//			System.out.println(driver);	// io 작업으로 인해 메모리 상실
			log.info(driver.toString());
			log.info("정보: info");		// 메시지 전달
			log.severe("심각: severe");	// 심각한 에러
			log.warning("경고: warning");	// 주의
//			log.fine("로그메시지fine");
//			log.finer("로그메시지finer");
//			log.config("로그메시지config");
//			log.finest("로그메시지finest");
			
		} catch (SQLException e) {
			e.printStackTrace();
//			log.severe("심각: severe");
		}
	}

}
