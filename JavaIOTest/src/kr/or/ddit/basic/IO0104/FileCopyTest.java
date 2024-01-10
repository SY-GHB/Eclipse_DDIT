package kr.or.ddit.basic.IO0104;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 'e:/d_other' 폴더에 잇는 '펭귄.jpg'파일을 
 * 'e:/d_other/연습용'폴더에 '복사본_펭귄.jpg' 파일로 복사하는 프로그램을 작성하시오. 
 * 원본파일을 읽어서 대상파일로 저장하면 된다.
 */

public class FileCopyTest {
	public static void main(String[] args) {
		
		//1. 원본파일을 읽어오자.
		File file = new File("e:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getPath()+"파일이 존재하지 않습니다.");
			System.out.println("복사 작업을 중지합니다.");
			return;
		}
		
		try {
			//원본 파일을 읽어올 스트림객체 생성-바이트기반 스트림
			FileInputStream fin = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			//대상 파일에 저장할 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("e:/d_other/연습용/복사본_펭귄.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 작업 시작");
			
			int data;
			
//			while((data=fin.read())!=-1) {
//				fout.write(data);
//			}
//			
//			fout.close();
//			fin.close();
			
			
			//버퍼기반스트림을 사용하게 되면 속도가 굉장히 빨라진다.(입출력의 효율이 높아진다.)
			while((data=bin.read())!=-1) {
				bout.write(data);
			}
			bout.flush();
			bout.close();
			bin.close();
			
			System.out.println("복사작업 완료.");
			
			//문자기반 스트림을 가져오면 끝부분이 조금 손실될수도 있다.
			// 문자로 표현할 수 없는 만큼의 데이터만 남았을 때 손실된다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
