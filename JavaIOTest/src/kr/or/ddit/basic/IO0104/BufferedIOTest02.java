package kr.or.ddit.basic.IO0104;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {
	public static void main(String[] args) {
		// 문자기반스트림의 buffered스트림 사용 예제
		
		try {
			//자바의 상대경로는 프로젝트의 위치라 프로젝트까지는 생략했다.
			FileReader fr = new FileReader("E:./src/kr/or/ddit/basic/IO0102/FileTest01.java");
			
			BufferedReader br = new BufferedReader(fr);
			
			String temp = ""; //읽어온 데이터가 저장될 변수
			
			//문자기반 스트림에서 readLine()한 줄 단위로 데이터를 읽어온다.
			for (int i = 1; (temp = br.readLine())!=null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			
			br.close();
			System.out.println("작업.완.");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
