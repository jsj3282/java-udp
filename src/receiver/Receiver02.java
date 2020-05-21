package receiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver02 {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(12340);
		byte[] by = new byte[1024];
		
		DatagramPacket data = new DatagramPacket(by, by.length);
		
		System.out.println("데이터 수신 대기 중...");
		
		ds.receive(data);
		String str = new String(data.getData());
		System.out.println("수신 데이터 : " + str);
		
		ds.close();
	}
}
