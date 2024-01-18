package kr.or.ddit.singleton0117;

public class SingletonTest {
	public static void main(String[] args) {
		//이런식으로 쓰면 오류가 난다- 외부에서 생성자에 접근하지 못해 객체생성이 완료되지 못함.
//		MySingleton test1 = new MySingleton();
		
		//이렇게 생성해야 한다.
		//변수는 다르지만 두 객체의 참조값은 같다.
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 = > " + test2.toString());
		System.out.println("test3 = > " + test3.toString());
		
		System.out.println();
		System.out.println(test2==test3);
		System.out.println(test2.equals(test3));
		
		
		System.out.println();
		test2.displayTest();
	}
}
