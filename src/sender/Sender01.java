package sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender01 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		
		System.out.print("송신 데이터 : ");
		String msg = in.next();
		InetAddress ia = InetAddress.getByName("127.0.0.255");
		DatagramPacket data = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 12345);
		ds.send(data);
		
		ds.close();
	}
}
