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
		System.out.println("�۽� �޽��� �Է� : ");
		String line = input.nextLine();
		
		DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, inetaddr, 12345);
		dsock.send(sendPacket);
		System.out.println("UDPEchoClient�� �����մϴ�");
		if(dsock != null) {
			dsock.close();
		}
		
	}
}
