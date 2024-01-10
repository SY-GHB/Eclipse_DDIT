package kr.or.ddit.basic.IO0103;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest05 {
	public static void main(String[] args) {
		//사용자가 키보드로(=콘솔로) 입력한 내용을 그대로 파일로 저장하기
		
		try {
			/*
			 * console이란 뭘까? 표준 입출력장치를 콘솔이라고 부른다. 표준입력장치-키보드, 표준출력장치-모니터
			 * new Scanner(System.in); 에서 System.in이란 뭘까?
			 * 	in에 마우스를 가져다대면 뜨는 팝업을 보자. 여기에는 InputStream이 뜬다.
			 * 	==> System.in: 콘솔(표준입출력장치)의 입력장치와 연결된 스트림 객체 (바이트기반 스트림) 그런데 한글도 입력할 수 있다. 
			 */
//			System.out.println("아무거나 입력하세요.");
//			System.out.println((char)System.in.read());
			
			//입력용 바이트 기반 스트림을 문자 기반의 스트림으로 변환해야 한다.
			
			//InputStreamReader라는 클래스 사용 - 바이트기반스트림을 문자기반스트림으로 바꿔주는 클래스(보조클래스)
			// 매개변수로 바이트기반 스트림을 넣어주어야 생성할 수 있다.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			System.out.println("아무 내용이나 입력하세요.");
			// 콘솔에서 입력할 때 입력의 끝은 Ctrl+z키를 누르면 되도록 만들자.
			System.out.println("입력의 끝은 Ctrl + z 키입니다.");
			
			FileWriter fw = new FileWriter("e:/d_other/testchar.txt");
			
			
			int c;
			
			while((c=isr.read())!=-1) {
				fw.write(c); //  콘솔로 입력받은 데이터를 파일로 출력
			}
			
			isr.close();
			fw.close();
			
			 /* System.out.println();
			 * 	out에는 PrintStream이 뜬다.
			 * 		==> 
			 */
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
