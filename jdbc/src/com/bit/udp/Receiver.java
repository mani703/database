package com.bit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) {
<<<<<<< HEAD
		byte[] buf = new byte[19];
=======
		byte[] buf = new byte[128];
>>>>>>> refs/remotes/origin/refs/heads/master
		DatagramSocket sock = null;
		DatagramPacket packet = null;
		
		try {
			sock = new DatagramSocket(5000);
			
			packet = new DatagramPacket(buf, buf.length);
			sock.receive(packet);
			System.out.println(new String(buf));
			
			packet = new DatagramPacket(buf, buf.length);
			sock.receive(packet);
			System.out.println(new String(buf));
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sock != null) sock.close();
		}
	}

}
