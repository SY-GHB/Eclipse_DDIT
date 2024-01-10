package kr.or.ddit.basic.Thread1228;

// 데몬 쓰레드 연습  ==> 자동저장하기

public class ThreadTest08 {
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		//일반스레드(여기서는 메인메소드)가 모두 종료되면 데몬스레드는 자동으로 종료되기때문에 메인스레드 종료 후는 더이상 카운트다운이 되지 않는다.
		//데몬쓰레드로 설정하기 ==> 반드시 start()메소드가 실행되기 전에 설정해야             한다.
		autoSave.setDaemon(true); // autosave를 데몬쓰레드로만들어줫다.
		
		System.out.println("데몬 여부: "+autoSave.isDaemon());
		
		autoSave.start();
		
		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("메인스레드 종료");

	}
}


// 자동 저장하는 쓰레드 작성 ==> 3초에 한번씩 저장
class AutoSaveThread extends Thread{
	private void save() {
		System.out.println("작업 내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				save();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}