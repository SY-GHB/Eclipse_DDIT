package kr.or.ddit.basic.Thread1227;

public class ThreadTest01 {
	public static void main(String[] args) {
		// * 문자 200개 출력, $문자 200개 출력하는 프로그램을 작성하고 싶어요.
		// 싱글쓰레드
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		for (int i = 1; i <= 200; i++) {
			System.out.print("$");
		}
	}
}
