package kr.or.ddit.basic.Thread1227;

public class ThreadTest03 {
	public static void main(String[] args) {
		//쓰레드가 수행되는 시간을 체크해보자.
		Thread th = new Thread(new MyRuner());
		
		//1970년 1월 1일 0시 0분 0초(표준시간)부터 경과한 시간을 밀리세컨드 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		th.start();
		try {
			th.join(); //현재 위치에서대상이 되는 쓰레드(변수 th)가 실행이 끝날때까지 기다린다.
		} catch (InterruptedException e) {
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간: " + (endTime - startTime));
	}
}


class MyRuner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for (long i = 1L; i <= 1_000_000_000L; i++) { //숫자안의 언더바는 없는취급, 그냥 1,000의 ,역할이다.
	 		sum += i;
		}
		
		System.out.println("합계: " + sum);
	}
}