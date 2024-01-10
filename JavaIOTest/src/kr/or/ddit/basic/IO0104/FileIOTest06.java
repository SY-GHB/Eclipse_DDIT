package kr.or.ddit.basic.IO0104;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest06 {
	public static void main(String[] args) {
		try {
			
//			FileReader fr = new FileReader("e:/d_other/test_utf8.txt");
			
			//ansi 윈도우에서 기본적으로 사용하는 인코딩 방식
//			FileReader fr = new FileReader("e:/d_other/test_ansi.txt");
			
//			FileInputStream fin = new FileInputStream("e:/d_other/test_utf8.txt");
			FileInputStream fin = new FileInputStream("e:/d_other/test_ansi.txt");
			
			//InputStreamReader은 test5에서 했었다. 바이트기반스트림을 문자기반스트림으로 바꾸어주는 보조스트림
			
			//인코딩 방식을 지정해서 읽어오기
			/* 인코딩 방식 예시
			 - MS949  ==> 윈도우의 한글 기본 인코딩 방식(ANSI방식과 같다)
			 - UTF-8  ==> 유니코드 UTF-8 인코딩 방식
			 - US-ASCII  ==> 영문 전용 인코딩 방식 */
			
//			InputStreamReader isr = new InputStreamReader(fin, "utf-8"); //대소문자 무관
			//저장할 때 utf-8로 해서 읽어올 때 utf-8을 쓰면 한글이 안 깨지는데 ansi로 저장해서 utf-8로 불러오면 깨진다.
			//그럼 ansi로 저장한 한글은 어떻게 불러와야 할까? ms949로 불러오면 된다.
			//반대의 경우도 동일, 저장한 방식과 불러오는 방식이 맞아야 안 깨진다.
			InputStreamReader isr = new InputStreamReader(fin, "MS949"); 
			
			int c;
			while((c=isr.read())!=-1) {
				System.out.print((char)c);
			}
			
			isr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
