package kr.or.ddit.basic.IO0104;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		try {
			//입출력의 성능 향상을 위해서 Buffered 스트림을 사용한다.
			
			//실제 파일에 출력하는, 입출력을 수행하는 스트림은 이거다.
			FileOutputStream fout = new FileOutputStream("e:/d_other/bufferTest.txt");
			
			//실제 입출력을 하는 fout을 매개변수로 갖고 버퍼의 사이즈는 5인 버퍼스트림 객체 생성
			//버퍼스트림의 기본 크기는 8Kb(8192byte)이다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(char c = '1'; c<='9'; c++) {
				//1,2,3,4가 버퍼에 들어올때까지는 아무일도 안하다가 5가 들어오는 순간 12345가 출력되고 버퍼가 비워진다.
				//6,7,8,9 까지 넣으면.. ... 5개가 안 차서 데이터가 안 나간다.
				bout.write(c);
			}
			
			//그래서 flush를 써줘야한다. flush()가 없으면 12345만 출력되어있다.
//			bout.flush();
			
			//스트림 닫기 ==> 보조스트림을 닫으면 그 기반이 되는 스트림도 같이 닫힌다.
			// close()에는 flush()기능까지 같이 있다! 상황에 적절하게 flush()를 쓰자.
			bout.close();
			
			System.out.println("작업 끝");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
