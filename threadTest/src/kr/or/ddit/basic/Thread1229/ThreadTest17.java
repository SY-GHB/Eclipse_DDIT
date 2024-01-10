package kr.or.ddit.basic.Thread1229;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


/*
 	vector(, Hashtable(맵의 옛날 버전) 등의 예전부터 존재하던 collectioin 객체)는 내부에 동기화처리가 되어있고
 	
 	새롭게 구성된 collection (list 등)들은 동기화처리가 안 되어 있다.
 	그래서, 동기화가 필요한 프로그램에서 이런 collection들을 사용하려면 동기화 처리를 한 후에 사용해야 한다.
 	
 	동기화처리를 해 주는 메서드
 	- Collections.synchronizedList() ==> List 동기화 처리
 	- Collections.synchronizedMap() ==> Map 동기화 처리
 	- Collections.synchronizedSet() ==> Set 동기화 처리
 	
 */

public class ThreadTest17 {
	public static Vector<Integer> vec = new Vector<Integer>();
	
	//동기화처리가 되지 않은 List
	public static ArrayList<Integer> list1 = new ArrayList<Integer>();
	
	//동기화처리를 한 List
	public static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>(list1));
	
	
	public static void main(String[] args) {
		//익명 구현체로 쓰레드구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <10000; i++) {
//					vec.add(i);
//					list1.add(i);
					list2.add(i);
				}
				
			}
		};
		
		Thread[] thArr = new Thread[] {
				new Thread(r), new Thread(r), new Thread(r),
				new Thread(r), new Thread(r)
		};
		
		for(Thread th : thArr) {
			th.start();
		}
		
		for(Thread th : thArr) {
			try {
				th.join();
			} catch (Exception e) {
			}
		}
		
		//vec는 50000개가 잘 나오지만 list는 5만개가 안나올뿐더러 오류도 엄청 난다.
//		System.out.println("vec의 개수: " + vec.size());
//		System.out.println("list1의 개수: " + list1.size());
		System.out.println("list2의 개수: " + list2.size());
	}
}
