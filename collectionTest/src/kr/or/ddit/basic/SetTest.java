package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import print.Print;

public class SetTest extends Print{
	public static void main(String[] args) {
		/*
		 * - List와 Set의 차이점
		 * 1. List
		 *  - 데이터의 순서(index)가 있다.
		 *  - 중복되는 데이터를 저장할 수 있다.
		 *  
		 * 2. Set
		 *  - 데이터의 순서(index)가 없다.
		 *  - 중복되는 데이터를 저장할 수 없다.
		 *  
		 */
		
		HashSet hs1 = new HashSet();
		// Set에 데이터를 추가할 때도 add()메서드를 이용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set의 개수: " + hs1.size());
//		System.out.println("Set의 데이터" + hs1.toString());
		//전체출력에서는 toString생략해도 출력가능. 데이터를 추가한 순서와 상관 없이 출력된다.
		System.out.println("Set의 데이터: " + hs1);
		
		//Set에 중복되는 데이터를 추가하면 false를 반환하고, 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때: "+isAdd);
		System.out.println("Set의 데이터: " + hs1);
		
		isAdd = hs1.add("FF");
		System.out.println("중복될 때: "+isAdd);
		System.out.println("Set의 데이터: " + hs1);
		
		printVar();
		
		//Set의 데이터 수정하기 .. 사실 수정하기 어렵다. ==>수정명령이 따로 없어서 수정하려는 데이터를 삭제한 후 새로 추가해줘야 한다.
		//Set의 데이터 삭제하기 ==> remove(삭제할자료). 반환값이 있으며 삭제성공이면 true, 실패면 false를 반환한다.
		//				  ==> clear() 전체삭제
		
		boolean remove = hs1.remove("FF");
		System.out.println("삭제결과: "+remove);
		System.out.println("Set의 데이터: " + hs1);
		
//		hs1.clear();
//		System.out.println("삭제 후 Set의 데이터: " + hs1);
		
		/*
		 * Set의 데이터들은 순서index가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형의 객체로 변환해야 한다.
		 * 
		 * set형의 데이터들을 Iterator형의 객체로 변환하는 메서드 = iterator()
		 */
		
		printVar();
		
		Iterator it = hs1.iterator();
		
		/*
		 * Iterator의 hasNext()메서드
		 *   ==> Iterator의 포인터가 가리키는 곳의 다음번재 데이터가 있는지 검사, 데이터가 있으면 true 없으면 false를 반환한다.
		 *   
		 * Iterator의 next()메서드
		 *   ==> Iterator의 포인터를 다음번째 위치로 이동한 후 이동한 위치에 있는 데이터를 읽어서 반환한다.
		 */
		
		//Iterator를 이용한 출력
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		printVar();
		
		/*
		 * 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자.
		 * 번호는 1번부터 16번까지 있고, 추첨할 인원은 3명이다.
		 * 당첨자 번호를 출력하시오.
		 */
		
		// 시작값부터 종료값 사이의 정수형 난수 만드는 방법
		//(int)(Math.random() * (종료값-시작값+1) +시작값)
		
		int rnd = (int)(Math.random()*30 +55);
//		System.out.println(rnd);
		
		
		HashSet<Integer> testSet = new HashSet<Integer>();
		
		while(testSet.size() < 3) {
			testSet.add((int)(Math.random()*15 + 1));
		}
		
		System.out.println("당첨자 번호: " + testSet);
		
		// Set유형의 자료를 List형으로 변환하기
		//testSet이라는 이름의 Set이 가진 데이터를 가진 리스트가 만들어진다.
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		System.out.println("List 데이터 출력하기");
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(i +"번째 데이터: "+ testList.get(i));
		}
		
		//향상된 for문을 이용하여 처리하기
		System.out.println("향상된 for문으로 처리하기");
		for (int num : testSet) {
			System.out.print(num+" ");
		}
	}
}
