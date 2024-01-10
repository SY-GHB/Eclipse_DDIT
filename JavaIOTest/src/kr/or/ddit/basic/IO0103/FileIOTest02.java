package kr.or.ddit.basic.IO0103;

import java.io.File;
import java.io.FileOutputStream;

public class FileIOTest02 {
	public static void main(String[] args) {
		try {
			File file = new File("e:/d_other/out.txt");
			
			
			//파일 출력용 스트림객체 생성. File객체를 이용해도 되고 경로를 입력해도 된다.
			FileOutputStream fout = new FileOutputStream(file);
			
			
			for(char ch ='A'; ch<='Z'; ch++) {
				fout.write(ch); //ch변수의 데이터를 파일로 출력한다.
 			}
			
			fout.write('\n'); //줄바꿈 입력
			String str = "HELLO!!";
			//문자열을 코드값으로 바꿔서 입력하자.
//			만약 한글이라면 이런식으로 인코딩방법을 지정해줘야 한다. byte[] bStrArr = str.getBytes("UTF-8");
			byte[] bStrArr = str.getBytes();
			fout.write(bStrArr);
			
			fout.write('\n');
			String str2 = "하이-------------------얏!";
			byte[] bStrArr2 = str2.getBytes("UTF-8");
			fout.write(bStrArr2);
			
			System.out.println("작업 완료!!");
			fout.close(); //스트림 닫기
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
