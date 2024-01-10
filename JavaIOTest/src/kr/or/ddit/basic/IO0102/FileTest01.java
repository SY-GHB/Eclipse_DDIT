package kr.or.ddit.basic.IO0102;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		//File 객체 만들기 연습, 먼저 e드라이브에 D_Other 폴더를 만들고 거기에 test.txt 파일을 만들어두엇다.
		
		// 1. new File(String 파일명 또는 경로)
		//  ==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 '\'(윈도우, 윈도우는 슬래시도사용가능)를 사용거나 '/'(유닉스)를 사용할 수 있다.
		
//		File file1 = new File("e:/D_Other/test.txt"); //구분문자를'/'로 사용하엿을 때
		File file1 = new File("e:\\D_Other\\test.txt"); //구분문자를'\'로 사용하엿을 때.. \\는 두번 써야 함.
		
		System.out.println("파일명: " + file1.getName());
		System.out.println("파일일까?: " + file1.isFile());
		System.out.println("디렉토리일까?: " + file1.isDirectory());
		
		System.out.println("────────────────────────────────────");
		
		File file2 = new File("e:/D_Other");
		System.out.println("파일명: " + file2.getName());
		System.out.println("파일일까?: " + file2.isFile());
		System.out.println("디렉토리일까?: " + file2.isDirectory());
		
		System.out.println("────────────────────────────────────");
		
		// 2. new File(File parent, String child)
		//  ==>  'parent' 디렉토리 안에 있는 'child'파일을 갖는다.
		File file3 = new File(file2, "test.txt");
		System.out.println("파일명: " + file3.getName());
		System.out.println("파일일까?: " + file3.isFile());
		System.out.println("디렉토리일까?: " + file3.isDirectory());
		
		System.out.println("────────────────────────────────────");
		
		// 3. new File(String parent, String child)
		// ==> 'parent'(부모, 상위) 디렉토리 안에 있는 'child'파일을 갖는다. 2와의 차이: 부모디렉토리를 문자열로 줌.
		
		File file4 = new File("e:/d_other", "test.txt");
		System.out.println("파일명: " + file4.getName());
		System.out.println("파일일까?: " + file4.isFile());
		System.out.println("디렉토리일까?: " + file4.isDirectory());
		
		System.out.println("────────────────────────────────────");
		
		/*
		 - 디렉토리(폴더) 만들기
		 	(make directory의 약자라고 보면 됨.) 
		 	1. mkdir() ==> File 객체의 전체 경로 중에서 마지막 위치의 디렉토리를 만든다.
		 			   ==> 반환값: 만들기 성공하면 true,  실패하면 false반환.
		 	2. mkdirs() ==> 중간 부분의 경로가 없으면 중간 부분의 경로도 같이 만들어 준다.		   
		 */
		
		File file5 = new File("e:/d_other/연습용");
		System.out.println(file5.getName()+"의 존재 여부: " + file5.exists());
		
		if(!file5.exists()) {
			if(file5.mkdir()){
				System.out.println(file5.getName() + " 만들기: 성공");
			}else {
				System.out.println(file5.getName() + " 만들기: 실패");
			}
		}
		
		System.out.println();
		//File 객체의 전체 경로 중에서 마지막 위치의 디렉토리를 만든다=src가 만들어지려면 java가, java가 만들어지려면 test가 있어야 한단 의미다.
		//즉, 어따만들지 모르니까 실패하는거다.
		File file6 = new File("e:/d_other/test/java/src");
		if(file6.mkdirs()){
			System.out.println(file6.getName() + " 만들기: 성공");
		}else {
			System.out.println(file6.getName() + " 만들기: 실패");
		}
		
		
	}
}
