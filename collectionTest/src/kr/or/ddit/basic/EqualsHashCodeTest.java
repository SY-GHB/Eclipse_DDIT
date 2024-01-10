package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("이순신");
		p2.setNum(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		
		System.out.println(p1 == p2);  // ==는 p1의 주소값과 p2의 주소값을 비교하는 연산자다.
		System.out.println(p1 == p3);
		System.out.println();
		
		// 이건 왜 false일까? .. 번지값이 다르기 때문이다.
		// 우리가 데이터만 같아도 .equals가 true를 반환하도록 재정의한 후에는 true가 나왔다.
		System.out.println(p1.equals(p2)); 
		System.out.println(p1.equals(p3));
		System.out.println("------------------------------------");
		
		HashSet<Person> testSet = new HashSet<Person>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		// 2개가 나온다. 왜일까?
		// set은 주민등록번호라고도 할 수 있는 해시코드라는 것으로 값을 비교한다.
		// 해시코드는 참조값을 기준으로 만들어준다.
		// set에 넣을때는 해시코드를 먼저 비교한 뒤 해시코드가 같은 경우 equals로 비교하여 데이터를 삽입한다.
		System.out.println(testSet.size());
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());
		
	}
}

/*
  - equals()메서드 ==> 두 객체의 내용이 같은지를 비교하는 메서드
  - hashCode()메서드 ==> 두 객체가 같은 객체인지를 비교하는데 사용되는 메서드
  
  - HashMap, Hashtable, HashSet과 같이 Hash로 시작하는 컬렉션 객체들은
  	객체의 의미상 같은지 비교를 위해  hashCode()메서드를 호출하여 비교한다. (hashCode()와 equals()를 둘 다 사용한다.)
  	그래서 객체가 같은지 여부를 결정하려면 equals()메서드와 hashCode()메서드를 같이 재정의해야 한다.
  	
  - hashCode()메서드에서 사용되는 '해싱 알고리즘'은 서로 다른 객체들에 대해
  	같은 hashCode값을 만들어낼 수 있다.
 */



class Person{
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//쉬프트+알트+s로 자동으로 만들어준 메소드재정의
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + num;
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (num != other.num)
//			return false;
//		return true;
//	}
	
	
	
//	@Override
//	public boolean equals(Object obj) {
//		// p1.equals(p2)에서 p2는 매개변수로 받아주면 된다.
//		//그럼 p1은 어디서 오느냐? 자기 자신이므로 this다.
//		if(this == obj) return true;
//		
//		if(obj == null) return false;
//		
//		// .getClass() 클래스의 종류를 알아내는 메소드
//		// 같은 유형의 클래스인지 검사.
//		if(this.getClass() != obj.getClass()) return false;
//		
//		// 매개변수의 객체를 현재의 객체 유형으로 형변환한다.
//		Person that = (Person) obj;
//		
//		
//		// 멤버변수의 값들을 비교한다.
//		return this.num == that.num 
//				&& Objects.equals(this.name, that.name);
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(num, name);
//	}
	
}
