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
		System.out.println("송신 메시지 입력 : ");
		String line = input.nextLine();
		//DatagramSocket은 byte형태밖에 못들어온다
		
		DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, 12345);
		dsock.send(sendPacket);
		
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println("수신 : " + msg);
		System.out.println("수신 메시지 길이 : " + receivePacket.getData());
		System.out.println("수신 ip : " + receivePacket.getAddress());
		System.out.println("수신 port : " + receivePacket.getPort());
	}
}
