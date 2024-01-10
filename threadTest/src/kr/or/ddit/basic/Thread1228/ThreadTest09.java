package kr.or.ddit.basic.Thread1228;

//쓰레드의 상태를 출력하는 예제
public class ThreadTest09 {
	public static void main(String[] args) {
		TargetThread tt = new TargetThread();
		StatePrintThread th = new StatePrintThread(tt);
		
		th.start();
		
	}
}


//검사대상이 되는 쓰레드(TargetThread)의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	//생성자
	public StatePrintThread(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			//쓰레드의 상태값 구하기 ==> getState()메소드 이용
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값: " + state);
			
			//TargetThread의 상태가 NEW상태이면,(start()가 호출되기 전이면, 즉 실행안된상태면.)
			if(state == Thread.State.NEW) {
				//TargetThread를 실행시켜라.
				target.start();
			}
			
			//TargetThread의 상태가 종료(TERMINATED)상태면 반복문을 빠져나간다.
			if(state == Thread.State.TERMINATED) {
				//반복문을 빠져나가라.
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}


//쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i =1l; i<= 10_000_000_000l; i++) {
			// 쓰레드가 처리하는 영역
			long sum = i+1;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		for (long i =1l; i<= 10_000_000_000l; i++) {
			// 쓰레드가 처리하는 영역
			long sum = i+1;
		}
	}
}