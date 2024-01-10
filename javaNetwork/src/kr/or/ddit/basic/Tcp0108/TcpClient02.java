package kr.or.ddit.basic.Tcp0108;

import java.net.Socket;

public class TcpClient02 {
	public static void main(String[] args) {
		try {
			
			//클라이언트실행하는사람이 서버가 될 사람의 ip주소를 여기다가 쓰면 됨
			Socket socket = new Socket("192.168.142.20", 7777);
			System.out.println("서버에 연결되었습니다.");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
