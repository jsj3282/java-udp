package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientEcho {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		InetAddress inetaddr = InetAddress.getByName("127.0.0.1");
		
		DatagramSocket dsock = new DatagramSocket();
		System.out.println("�۽� �޽��� �Է� : ");
		String line = input.nextLine();
		//DatagramSocket�� byte���¹ۿ� �����´�
		
		DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, 12345);
		dsock.send(sendPacket);
		
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println("���� : " + msg);
		System.out.println("���� �޽��� ���� : " + receivePacket.getData());
		System.out.println("���� ip : " + receivePacket.getAddress());
		System.out.println("���� port : " + receivePacket.getPort());
	}
}
