package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	public static void main(String[] args) throws IOException{
		DatagramSocket dsock = null;
		dsock = new DatagramSocket(12345);
		System.out.println("수신 대기중...");
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		String msg = new String(receivePacket.getData(), 0, receivePacket.getData().length);		//0~length까지
		System.out.println("수신 : " + msg);
		DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length, receivePacket.getAddress(), receivePacket.getPort());
		dsock.send(sendPacket);
		System.out.println("UDPEchoServer를 종료합니다.");
		if(dsock != null) {
			dsock.close();
		}
	}
}
