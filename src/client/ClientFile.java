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
			System.out.println("1. 학생 등록");
			System.out.println("2. 검색");
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
				System.out.print("학번 : ");
				sc.setNum(input.nextInt());
				System.out.print("이름 : ");
				sc.setName(input.next());
				bos = new ByteArrayOutputStream();
				out = new ObjectOutputStream(bos);
				out.writeObject(sc);		//클래스 형태로 못보냄 : 오브젝트형태로 보냄
				line = bos.toByteArray();		
				sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
				dsock.send(sendPacket);
				out.close();
				bos.close();
//				dsock.send(sendPacket);
				break;
			case 2:
				System.out.print("검색할 학번 : ");
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
				System.out.println("학번 : " + sc.getNum());
				System.out.println("이름 : " + sc.getName());
				break;
			}
		}
		
		System.out.println("UDPEchoClient를 종료합니다.");
		
		if(dsock != null) {
			dsock.close();
		}
	}	
}
	
	
	
	

