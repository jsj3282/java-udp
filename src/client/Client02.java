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
		System.out.print("이름 : ");
		st.setName(input.next());
		System.out.print("나이 : ");
		st.setAge(input.nextInt());
		System.out.print("주소 : ");
		st.setAddr(input.next());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject((Object)st);			//클래스 형태로 못보냄 : 오브젝트형태로 보냄
		byte[] line = bos.toByteArray();		//올라가 있는 객체형태(오브젝트 클래스)를 가져와 바이트로 변형 - 직렬화
		
		DatagramPacket sendPacket = new DatagramPacket(line, line.length, inetaddr, 12345);
		dsock.send(sendPacket);
		System.out.println("UDPEchoClient를 종료합니다.");
		
		if(dsock != null) {
			dsock.close();
		}
	}
}
