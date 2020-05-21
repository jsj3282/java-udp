package receiver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver01 {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(12345);
		byte[] by = new byte[1024];
		
		DatagramPacket data = new DatagramPacket(by, by.length);
		
		System.out.println("������ ���� ��� ��...");
		
		ds.setSoTimeout(3000); 			//���Ź������ϸ� ����
		
		try {										//�� ���� �ڵ带 �����ϱ� ���� try~catch�� �����ش�
			ds.receive(data);
			String str = new String(data.getData());
			System.out.println("���� ������ : " + str);
		}catch(Exception e) {
			System.out.println("�����մϴ�!!!");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		ds.close();
	}
}
