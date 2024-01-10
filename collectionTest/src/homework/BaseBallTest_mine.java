package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class BaseBallTest_mine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> setList = new HashSet<Integer>();
		// 이렇게 하면 일단 랜덤숫자 3개 뽑기는 성공했다.

		while (setList.size() < 3) {
			setList.add((int) (Math.random()*9 + 1));
		}
		

		// 그걸 리스트에 넣자. 여기까지 진행하면 컴퓨터가 문제는 다 낸 거다.
		ArrayList<Integer> testList = new ArrayList<Integer>(setList);
		
		//숫자를 섞어주자.
		Collections.shuffle(testList);
//		System.out.println("뽑은 숫자: " + testList);

		// ans는 사용자가 입력한 답의 리스트가 될 것이다.
		ArrayList ans = new ArrayList();
		int cnt = 0; // 게임을 플레이한 횟수

		while (true) {
			int s = 0; // 스트라이크의 갯수
			int b = 0; // 볼의 갯수
			for (int i = 0; i < 3; i++) {
				System.out.println((i + 1) + "번째 숫자를 입력해 주세요: ");
				int num = sc.nextInt();
				ans.add(num);
			}
			
			for (int i = 0; i < 3; i++) {
				if (ans.get(i) == testList.get(i)) {
					s++;
				} else if (testList.contains(ans.get(i))) {
					b++;
				}
			}

			cnt++;
			if (s == 3)
				break;
			System.out.println(s+"S, "+b+"B");
			System.out.println("정답이 아닙니다. 다시 답을 맞춰주세요.");
			ans.clear();
		}

		System.out.println("정답: " + testList);
		System.out.println(cnt + "번 만에 맞추셨습니다.");
	}
}