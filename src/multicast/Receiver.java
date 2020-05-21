package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {
	public static void main(String[] args) throws IOException{
		System.out.println("수신 대기 중 ...");
		MulticastSocket ms = new MulticastSocket(12345);
		
		ms.joinGroup(InetAddress.getByName("224.200.200.1"));
		
		byte[] by = new byte[1024];
		DatagramPacket data = new DatagramPacket(by, by.length);
		ms.receive(data);
		
		String str = new String(data.getData());
		System.out.println("수신 데이터 : " + str);
		
	}
}
