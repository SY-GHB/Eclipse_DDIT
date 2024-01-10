package kr.or.ddit.basic;

import java.util.ArrayList;

import print.Print;

//벡터는 동기화기능을 지원하느라 시스템자원을 많이 잡아먹으므로, 리스트를 알아보자.
public class ArrayListTest01 extends Print{
	public static void main(String[] args) {
		//ArrayList의 기본적인 사용법은 Vector와 같다.
		
		ArrayList list1 = new ArrayList();
		
		//add()메서드를 이용해서 데이터를 추가한다. 데이터타입은 뭐든넣을수잇음.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		//toString 생략가능
		System.out.println("list1 => " + list1.toString());
		System.out.println("list1 => " + list1);
		System.out.println("size => " + list1.size());
		
		//get()메서드를 이용해서 데이터를 꺼낸다.
		System.out.println("1번째 자료 :" + list1.get(1));
		//데이터 끼워넣기 역시 같은 방법을 쓴다.
		list1.add(3,"zzz");
		System.out.println("3번째 자료 :" + list1.get(3));
		//데이터 변경하기 역시 .set()메소드. 변경전의 데이터가 반환값이므로 casting필요
		String sTemp = (String) list1.set(3, "yyy");
		System.out.println("list1 ==> " + list1);
		System.out.println("sTemp ==> " + sTemp);
		//삭제 역시 같은 방법
		list1.remove(1); //index로, 
		list1.remove("aaa"); //데이터를 찾아서 삭제
		System.out.println("삭제 후 list1 ==> " + list1);
		
		// 제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
//		list2.add(123); // 데이터타입 오류다.
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " ==> " + list2.get(i));
		}
		
		for(String str : list2) {
			System.out.println(str);
		}
		printVar();
		
		//contains(비교객체) ==> List에 저장된 데이터 중에서 '비교객체'가 있으면 true, 없으면 false를 반환
		System.out.println("DDD의 존재여부: " + list2.contains("DDD"));
		System.out.println("FFF의 존재여부: " + list2.contains("FFF"));
		
		
		//indexOf(비교객체), lastIndexOf(비교객체) ==> List에 '비교객체'가 있으면 저장된 index값을, 없으면 -1을 반환.
		//indexOf()는 앞에서 뒤로 검색, lastIndexOf()메서드는 뒤에서 앞으로 검색한다.
		// List에 '비교객체'가 복수일 경우 첫번째로 찾은 데이터의 index값 반환
		
		list2.add("DDD");
		System.out.println("앞에서부터 센 DDD의 index값: " + list2.indexOf("DDD"));
		System.out.println("뒤에서부터 센 DDD의 index값: " + list2.lastIndexOf("DDD"));
		System.out.println("ZZZ의 index값: " + list2.lastIndexOf("ZZZ"));
		
		// toArray() ==> List안의 데이터를 배열로 변환해서 반환한다.
		// 기본적으로 Object형 배열로 반환한다.
		// toArray(new 제네릭타입[0] ) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		
		Object[] strArr = list2.toArray();
//		String[] strArr2 = (String[])list2.toArray(); // 배열자체는 형변환할 수 없으므로 이 방법은 사용할 수 없다.
		
		System.out.println("List의 원소 개수: " + list2.size());
		System.out.println("배열의 원소 개수: " + strArr.length);
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i+"번째 자료: "+strArr[i]);
		}
		printVar();
		//0개짜리 1차원배열을 넣어줫다.
		String[] strArr2 = list2.toArray(new String[0]);
		for(String str : strArr2) {
			System.out.println(str);
		}
		
		//외의 메서드들은 필요해질 때 더 공부할것.
		
	}
}
