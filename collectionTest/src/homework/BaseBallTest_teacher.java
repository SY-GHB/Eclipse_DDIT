package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
		컴퓨터의 숫자는 난수를 이용하여 구한다. (1 ~ 9사이의 값으로 한다.)
		(스트라이크는 S, 볼은 B로 출력한다.)
	
	예)  컴퓨터의 난수 ==> 9 5 7
	
	실행예시)
	숫자입력 >> 3 5 6
	3 5 6 ==> 1S 0B
	숫자입력 >> 7 8 9
	7 8 9 ==> 0S 2B
	숫자입력 >> 9 7 5
	9 7 5 ==> 1S 2B
	숫자입력 >> 9 5 7
	9 5 7 ==> 3S 0B
	
	4번째 만에 맞췄습니다...
		
*/
public class BaseBallTest_teacher {
	private List<Integer> numList; // 난수를 저장할 List
	private List<Integer> userList; // 사용자가 입력한 값이 저장될 List
	Scanner scan = new Scanner(System.in);
	
	int strike, ball;    // 스트라이크와 볼의 개수가 저장될 변수 선언
	
	public static void main(String[] args) {
//		BaseBallTest t = new BaseBallTest();
//		t.startGame();
		new BaseBallTest_teacher().startGame();
	}
	
	// 게임이 시작되는 메서드
	public void startGame() {
		// 난수 만드는 메서드 호출
		createNum();
		
		// 확인용 출력
		//System.out.println("컴퓨터의 난수 >> " + numList);
		
		
		int cnt = 0; 		// 몇번만에 맞췄는지를 저장하는 변수
		
		do {
			cnt++;
			
			// 사용자 입력 메서드 호출
			inputNum();
			
			// 볼카운트하는 메서드 호출
			ballCount();
			
		}while(strike < 3);
		
		System.out.println();
		System.out.println("축하합니다...");
		System.out.println("당신은 " + cnt + "번째 만에 맞췄습니다...");
		
		
	}
	
	// 1 ~ 9 사이의 서로 다른 난수를 3개 만들어서 리스트에 저장하는 메서드
	private void createNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		// 난수 3개 만들기...
		while(numSet.size() < 3) {
			numSet.add( (int)(Math.random() * 9 + 1) );
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		// 만들어진 나수를 섞어 준다.
		Collections.shuffle(numList);
		
	}
	
	// 사용자로 부터 3개의 정수를 입력 받아 리스트에 저장하는 메서드
	// ==> 입력한 정수들은 서로 중복되지 않아야 한다.
	private void inputNum() {
		int n1, n2, n3;
		
		do {
			System.out.print("숫자입력 >> ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			
			if(n1==n2 || n1==n3 || n2==n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요..");
			}
			
		}while(n1==n2 || n1==n3 || n2==n3);
		
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	// 스트라이크와 볼을 판정하고 판정 결과를 출력하는 메서드
	private void ballCount() {
		strike = 0;
		ball = 0;			// 스트라이크와 볼의 개수 초기화
		
		for(int i=0; i<numList.size(); i++) {
			for(int j=0; j<userList.size(); j++) {
				if(numList.get(i) == userList.get(j)) { // 값이 같은지 검사
					if(i==j) {
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		System.out.println(userList.get(0) + " " + userList.get(1) + " " 
			 + userList.get(2) + " ==> " + strike + "S " + ball + "B");
	}
	

}
