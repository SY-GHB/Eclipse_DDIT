package kr.or.ddit.basic.IO0103;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // 4개짜리 byte배열 생성
		
		//입력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		//출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			//읽어올 데이터가 있는지 확인
			while(bin.available()>0) {
//(A)				bin.read(temp);
//				bout.write(temp);
				
				
				//실제 읽어온 byte 수를 반환한다.
				int len = bin.read(temp);
				
				//temp배열의 데이터들 중에서 0번째부터 읽어온 갯수(len)만큼 출력하라.
				bout.write(temp, 0, len);
				
				System.out.println("temp => " + Arrays.toString(temp));
			}
			
			outSrc = bout.toByteArray();
			
			bin.close();
			bout.close();
			
			System.out.println("inSrc => " + Arrays.toString(inSrc));
			
			//출력용의 데이터가 조금 더 나온다. 왜??? temp를 4개씩 끊어넣다보면 세번째에서는 뒤의 빈 2칸에 두번째데이터가 남아있기때문이다.
			// 해당부분(A)을 주석처리하고 잘 나올 수 있도록 해보았다.
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}
}
