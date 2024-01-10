package kr.or.ddit.basic.Tcp0108;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	public static void main(String[] args) throws IOException {
		//TCP소켓 통신을 위해 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777);
		System.out.println("접속 대기중…");
		
		/*
		 * accept()메소드 ==> 클라이언트에서 연결 요청이 들어올대까지 계속 기다린다.
		 * 					연결 요청이 들어오면 새로운 socket객체를 생성하여 클라이언트의  socket과 연결한다.
		 */
		Socket socket = server.accept();
		
		//acceopt()메서드 이후의 소스는 연결이 완료되어야만 실행된다.
		System.out.println("클라이언트와 연결되었습니다.");
		System.out.println();
		
		System.out.println("상대방 컴퓨터의 정보");
		System.out.println("IP주소: " + socket.getInetAddress().getHostAddress());
		System.out.println("Port번호: " + socket.getPort());		
		System.out.println();
		
		System.out.println("현재 컴퓨터의 정보");
		System.out.println("IP주소: " + socket.getLocalAddress());
		System.out.println("Port번호: " + socket.getLocalPort());		
		System.out.println();
//		System.out.println("————————————————————————————————————————————————————————————————");
		
		//클라이언트에게 메세지 보내기 ==> socket을 이용하여 outputstream을 구성해서 보낸다.
		// 							socket의 getOutputStream()메서드 이용
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		dout.writeUTF("GOLDEN AGE WILL RETURN AGAIN");
		System.out.println("메세지를 보냈습니다.");
		
		
		//소켓과 스트림 닫아주기
		dout.close();
		socket.close();
		server.close();
	}
}
