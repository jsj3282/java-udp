package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client01 {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		InetAddress inetaddr = InetAddress.getByName("127.0.0.1");
		
		DatagramSocket dsock = new DatagramSocket();
		System.out.println("송신 메시지 입력 : ");
		String line = input.nextLine();
		
		DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, 12345);
		dsock.send(sendPacket);
		System.out.println("UDPEchoClient를 종료합니다");
		if(dsock != null) {
			dsock.close();
		}
		
	}
}
