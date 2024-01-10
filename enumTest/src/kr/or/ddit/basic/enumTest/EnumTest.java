package kr.or.ddit.basic.enumTest;

/*
	enum(열거형) ==> 서로 관련잇는 상수들의 집합을 나타낸다.
			    ==> 클래스처럼 보이게 하는 상수
	- 작성방법
		1. 클래스처럼 독립된 java파일에 만들 수 있고, 
	 	2 .하나의 java파일에 클래스와 같이 만들 수 있고,
	 	3. 클래스의 내부에 내부 클래스처럼 만들 수 있다.
	 	
	- 열거형의 속성 및 메서드
	 1) 열거형변수.name()					==> 열거형 상수의 이름을 문자열로 반환한다.
	 2) 열거형변수.ordinal()				==> 열거형 상수가 정의된 순서값(index)을 반환한다.
	 3) 열거형이름.valueOf("열거형상수명")	==> 인자값에 지정한 '열거형상수명'과 일치하는 '열거형 상수'를 반환한다.
	 4) 열거형이름.상수명					==> 열거형이름.valueOf("열거형상수명") 와 같다.
	 5) 열거형이름.values					==> 열거형의 모든 상수들을 배열로 반환한다.
	 
	- 열거형 선언하기
	방법1) enum 열거형이름 {상수명1, 상수명2, ....}
	방법2) enum 열거형이름{
		상수명1(값들1, ....),
		상수명2(값들2, ....),
		...
		상수명n(값들n, ...);
		
		// '값들'이 저장될 변수 선언 ('값들' 갯수만큼 변수를 선언한다.)
		private 자료형이름 변수명1;
		private 자료형이름 변수명2;
		...
		
		// 열거형의 생성자를 작성한다.
		// ==> 열거형의 생성자는 '열거형상수'에 값들을 세팅하는 역할을 수행한다.
		// ==> 열거형 생성자의 접근제한자는 묵시적으로 'private'이다.
		
		// 생성자의 매개변수는 '값들'과 갯수가 같고, 자료형이 맞아야 한다.
		private 열거형이름(자료형이름 변수명1, ...){
			위에서 선언한 변수들을 초기화하는 작업을 주로 한다.
			...
		}
		
		// 위에서 선언한 변수들을 외부에서 사용할 수 있도록 getter메서드를 생성한다.
	}
	 
 */

public class EnumTest {
	public enum Color {RED, GREEN, BLUE}
	public enum Count {ONE, TWO, THREE}
	public enum Season {
		//1. 상수명(값들, ...) 형식의 선언
		봄("3월부터 5월까지", 13), //예를 들어 기간과 평균온도를 지정하고싶다,
		여름("6월부터 8월까지", 28),
		가을("9월부터 11월까지", 15),
		겨울("12월부터 2월까지", 1);
		
		//2. 값들이 저장될 변수 선언
		private String span;
		private int temp;
		
		//3. 생성자 선언
		Season(String months, int temp){	//묵시적으로 private
		//private Season(String months, int temp)와 같다
			span = months;
			this.temp = temp;
		}
		
		// 4. getter선언
		public String getSpan() {
			return span;
		}
		
		public int getTemp() {
			return temp;
		}
	}
	
	public static void main(String[] args) {
		
		//static을 붙여서 상수 선언을 했으므로 클래스이름.상수 로 불러내면 된다.
		System.out.println("Red: " + ConstTest.RED );
		System.out.println("Three: " + ConstTest.THREE );
		
		
		//같다..가 나오긴 하는데 논리적으로 뭔가 문제가 있다.
		// 오류중에 제일 찾기 어려운 것: 실행은 잘 됐는데 원하는 답이 아닌 게 나오는것. 차라리 에러메세지가 뜨는게 낫겟다...
		/*if(ConstTest.ONE == ConstTest.RED) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}*/
		
		Color mycol = Color.valueOf("GREEN"); // Color.GREEN;과 같다.
		Count mycnt = Count.ONE; // Count.valueOf("ONE"); 과 같다.
		
		System.out.println("mycol: " + mycol.name());
		System.out.println("mycnt: " + mycnt.name());
		System.out.println();
		
		System.out.println("mycol의 ordinal: " + mycol.ordinal());
		System.out.println("mycnt의 ordinal: " + mycnt.ordinal());
		
		
//		// 서로 다른 열거형에 있으므로 비교조차 불가능하다.
//		if(Count.TWO == Color.BLUE) {
//			
//		}
		
		// 같은 종류의 열거형끼리만 비교가 가능하다.
		if(mycol == Color.RED) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		System.out.println("─────────────────────────────────────────────────────────────────");
		
		Season ss = Season.valueOf("겨울");
		System.out.println("name: " + ss.name());
		System.out.println("ordinal: " + ss.ordinal());
		System.out.println("span: " + ss.getSpan());
		System.out.println("temp: " + ss.getTemp());
		System.out.println();
		
		
		//열거형이름.values()예제
		for(Season time : Season.values()) {
			System.out.println(time.name()+" == "+ time
					+ " ==> " + time.getSpan()+" : " + time.getTemp());
		}
		
		
		//열거형을 switch문에서 비교하기
		//case문에는 '상수명'만 기술해야 한다. Color.RED (X) RED(O)
		System.out.println("─────────────────────────────────────────────────────────────────");
		switch(mycol) {
		case RED : 
			System.out.println("RED입니다.");
			break;
		case GREEN : 
			System.out.println("GREEN입니다.");
			break;
		case BLUE : 
			System.out.println("BLUE입니다.");
			break;
		}
	}
}
