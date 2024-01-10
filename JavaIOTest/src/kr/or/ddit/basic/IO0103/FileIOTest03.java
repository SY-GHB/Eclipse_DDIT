package kr.or.ddit.basic.IO0103;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class FileIOTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사용자로부터 출력할 단을 입력받아 구구단을 파일로 출력하는 프로그램 작성하기.
		// (출력할 파일명: "e:/d_other/gugudan.txt")
		
		FileOutputStream fout = null;
		try {
			
			//만약 똑같은 경로, 똑같은 이름의 파일이 있다면 파일이 삭제되고 새로 입력된다.
			File file = new File("e:/d_other/gugudan.txt");
			
			fout = new FileOutputStream(file);
			
			System.out.println("단을 입력하세요: ");
			int dan = sc.nextInt();
			
			for (int i =1; i <=9; i++) {
				String str = dan + " * " + i + " = " + (dan*i);
				byte[] bStrArr = str.getBytes("UTF-8");
				fout.write(bStrArr);
				fout.write('\n');
			}
			
			System.out.println("이(번의)작(업)완(료).");
			
			//만약에 close()이전에 오류가 나버리면 뒤의 작업 없이 catch로 가버리기때문에 close()없이 넘어가게 된다.
			//그러니 stream을 닫아주려면 여기가 아니라 finally에서 닫아줘야 한다.
//			fout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if(fout != null) { try { fout.close();} catch (IOException e2) { }
			}
		}
		
	}
}
