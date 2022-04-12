package com.bit.udp;

import java.io.IOException;
import java.net.*;

public class Sender {

	public static void main(String[] args) {
		byte[] arr = {127, 0, 0, 1};
		InetAddress addr = null;
		int port = 5000;
		
		DatagramSocket dsock = null;
		DatagramPacket packet = null;
		
		try {
			addr = InetAddress.getByAddress(arr);
			dsock = new DatagramSocket();
			
			String msg = "helloUDP";
			packet = new DatagramPacket(msg.getBytes(), msg.length(), addr, port);
			dsock.send(packet);
			
			String msg2 = "잘받았습니다.";
			packet = new DatagramPacket(msg2.getBytes(), msg2.getBytes().length, addr, port);
			System.out.println(msg2.getBytes().length);
			dsock.send(packet);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dsock != null) dsock.close();
		}
	}

}
