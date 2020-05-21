package client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientFile {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner input = new Scanner(System.in);
		InetAddress inetaddr = InetAddress.getByName("127.0.0.1");
		DatagramSocket dsock = null;
		School sc = new School();
		dsock = new DatagramSocket();
		ByteArrayOutputStream bos;
		ObjectOutput out;
		ByteArrayInputStream bin;
		ObjectInput in;
		DatagramPacket receivePacket;
		DatagramPacket sendPacket;
//		byte[] line = bos.toByteArray();		
//		DatagramPacket sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
		
		boolean flag = true;
		int number = 0;
		int i = 0;
		byte[] line = new byte[1024];
		while(flag) {
			System.out.println("1. �л� ���");
			System.out.println("2. �˻�");
			System.out.println("---------------------------------------------------");
			System.out.print(": ");
			number = input.nextInt();
			bos = new ByteArrayOutputStream();
			out = new ObjectOutputStream(bos);
			out.writeObject(number);
			line = bos.toByteArray();		
			sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
			dsock.send(sendPacket);
			out.close();
			bos.close();
			switch(number) {
			case 1:
				System.out.print("�й� : ");
				sc.setNum(input.nextInt());
				System.out.print("�̸� : ");
				sc.setName(input.next());
				bos = new ByteArrayOutputStream();
				out = new ObjectOutputStream(bos);
				out.writeObject(sc);		//Ŭ���� ���·� ������ : ������Ʈ���·� ����
				line = bos.toByteArray();		
				sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
				dsock.send(sendPacket);
				out.close();
				bos.close();
//				dsock.send(sendPacket);
				break;
			case 2:
				System.out.print("�˻��� �й� : ");
				int num2 = input.nextInt();
				bos = new ByteArrayOutputStream();
				out = new ObjectOutputStream(bos);
				out.writeObject(num2);	
				line = bos.toByteArray();		
				sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
				dsock.send(sendPacket);
				System.out.println("-----------------------------");
				
				line = new byte[1024];
				receivePacket = new DatagramPacket(line, line.length);				
				dsock.receive(receivePacket);
				System.out.println("2222222222222222222222222222222");
				System.out.println(receivePacket);
				//line = new byte[1024];
				bin = new ByteArrayInputStream(line);
//				bin = new ByteArrayInputStream(receivePacket.getData());
				in = new ObjectInputStream(bin);
//				System.out.println("hi");
				sc = new School();
				sc = (School) in.readObject();
				System.out.println("�й� : " + sc.getNum());
				System.out.println("�̸� : " + sc.getName());
				break;
			}
		}
		
		System.out.println("UDPEchoClient�� �����մϴ�.");
		
		if(dsock != null) {
			dsock.close();
		}
	}	
}
	
	
	
	

