package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server01 {
	public static void main(String[] args) throws IOException{
		DatagramSocket dsock = new DatagramSocket(12345);
		System.out.println("수신 대기중...");
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println("수신 : " + msg);
		System.out.println("수신 메시지 길이 : " + receivePacket.getData());
		System.out.println("수신 ip : " + receivePacket.getAddress());
		System.out.println("수신 port : " + receivePacket.getPort());
		System.out.println("UDPEchoServer를 종료합니다.");
		if(dsock != null) {
			dsock.close();
		}
	}
}
