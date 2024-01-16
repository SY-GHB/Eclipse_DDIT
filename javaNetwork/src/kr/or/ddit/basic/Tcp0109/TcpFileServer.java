package kr.or.ddit.basic.Tcp0109;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bin;
	private BufferedOutputStream bout;
	private DataInputStream din;
	
	
	public static void main(String[] args) {
		new TcpFileServer().serverStart();
	}

	private void serverStart() {
		//저장할 폴더 설정, 없으면 만들게 해 뒀다.
		File saveDir = new File("e:/d_other/upload");
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			socket = server.accept();
			
			System.out.println("파일 저장 시작");
			
			//클라이언트가 첫번재로 보내온 '파일명'을 받는다.
			
			din = new DataInputStream(socket.getInputStream());
			String fileName = din.readUTF();
			
			//저장할 폴더와 파일명을 지정하여 File객체 생성하기
			File saveFile = new File(saveDir, fileName);
			
			//수신용 스트림 객체 생성
			bin = new BufferedInputStream(socket.getInputStream());
			//파일 저장용 스트림 객체 생성
			bout = new BufferedOutputStream(
					new FileOutputStream(saveFile));
			
			//Socket으로 수신(읽은)한 데이터를 파일로 출력하기
			byte[] temp = new byte[1024];
			int length = 0;
			//length는 temp배열의 크기.
			//read(byte[])에서 매개변수로 사용된 배열의 크기만큼 한번에 읽어온다.
			//더이상 읽어올 게 없을 때까지 읽어온다.
			while((length=bin.read(temp))!=-1) {
				//int read(byte[] b): 매개변수에 들어있는 byte 배열(b)의 크기만큼 한번에 읽어들인다
				// write(byte[] b, int off, int len): b배열의 off번부터 len개를 출력하라.
				//temp에 length만큼의 양을 입력하고 출력하기를 반복하는 반복문이다.
				bout.write(temp,0,length);
			}
			
			//버퍼를 비워준다.
			bout.flush();
			
			System.out.println("파일 저장 완료");
			
		} catch (Exception e) {
			System.out.println("파일 수신작업 실,.,.패");
			e.printStackTrace();
		}finally {
			if(bin!=null) try {din.close();} catch (Exception e2) { }
			if(bin!=null) try {bin.close();} catch (Exception e2) { }
			if(bin!=null) try {bout.close();} catch (Exception e2) { }
			if(bin!=null) try {socket.close();} catch (Exception e2) { }
			if(bin!=null) try {server.close();} catch (Exception e2) { }
		}
	}
}
