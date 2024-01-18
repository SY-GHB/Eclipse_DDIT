package kr.or.ddit.singleton0117;

/*
 	Singletone 패턴 ==> 객체가 1개만 만들어지게 하는 방법. 외부에서  new 연산자를 사용할 수 없게 한다.
 	
 	- 사용 이유
 	1) 메모리 낭비 방지
 	2) 데이터의 쉬운 공유
 	
 	- Singleton 클래스 제작의 필수구성요소
 	1) 자신 class의 참조값이 저장될 변수를 private static으로 선언한다.
 	2) 모든 생성자의 접근제한자를 private으로 설정한다.
 	3) 자신 class의 인스턴스를 생성하고 반환하는 메소드를 public static으로 작성한다.
 		ㄴ보통 getInstance()라는 이름의 메소드로 작성한다. 꼭이래야하는건아니지만...다들그런다고.
 	
 */

public class MySingleton {
	//1)private static으로 클래스의 참조값이 저장될 변수 선언
	private static MySingleton singletone;
	
	//2) 컴파일러를 통한 기본생성자가 만들어지게 두면 접근제한자가 public이 되므로
	// 생성자를 직접만들어주자.
	private MySingleton(){
		System.out.println("singleton클래스의 생성자입니다.");
	}
	
	//3번
	public static MySingleton getInstance() {
		// 1) 1번의 변수가 null이면 객체를 생성해서 1번의 변수에 저장한다.
		if(singletone==null) {
			singletone = new MySingleton();
		}
		// 2) 1번의 변수값을 반환한다.
		return singletone;
	}
	
	//기타(필수아님)
	//이 클래스가 처리할 내용을 작성한다.
	public void displayTest() {
		System.out.println("싱글톤 클래스의 메서드 호출입니다.");
		System.out.println("............................................");
	}
	
}
