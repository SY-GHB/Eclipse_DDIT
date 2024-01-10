package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import print.Print;

public class ListSortTest02 extends Print{
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학돈", "010-6666-1111"));
		
		
		System.out.println("정렬 전...");
		for(Member mem: memList) {
			System.out.println(mem);
		}
		printVar();
		
		//Member타입에 정렬기준이 부여되지 않았을 때 내부정렬기준으로 정렬하라고 시키면 에러가 난다.
		// 그래서 Member타입에 정렬기준을 부여하고-CompareTo를 재정의하고- 왔다.
		Collections.sort(memList);
		
		System.out.println("이름순 정렬 후...");
		for(Member mem: memList) {
			System.out.println(mem);
		}
		printVar();
		
		// Member의 회원번호를 내림차순으로 정렬하는 외부 정렬 클래스를 작성하고
		// 이 외부 정렬 기준을 적용해서 출력하시오. (클래스명: SortNumDesc)
		
		Collections.sort(memList, new SortNumDesc());
		System.out.println("번호순 내림차순 정렬 후...");
		for(Member mem: memList) {
			System.out.println(mem);
		}
		printVar();
		
		
	}
}

//회원번호를 내림차순으로 정렬하는 외부 정렬 클래스
class SortNumDesc implements Comparator<Member>{
	@Override
	public int compare(Member num1, Member num2) {
//		if(num1.getNum()>num2.getNum()) {
//			return -1;
//		}else if(num1.getNum()<num2.getNum()){
//			return 1;
//		}else {
//			return 0;
//		}
//		
//		//Wrapper클래스를 이용해서도 할 수 있다.ㄴ
//		//Integer는 기본적으로 오름차순이니까 -1을 곱해서 내림차순으로 만들어줬다.
//		return new Integer(num1.getNum()).compareTo(num2.getNum()) *-1;
		
		//Wrapper 클래스 이용2
		//이렇게도 된다.
		return Integer.compare(num1.getNum(), num2.getNum()) * -1;
	}
}


// Member클래스 작성
// 회원 이름을 기준, 오름차순으로 정렬하자.
//Comparable 인터페이스를 구현하자. 멤버타입을 정렬할테니 제너릭엔 멤버를 써주면 된다.
class Member implements Comparable<Member>{
	private int num; // 회원번호
	private String name; //회원이름
	private String tel; //전화번호
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 회원 이름의 오름차순 정렬 기준 만들기
	// this와 지금 들어오는놈을 비교하기때문에 한놈만 들어오는것이다.
	// 오름차순 정렬을 만들 건데, String 내부기준이 이미 오름차순이므로 그대로 return해주면 된다.
	@Override
	public int compareTo(Member mem) {
		
//		if(this.getName().compareTo(mem.getName())>0) {
//			return 1;
//		}else if(this.getName().compareTo(mem.getName())<0) {
//			return -1;
//		}else {
//			return 0;
//		} 이걸 줄여서 ↓로 만들었다.
		
		return this.getName().compareTo(mem.getName());
	}

}