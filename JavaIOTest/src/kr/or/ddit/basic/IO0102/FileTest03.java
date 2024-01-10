package kr.or.ddit.basic.IO0102;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {
	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		//보고싶은 디렉토리를 넣으면 된당
		test.dir(new File("e:/d_other"));

	}
	
	//디렉토리 정보를 매개변수로 받아서 해당 디렉토리에 있는 모든 파일 및 디렉토리 목록을 출력하는 메소드
	public void dir(File d) {
		if(!d.isDirectory()) {
			System.out.println("디렉토리(폴더)만 가능합니다.");
			return;
		}
		
		System.out.println("["+d.getAbsolutePath()+"] 디렉토리 내용");
		System.out.println();
		
		//해당 디렉토리 안에 있는 모든 파일 및 디렉토리 목록을 구한다.
		File[] fileArr = d.listFiles();
		// 2023-10-27 오후 12:13 과 같은 형식 구현하기
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// 가져온 목록 개수만큼 반복
		for(File f : fileArr) {
			String FileName = f.getName();
			String attr = ""; //파일 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; //파일 크기
			
			if(f.isDirectory()) {
				attr="<DIR>";
			}else {
				size = String.valueOf(f.length());
				//읽기가능한 파일이면 R, 쓰기가능이면 W, 숨겨진 파일이면 H가 출력되도록 했다.
				attr = f.canRead() ? "R":"";
				attr += f.canWrite() ? "W":"";
				attr += f.isHidden() ? "H":"";
			}
			
			//마지막 저장날짜 lastModified(숫자값으로 나옴, 1970년 1월 1일부터...의 데이터임)를 날짜형식으로 맞춰서 출력하도록햇다.
			String strDate = df.format(new Date(f.lastModified()));
			
			System.out.printf("%s %5s %12s %s\n", strDate, attr, size, FileName);
		}
	}
}
