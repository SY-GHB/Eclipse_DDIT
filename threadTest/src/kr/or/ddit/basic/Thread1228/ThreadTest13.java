package kr.or.ddit.basic.Thread1228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 말의 위치(int) 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간 중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수 순으로 출력한다.
*/
public class ThreadTest13 {
	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
			new Horse("01번말"),
			new Horse("02번말"),
			new Horse("03번말"),
			new Horse("04번말"),
			new Horse("05번말"),
			new Horse("06번말"),
			new Horse("07번말"),
			new Horse("08번말"),
			new Horse("09번말"),
			new Horse("10번말"),
		};
		
		
		Thread gs = new GameState(horseArr);
		
		for (Horse h : horseArr) {
			h.start();
		}
		gs.start();
		
		for (Horse h : horseArr) {
			try {
				h.join(); // 말들이 경주가 다 끝날 때까지 기다리라는 의미.
			} catch (InterruptedException e) {
				
			}
		}
		
		try {
			gs.join(); // 경기출력이 다 끝날때까지 기다리라는 의미.
		} catch (InterruptedException e) {
			
		}
		
		System.out.println();
		System.out.println("경주가 끝났습니다.");
		System.out.println();
		
		// 등수의 오름차순으로 정렬하기
		// 배열도 정렬기능이 있다: 배열의 정렬 ==> Arrays.sort()메서드
		Arrays.sort(horseArr);
		
		//경기결과 출력하기
		for (Horse h : horseArr) {
			System.out.println(h);
		}
 	}
}


/*
 * 말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 말의 위치(int) 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.
 */

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; //말의 현재 등수를 구하는 변수
	
	
	private String horseName;
	private int location;
	private int rank;
	
	// 1~50구간을 달리는 쓰레드
	@Override
	public void run() {
		for (int i = 1; i <=50; i++) {
			location = i; // 말의 현재 위치ㅣ
			
			try {
				//(int) Math.random()*500을 하면 영원히 0만 나온다... Math.random을 먼저 int로 만들고 곱하니까...
				// 이거 두 번 틀렸다. 다음엔!!!조심!!!하자.
				Thread.sleep((int)(Math.random() * 500));
				
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		//한마리의 말이 경주가 끝나면 등수를 구해서 저장하기.
		currentRank++;
		rank = currentRank;
	}
	
	
	
	
	//등수의 오름차순 정렬기준 만들기
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.rank);
	}
	
	public Horse(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "경주마" + horseName + "은 " + rank + "등 입니다.";
	}


}

/*
 경기 중 중간 중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...
 */

class GameState extends Thread{
	private Horse[] horseArr; //경주에 참가하는 말들이 저장될 배열

	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while(true) {
			if(Horse.currentRank==horseArr.length) { 
				//말이 다 들어오면 경주를 끝내라!
				//말이 10마리있으면 10등이 정해질 때 게임이 끝나고 20마리면 20등이 정해질 때 끝날테니까말이다.
				break;
			}
			
			//빈 줄 출력하기
			for (int i = 0; i <15; i++) {
				System.out.println();
			}
			
			//배열 개수만큼 반복
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+" : ");
				for (int j = 1; j <= 50; j++) {
					
					if(j==horseArr[i].getLocation()) {
						System.out.print(">");
					}else {
						System.out.print("─");
					}
				}
				System.out.println(""); // 줄바꿈. 말한마리가 자기트랙만가질수잇도록
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}
