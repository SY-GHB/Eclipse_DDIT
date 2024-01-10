package kr.or.ddit.basic.Thread1227;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위바위보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위바위보는 난수를 이용해서 구하고,
	사용자의 입력은 showInputDialog()메서드를 이용해서 입력받는다.
	
	입력시간은 5초로 제한하고,카운트다운을 한다.
	5초 안에 입력이 없으면 게임에 진 것으로 처리한다.
	5초 안에 입력이 완료되면 승패를 구해서 출력한다.
	
	결과 예시
	1) 5초안에 입력을 못 했을 때: 
	--결과--
	시간초과로당신이졋읍니다.
	
	2) 5초 안에 입력을 완료했을 때
	--결과--
	컴퓨터: 가위
	사용자: 바위
	결과: 당신이 이겻읍니다.
 */

public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new ComNum();
		Thread th2 = new DataInput2();
		Thread th3 = new countDown();
		
		th1.start();
		th2.start();
		th3.start();
	}
}


class ComNum extends Thread{
	
	public static String rsp = "";
	
	@Override
	public void run() {
		int a= (int)(Math.random() * 3 + 1);
		switch(a){
		case 1: rsp = "가위"; break;
		case 2: rsp = "바위"; break;
		case 3: rsp = "보"; break;
		}
	}
}


class DataInput2 extends Thread{
	
	public static boolean check = false;
	public static String str = "";
	@Override
	public void run() {
		str = JOptionPane.showInputDialog("가위, 바위, 보 중 하나를 입력하세요.");
		check = true;
	}
	
}

class countDown extends Thread{
	
	@Override
	public void run() {
		for (int i = 5; i >=1; i--) {
			if (DataInput2.check) {
				System.out.println("");
				System.out.println("──────────────────────────");
				System.out.println("컴퓨터: " + ComNum.rsp);
				System.out.println("사용자: " + DataInput2.str);
				System.out.print("결과: ");
				switch(ComNum.rsp) {
				case "가위":
					if(DataInput2.str.equals("가위")) {
						System.out.println("비겼습니다.");
					}else if(DataInput2.str.equals("보")) {
						System.out.println("졌습니다.");
					}else if(DataInput2.str.equals("바위")) {
						System.out.println("이겼습니다.");
					}else {
						System.out.println("잘못 입력하셨습니다.");
					}break;
				case "바위":
					if(DataInput2.str.equals("바위")) {
						System.out.println("비겼습니다.");
					}else if(DataInput2.str.equals("가위")) {
						System.out.println("졌습니다.");
					}else if(DataInput2.str.equals("보")) {
						System.out.println("이겼습니다.");
					}else {
						System.out.println("잘못 입력하셨습니다.");
					}break;
				case "보":
					if(DataInput2.str.equals("보")) {
						System.out.println("비겼습니다.");
					}else if(DataInput2.str.equals("바위")) {
						System.out.println("졌습니다.");
					}else if(DataInput2.str.equals("가위")) {
						System.out.println("이겼습니다.");
					}else {
						System.out.println("잘못 입력하셨습니다.");
					}break;
				}
				System.out.println("──────────────────────────");
				return;
			}
			System.out.print(i+" ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("");
		System.out.println("시간 초과로 패배하였습니다.");
	}
}