package com.bit.web;

import java.io.*;
import java.net.*;

public class Server02 extends Thread {
	Socket sock;
	
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		
		try {
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while(true){
				String msg = br.readLine();
				if(msg == null) break;
				System.out.println(msg);
			}
			br.close();
			isr.close();
			is.close();
			
			os = sock.getOutputStream();
			bos = new BufferedOutputStream(os);
			
			// header
			bos.write("HTTP/1.1 200 OK\r\n".getBytes());
			bos.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
			// partition
			bos.write("\r\n".getBytes());
			// contents
			bos.write("<h1>aaaa</h1> <p>bbbb</p>".getBytes());
//			InputStream is = new FileInputStream(new File("lg_naver.gif"));
//			while(true) {
//				int su = is.read();
//				if(su == -1) break;
//				bos.write(su);
//			}
//			
//			is.close();
			
			bos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				if(os != null) os.close();
				if(sock != null) sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ServerSocket serv = null;
		
		try {
			serv = new ServerSocket(8080);
			
			while(true) {
				Socket sock = serv.accept();
				Server02 me = new Server02();
				me.sock = sock;
				me.start();
			}
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