package kr.or.ddit.basic.IO0104;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FileIOTest07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//사용자로부터 출력할 단을 입력받아 구구단을 파일로 출력하는 프로그램 작성하기
		//출력할 파일명 'e:/d_other/gugudan2.txt'
		//문자기반 스트림을 이용해서 작성하시오.
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("e:/d_other/gugudan2.txt");
			
			System.out.println("단을 입력하세요: ");
			int dan = sc.nextInt();
			
			for (int i = 1; i <=9; i++) {
				String str = dan + " * " + i + " = " + (dan*i) +"\n";
				//바이트기반 스트림과 달리 바이트단위로 쪼갠 배열을 만들어줄 필요가 없다!
				fw.write(str);
			}
			
			System.out.println("작업완.");
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
