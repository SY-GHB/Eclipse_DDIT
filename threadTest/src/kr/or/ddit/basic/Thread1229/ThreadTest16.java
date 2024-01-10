package kr.or.ddit.basic.Thread1229;

//은행의 입출금을 쓰레드로 처리하는 예제(동기화 처리 예제)

public class ThreadTest16 {
	private int balance; //잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금을 처리하는 메서드
	public void deposit(int money) {
		balance += money;
	}
	
	//출금을 처리하는 메서드(출금 성공: true, 출금실패면 false)
//	public synchronized boolean withdraw(int money) { // 출금 여부 검사
	public boolean withdraw(int money) { // 출금 여부 검사
		
		synchronized (this) {
			for (int i = 1; i < 100000000; i++) {
				//실제 하는 일은 없지만 오류발생가능성을 늘리려고 의미없는 작업을 넣어줬다.
				// 시간 지연용 반복문
				i += i;
			}
			
			if(balance >= money) {
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
				return true;
			}else {
				return false;
			}
		}
	}
	
	
	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();
		account.setBalance(10000); // 잔액을 만원으로 설정했다.
		
		// 익명 구현체로 쓰레드구현
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000); //6000원 출금하기
				System.out.println("쓰레드에서 result = " + result + ", balance = " + account.getBalance());
			}
		};
		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
		
	}
}
