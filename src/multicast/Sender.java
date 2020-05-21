package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Sender {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		MulticastSocket ms = new MulticastSocket();
		
		System.out.print("송신 데이터 : ");
		String msg = in.next();
		InetAddress ia = InetAddress.getByName("224.200.200.1");
		DatagramPacket data = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 12345);
		
		ms.send(data);
		
		ms.close();
	}
}
