package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerEcho {
	public static void main(String[] args) throws IOException{
		DatagramSocket dsock = new DatagramSocket(12345);
		System.out.println("���� �����...");
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println("���� : " + msg);
		System.out.println("���� �޽��� ���� : " + receivePacket.getData());
		System.out.println("���� ip : " + receivePacket.getAddress());
		System.out.println("���� port : " + receivePacket.getPort());
		String msg2 = receivePacket.toString();
		DatagramPacket sendPacket = new DatagramPacket(msg2.getBytes(), msg2.getBytes().length, receivePacket.getAddress(), receivePacket.getPort());
		dsock.send(sendPacket);
		
		if(dsock != null) {
			dsock.close();
		}
	}
}
