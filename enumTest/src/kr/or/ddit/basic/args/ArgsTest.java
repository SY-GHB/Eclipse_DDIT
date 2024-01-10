package kr.or.ddit.basic.args;

public class ArgsTest {
	// 만약 정수형데이터를 매개변수로받아 그 데이터들의 합계를 구하는 메소드를 만들고 싶을 때,
	// 그 정수형 데이터가 몇개가 들어올지 알 수 없다면...?
	// 전통적으로는 배열이나 컬렉션으로 받아왔엇다.
	
	// 1. 배열을 이용한 메서드
	public int sumArr(int[] data) {
		int sum = 0;
		for(int a : data) {
			sum += a;
		}
		return sum;
	}
	
	// 2.가변인자를 이용한 메서드
	/*
	 	가변인자 ==> 메서드가 사용하는 매개변수의 갯수가 실행될 때마다 다를 때 사용한다.
	 	
	 	- 가변인자는 메서드 안에서 배열로 실행된다.
	 	- 가변인자는 메서드안에서 하나만 사용할 수 있다.
	 	- 자료형... 변수 형태로 기술하며(int... data), 배열처럼 인식한다.
	 	- 가변인자와 일반 매개변수를 같이 사용할 경우에는 가변인자를 제일 뒤쪽에 배치해야 한다.
	 		: 가변인자가 가져갈 데이터를 구별하기 위함이다.
	 */
	public int sumArg(int... data) {
		int sum = 0;
		for(int a : data) {
			sum += a;
		}
		return sum;
	}
	
	// 가변인자와 일반 매개변수를 같이 사용할 경우에는 가변인자를 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name, int... data) {
		int sum = 0;
		for(int a : data) {
			sum += a;
		}
		return name + "씨의 점수는: " + sum + "입니다.";
	}
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		//arr와 arr2 초기화 방법의 차이
		// arr로 값을 넣어서 초기화해준 배열(배열 선언과 동시에 초기화)은 나중에 값을 변경하는 게 불가능하고
		// arr2처럼 배열 선언과 값을 넣어주는 건 나중에 값을 변경하는 게 가능하다.
		int[] arr = {72, 12, 54};
//		arr = {1,2,3}; 이건안된다.
		int [] arr2 = null;
		arr2 = new int[] {5,10,15}; //
		
		System.out.println(at.sumArr(arr));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
		System.out.println(at.sumArg(100,200,300));
		System.out.println();
		
		System.out.println(at.sumArg2("홍길동", 1,2,3,4,5,6,1,2,8,2,9,3,58,1));
		
	}
}
