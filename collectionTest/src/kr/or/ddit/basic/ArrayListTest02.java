package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에 이들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 단, 입력은 scanner객체를 이용한다.
 
 문제2) 5명의 별명의 입력받아 ArrayList에 저장하고 이들 중에서 길이가 가장 긴 별명을 출력하시오.
 단, 입력하는 각 별명의 길이는 모두 다르게 입력한다.(클래스를 새로 만들어서 해보시오~)
 
 문제3) 문제2에서 입력하는 별명의 길이가 같은 것이 있을 수 있을 때 결과를 출력하시오.
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 1; i < 6; i++) {
			System.out.println(i + "번째 이름을 입력해주세요.");
			String name = sc.nextLine();
			list.add(name);
		}
		
		//String[0]의 숫자는 상관이없는건지??
//		String[] list2 = list.toArray(new String[0]);
		
		
		for(String name2 : list) {
			if(name2.startsWith("김")) {
				System.out.println(name2);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
//			//선생님의 풀이, 반복문을 풀어서 썼고 .substring()이라는 메서드를 사용해서 풀었다.
//			if( list.get(i).substring(0,1).equals("김")) {
//				System.out.println(list.get(i));
//			}
//			
//			//선생님의 풀이2 charAt()메서드를 사용했다. 이 경우, 나오는 건 문자 하나므로 ==를 사용해 비교한다.
//			if( list.get(i).charAt(0) == '김') {
//				System.out.println(list.get(i));
//			}
			
			//선생님의 풀이3 indexOf는 앞에서부터 세는 거고 한국성씨는 앞에서부터 오니까 0번째인덱스에 김이 잇으면 출력하도록 해줘도 된다.
			if(list.get(i).indexOf("김") == 0 ) {
				System.out.println(list.get(i));
			}
		}

	}
}
