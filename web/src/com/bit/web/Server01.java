package com.bit.web;

import java.io.*;
import java.net.*;

public class Server01 {

	public static void main(String[] args) {
		ServerSocket serv = null;
		Socket sock = null;
		OutputStream os = null;
		PrintStream ps = null;
		
		try {
			serv = new ServerSocket(8080);
			sock = serv.accept();
			InetAddress addr = sock.getInetAddress();
			System.out.println(addr.getHostAddress() + " 님 접속이 들어왔습니다.");
			
			os = sock.getOutputStream();
			ps = new PrintStream(os);
			
//			ps.println("Header info");
			ps.println("HTTP/1.1 200 ok");
			ps.println();	// 개행으로 구분 (위쪽은 헤더, 아래쪽은 내용)
			ps.println("documents....");
//			ps.println("documents....2");
			
			sock.close();
			
			sock = serv.accept();
			addr = sock.getInetAddress();
			System.out.println(addr.getHostAddress() + " 님 접속이 들어왔습니다.");
			
			os = sock.getOutputStream();
			ps = new PrintStream(os);
			
//			ps.println("Header info");
			ps.println("HTTP/1.1 200 ok");
			ps.println();	// 개행으로 구분 (위쪽은 헤더, 아래쪽은 내용)
			ps.println("documents....");
//			ps.println("documents....2");
			
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serv != null) serv.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
