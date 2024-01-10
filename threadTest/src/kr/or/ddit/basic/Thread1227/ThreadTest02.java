package kr.or.ddit.basic.Thread1227;

public class ThreadTest02 {
	public static void main(String[] args) {
		// * 문자 200개 출력, $문자 200개 출력하는 프로그램을 작성하고 싶어요.
		// 멀티쓰레드 프로그램으로~!
		
		//방법1
		//	==> Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한다.
				//이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
//		th1.run();
		
		// 방법2)
		// ==> Runnable 인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다.
//		 	   이 인스턴스를 Thread클래스의 인스턴스로 생성할 때 생성자의 인자값으로 넣어서 생성한다.
//			   이 때 생성된 Thread 클래스의 인스턴스의 start()메서드를 호출해서 실행한다.
		MyRunner1 r = new MyRunner1();
		Thread th2 = new Thread(r);
		th2.start();
		//실행해보면 *과 &가 번갈아가면서 나온다.
		
//		th2.run();// run으로 실행하면 *이 다 찍히고 나서야 $이 출력된다. 싱글스레드와 다를 바 없는것이다.
		
		//start()메소드: 쓰레드가 작동될 환경을 먼저 만들고, 그 환경이 만들어지면 run()을 호출해준다.
		
		// 방법 2-1)
		//		==> Runnalbe 인터페이스의 익명구현체를 이용하는 방법
//		Runnable r2 = new Runnable();	인터페이스는 실체가 없으므로(메소드의 선언부만 있음.) 객체를 구현할 수 없다.
		//인터페이스의 익명구현체 만들기, 인터페이스의 실행부를 만들고 재정의를 해주면 된다. 끝에 세미콜론붙이기
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				// '@'문자 200개 출력
				for (int i = 0; i < 200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		Thread t3 = new Thread(r2);
		t3.start();
		
		System.out.println("main메소드 끝.");
		
	}
}



//방법1) Thread 클래스를 상속한 class 작성
class MyThread1 extends Thread {
	
	//run이라는 메소드를 반드시!재정의해야 한다.
	@Override
	public void run() {
		//이 run()메소드에는 이 쓰레드가 처리할 내용을 작성하면 된다.
		// 예시) * 200개 출력
		for (int i = 0; i <200; i++) {
			System.out.print("*");
			try {
//				Thread.sleep(시간); ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//'시간'은 밀리세컨드 단위를 사용한다. 1초는 1000ms
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
} //MyThread클래스 끝


//방법2) Runnable 인터페이스를 구현한 class 작성
class MyRunner1 implements Runnable{
	@Override
	public void run() {
		// 이 run()메서드에는 이 쓰레드가 처리할 내용을 작성하면 된다.
		// 예시) &문자 200개 출력
		for (int i = 0; i < 200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		
	}
}