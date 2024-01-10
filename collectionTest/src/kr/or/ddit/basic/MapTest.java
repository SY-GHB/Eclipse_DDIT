package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		  - Map ==> key와 value를 한 쌍으로 관리하는 객체
		  - key값은 중복을 허용하지 않고 순서도 없다. ==> Set의 특징을 갖는다.
		  - value값은 중복을 허용한다. 
		 */
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료추가 ==> put(key, value)
		map.put("name", "홍길동");
		map.put("add", "대전");
		map.put("tel", "010-1234-5678");
		
		// 키값을 기준으로 출력하는데 키값에는 순서가 없어서 넣은 순서와 일치하지 않게 나온다.
		System.out.println("map => " + map);
		
		// 자료 수정 ==> 수정하는 방법은 따로 없고 데이터를 추가할 때 key값이 같으면 나중에 추가된 내용이 저장된다.
		map.put("add", "서울");
		// 출력해보면 나중에 추가한 값인 서울로 덧씌워졌음을 확인할 수 있다.
		System.out.println("map => " + map);
		
		// 자료 삭제 ==> remove(key값)  ==> key값이 같은 자료를 찾아서 삭제한다.
		// 반환값은 삭제된 자료의 value값이다. 삭제 실패 시 null을 반환한다.
		
//		String removeTel = map.remove("tel");
//		System.out.println("map => " + map);
//		System.out.println("삭제된 value값: " + removeTel);
		
		//자료 읽기 ==> get(key값), 반환값: 주어진 key값과 짝이 되는 value값, 주어진 key값이 없다면 null을 반환한다.
		
		//key값이 존재하는지 여부를 나타내는 메서드 => containsKey(key값)
		// ==> 해당 key값이 있으면 true, 없으면 false를 반환한다.
		
		System.out.println("tel 키값의 존재여부: " + map.containsKey("tel"));
		System.out.println("age 키값의 존재여부: " + map.containsKey("age"));
		
		//Map에 저장된 모든 데이터를 차례로 읽어와 사용하는 방법
		
		// 1.모든  key값을 읽어와 처리하기 ==> KeySet()메서드 이용하기
		// keySet() ==> Map의 모든 key값들을 읽어와 Set형으로 반환한다.
		
		Set<String> keySet = map.keySet();
		
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next(); //키값 구하기
			String value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		System.out.println("---------------------------");
		
		// 방법2 향상된 for문 이용하기
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("---------------------------");
		
		// 2. 모든 value값들만 읽어와 처리하기 ==> values()메서드 이용
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("---------------------------");
		
	}
}
