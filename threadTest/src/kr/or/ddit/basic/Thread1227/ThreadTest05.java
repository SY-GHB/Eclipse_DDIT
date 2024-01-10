package kr.or.ddit.basic.Thread1227;

import javax.swing.JOptionPane;

public class ThreadTest05 {
	public static void main(String[] args) {
		//사용자로부터 데이터입력받기: 입력받기 전까지는 다음코드가 진행되지 않는다.
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		//취소버튼이나 esc를 누르면 null값이 출력된다.
		System.out.println("입력한 값: " + str);
		
		
		for (int i = 10; i>=1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		//이렇게 동시에 처리되어야 할 내용이 있다면 얘네들을 쓰레드로 만들어 처리하면 된다.
	}
}
