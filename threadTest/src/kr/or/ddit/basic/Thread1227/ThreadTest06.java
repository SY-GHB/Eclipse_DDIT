package kr.or.ddit.basic.Thread1227;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new DataCountDown();
		
		th1.start();
		th2.start();
		//답을 입력하면 카운트다운을 멈추고싶다.
		// 그러면 DataInput에서 데이터가 들어왔는지를 확인하고 그걸 DataCountDown에서 가져다써야하는데,
		// 둘은 다른 객체니까, static데이터를 나눠쓰면되겠다.
	}
}

// 데이터를 입력하는 쓰레드 클래스
class DataInput extends Thread{
	//입력여부를 확인하기 위한 변수 선언 - 쓰레드에서 공통으로 사용할 변수(그래서,static)
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		inputCheck = true; // 입력이 완료되면 inputCheck가 true로 변경된다.
		
		System.out.println("입력한 값: " + str);
	}
}

// 카운트 다운을 진행하는 쓰레드 클래스
class DataCountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i>=1; i--) {
			//입력이 완료되었는지 여부를 검사하여 완료되었으면 카운트다운을 종료하도록 하기.
			if (DataInput.inputCheck) {
				System.out.println("시간에 맞추셨습니다. 프로그램을 종료합니다.");
				return; //run()메소드가 종료되면 쓰레드도 종료된다.
			}
			System.out.print(i+" ");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("\n 시간이 초과되었습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}
