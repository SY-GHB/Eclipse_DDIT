package kr.or.ddit.basic.IO0103;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest04 {
	public static void main(String[] args) {
		// 문자 기반의 스트림을 이용한 파일 내용 읽기
		try {
			//문자기반의 파일 입력용 스트림 객체 생성. (똑같이 파일객체를 넣어도되고 경로를 적어줘도 된다.)
			FileReader fr  = new FileReader("e:/d_other/test.txt");
			
			int c; //읽어온 데이터가 저장될 변수
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
			
			fr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
