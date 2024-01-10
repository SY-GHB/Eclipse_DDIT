package kr.or.ddit.basic.Tcp0108;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * 현재 자신의 컴퓨터를 나타내는 방법
		 * 1) 원래의 IP주소: 예) 192.168.142.3
		 * 2) 지정된 IP주소: 127.0.0.1
		 * 3) 원래의 컴퓨터 이름: 예) DESKTOP-9V8A9MN
		 * 4) 지정된 컴퓨터 이름: localhost
		 */
		
		System.out.println("서버에 연결을 시도합니다.");
		// 서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다.
		// Socket객체는 생성이 완료되면 해당 IP주소와 Port번호로 연결신호를 보낸다.
		Socket socket = new Socket("localhost", 7777);
		
		// 이 부분은 서버와 연결된 이후에 처리할 내용을 기술하면 된다.
		System.out.println("서버에 연결되었습니다.");
		
		//서버에서 보낸 메세지를 받아서 출력하기
		
		//Socket을 이용하여 inputStream객체를 생성한다.(socket의 getInputStream()이용)
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//서버가 보낸 메세지를 받아서 출력, writeUTF()로 보냇으니 readUTF()로 받아주자
		System.out.println("서버에서 보낸 메세지입니다: " + din.readUTF());
		System.out.println();
		
		din.close();
		socket.close();
	}
}
