package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		InetAddress inetaddr = null;
		inetaddr = InetAddress.getByName("127.0.0.1");
		
		DatagramSocket dsock = null;
		dsock = new DatagramSocket();
		String line = null;
		System.out.print("�۽� �޽��� �Է� : ");
		line = input.nextLine();
		DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, 12345);
		dsock.send(sendPacket);
		byte[] buffer = new byte[line.getBytes().length];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);
		System.out.println("���� : " + msg);
		System.out.println("UDPClinet�� �����մϴ�.");
		if(dsock != null) {
			dsock.close();
		}
	}
}
