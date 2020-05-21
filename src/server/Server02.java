package server;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import client.Student;

public class Server02 {
	public static void main(String[] args) throws Exception{
		DatagramSocket dsock = new DatagramSocket(12345);
		System.out.println("���� �����...");
		
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		dsock.receive(receivePacket);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bis);
		Student st = new Student();
		st = (Student)in.readObject();
		
		System.out.println("�̸� : " + st.getName());
		System.out.println("���� : " + st.getAge());
		System.out.println("�ּ� : " + st.getAddr());
		
		System.out.println("UDPEchoServer�� �����Ѵ�.");
		if(dsock != null) {
			dsock.close();
		}
	}
}
