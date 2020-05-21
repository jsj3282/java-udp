package receiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver01 {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(12345);
		byte[] by = new byte[1024];
		
		DatagramPacket data = new DatagramPacket(by, by.length);
		
		System.out.println("데이터 수신 대기 중...");
		
		ds.setSoTimeout(3000); 			//수신받지못하면 종료
		
		try {										//그 다음 코드를 진행하기 위해 try~catch로 묶어준다
			ds.receive(data);
			String str = new String(data.getData());
			System.out.println("수신 데이터 : " + str);
		}catch(Exception e) {
			System.out.println("종료합니다!!!");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		ds.close();
	}
}
