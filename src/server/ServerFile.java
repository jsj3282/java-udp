package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import client.School;

public class ServerFile {
	public static void main(String[] args) throws Exception{
		DatagramSocket dsock = new DatagramSocket(12345);
		System.out.println("수신 대기중...");
		byte[] buffer;
		DatagramPacket receivePacket;
//		dsock.receive(receivePacket);
		ByteArrayInputStream bis;
		ObjectInputStream in;
		
		boolean flag = true;
		int num;
		
		School sc;
		
		while(flag) {
			buffer = new byte[1024];
			receivePacket = new DatagramPacket(buffer, buffer.length);
			dsock.receive(receivePacket);
			bis = new ByteArrayInputStream(buffer);
			in = new ObjectInputStream(bis);
			num = (Integer) in.readObject();
			System.out.println("=====> "+num);
			switch(num) {
			case 1:
				buffer = new byte[1024];
				receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				bis = new ByteArrayInputStream(buffer);
				in = new ObjectInputStream(bis);
				sc = new School();
				sc = (School) in.readObject();
//				System.out.println(1);
				System.out.println("학번 : " + sc.getNum());
				System.out.println("이름 : " + sc.getName());
				
				int a = sc.getNum();
				File f = new File("C:\\12월취업반정선주\\"+a+".txt");
				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				
				oos.writeObject(sc);
				oos.close();
				System.out.println("-----------------------------------------------");
				
				break;
				//oos.close();
			case 2:
				buffer = new byte[1024];
				receivePacket = new DatagramPacket(buffer, buffer.length);
				dsock.receive(receivePacket);
				
				bis = new ByteArrayInputStream(buffer);
				in = new ObjectInputStream(bis);
				int b = (Integer) in.readObject();
				System.out.println(b);
				
				
				File f2 = new File("C:\\12월취업반정선주\\"+b+".txt");
				FileInputStream fis = new FileInputStream(f2);
				BufferedInputStream bis2 = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis2);
				sc = new School();
				sc = (School)ois.readObject();
				System.out.println(sc.getName());
				System.out.println(sc.getNum());
				buffer = new byte[1024];
				DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, receivePacket.getAddress(), receivePacket.getPort());
				dsock.send(sendPacket);
				ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(bos2);
				oos.writeObject(sc);		
				oos.close();
				
//				byte[] line = bos2.toByteArray();//클래스 형태로 못보냄 : 오브젝트형태로 보냄
//				DatagramPacket sendPacket = new DatagramPacket(line, line.length, receivePacket.getAddress(), receivePacket.getPort());
//				dsock.send(sendPacket);		
//				System.out.println("server");
				break;		
			}
		}
		System.out.println("UDPEchoServer를 종료한다.");
		if(dsock != null) {
			dsock.close();
		}
	}
}
