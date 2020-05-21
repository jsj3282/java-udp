package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client02 {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		InetAddress inetaddr = InetAddress.getByName("127.0.0.1");
		
		DatagramSocket dsock = null;
		Student st = new Student();
		
		dsock = new DatagramSocket();
		System.out.print("�̸� : ");
		st.setName(input.next());
		System.out.print("���� : ");
		st.setAge(input.nextInt());
		System.out.print("�ּ� : ");
		st.setAddr(input.next());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject((Object)st);			//Ŭ���� ���·� ������ : ������Ʈ���·� ����
		byte[] line = bos.toByteArray();		//�ö� �ִ� ��ü����(������Ʈ Ŭ����)�� ������ ����Ʈ�� ���� - ����ȭ
		
		DatagramPacket sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
		dsock.send(sendPacket);
		System.out.println("UDPEchoClient�� �����մϴ�.");
		
		if(dsock != null) {
			dsock.close();
		}
	}
}
