package com.bit.web;

import java.io.*;
import java.net.*;
import java.util.Arrays;

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
			String msg = br.readLine();
			String[] arr = msg.split(" ");
			System.out.println(arr[1]);
			
			os = sock.getOutputStream();
			bos = new BufferedOutputStream(os);
			
			// header
			bos.write("HTTP/1.1 200 OK\r\n".getBytes());
			bos.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
			// partition
			bos.write("\r\n".getBytes());
			// contents
			if(arr[1].equals("/")) arr[1] = "/index.html";
			FileInputStream is2 = new FileInputStream("." + new File(arr[1]));
			while(true) {
				int su = is2.read();
				if(su == -1) break;
				bos.write(su);
			}
			bos.flush();
			
			is2.close();
			br.close();
			isr.close();
			is.close();
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