package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *  정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
 *  interface란? 인터페이스 안에는 메소드의 선언(signature)이 있다. 추상클래스만 모여있는 덩어리를 인터페이스라고 한다.
 *  
 *  Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스(내부 정렬 기준이라고 한다.)
 *  Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스이다.(외부 정렬 기준이라고 한다.)
 *  
 *  Comparable에서는 compareTo()메서드를 재정의해야 하고, 
 *  Comparator에서는 compare()메서드를 재정의해야 한다.
 *  
 *  String 클래스, Wrapper 클래스, Date클래스, File클래스에는 내부 정렬 기준이 이미 구현되어 있다.
 *  (내부정렬기준은 오름차순으로 처리되도록 구현되어 있다.)
 */


public class ListSortTest01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬 전: "+list);
		
		// 정렬 작업은 Collections.sort메서드를 이용하여 정렬한다.
		// Collections.sort()메서드는 기본적으로 내부 정렬 기준으로 정렬한다. (String의 기본 내부 정렬 기준에는 오름차순이 적용되어 있다.)
		Collections.sort(list);
		
		System.out.println("정렬 후: " +list);
		
		Collections.shuffle(list); // 자료 섞기
		System.out.println("섞은 후: " +list);
		
		//외부 정렬 기준을 적용해서 정렬하기
		// 형식) Collections.sort(리스트, 외부정렬기준객체)
		Collections.sort(list, new Desc());
		System.out.println("정렬 후: " +list);
		
	
	}
}


//외부 정렬 기준 클래스 만들기 ==> 정렬 방식을 결정해주는 class
// comparator 인터페이스를 구현해서 작성해야 한다.
class Desc implements Comparator<String>{

	
	//compare()메서드 반환값의 의미
	// 0: 두 값이 같다, 양수는 앞뒤의 순서를 바꾼다, 음수는 앞뒤의 순서를 바꾸지 않는다.
	
	// 예) 오름차순일 경우 ==> 앞의 값이 크면 양수, 같으면 0, 뒤의 값이 크면 음수를 반환하도록 구현하면 된다.
	// String은 이미 내부정렬기준이 오름차순으로 구현되어있다.
	@Override
	public int compare(String str1, String str2) {
//		//내림차순으로 구현하기
//			//1. 이미 앞의 수가 뒤보다 크다면, 내림차순이라면
//		if( str1.compareTo(str2) > 0) {
//			//음수를 반환해주면 된다.
//			return -1;
//			//2. 지금 오름차순으로 되어있다면
//		}else if(str1.compareTo(str2) < 0) {
//			//순서를 바꾸라고-양수를 반환하면 된다.
//			return 1;
//			// 같다면 0을 반환한다.
//		}else {
//			return 0;
//		}
		
		//이런식으로도 가능하다.
		return str1.compareTo(str2)*-1;
	}
}

