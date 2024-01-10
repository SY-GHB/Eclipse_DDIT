package kr.or.ddit.basic.genericTest;
/*
	제네릭이 적용되는 클래스를 한 번 만들어보자!
	목적: 데이터를 저장하기 위한 목적이 크겠죠~
	제네릭이 나오기 전에는 아무종류의 데이터를 받을 때 Object로 받았었다.
	저장은 쉽지만 꺼낼 땐 형변환을 해주는 불편함이 있었지... 그걸 보완한 게 generic

	제네릭 클래스를 만드는 방법: 1. 변수, 2. 메소드의 반환값, 3. 매개변수 선언자리에 사용할 수 있다.
	형식)
	class 클래스명<제네릭 타입글자>{
		제네릭타입글자 변수명;	// 변수 선언에 제네릭을 사용할 경우
		...
		
		제네릭타입글자 메서드명 (매개변수들...){	//메서드의 반환값에 제네릭을 사용할 경우
			...
			return 값;
		}
		
		//매개변수를 자정할 때 제네릭을 사용하는 경우
		반환값자료형 메서드명(제네릭타입글자 변수명, ...){
			...
		}
	}
	
	-- 제네릭타입글자(영어대문자 1글자를 사용.)
	T ==> Type
	K ==> Key
	V ==> Value
	E ==> Element 을 자주 썼쥬 
	꼭 이것들만 쓰라는 건 아닌데 직관적이고 좋잖아유
 */

//제네릭을 사용하지 않을 경우
class Nongeneric{
	private Object value;

	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}

// 이제 제네릭을 이용한 메소드를 만들어봅시다
class MyGeneric<T>{
	private T value;
	
	public void setValue(T value) {	//매개변수에 제네릭을 지정해서 사용하는 경우
		this.value = value;
	}
	
	public T getValue() {	// 반환값에 사용
		return value;
	}
}


public class GenericTest {
	
	public static void main(String[] args) {
		Nongeneric non1 = new Nongeneric();
		non1.setValue("안녕하세요.");
		
		Nongeneric non2 = new Nongeneric();
		non2.setValue(123);
		
		
		String rtn1 = (String) non1.getValue();
		System.out.println("문자열 반환값: " + rtn1);
		
		int rtn2 = (int) non2.getValue();
		System.out.println("정수 반환값: " + rtn2);
		
//		int rtn3 = (int) non1.getValue();
		// 문법적으로 object는 형변환을 하면 어디에든 넣을 수 있지만, 컴파일러 입장(코딩하는 시점)에서는 오류가 아니지만
		// 실제 실행할때는 문자열을 숫자로 바꿀 수 없으니 오류가 난다.
//		System.out.println("반환값: " + rtn3);
		System.out.println("──────────────────────────────────────────────────────────");
		System.out.println();
		
		MyGeneric<String> my1 = new MyGeneric<String>();
		my1.setValue("아름다운우리강산");
		
		MyGeneric<Integer> my2 = new MyGeneric<Integer>();
		my2.setValue(50000000);
		
		//데이터를 꺼내올 때 형변환 없이 가져올 수 있다. 거기서 가져오는 건 형태가 정해져 있으니까!!
		String myRtn1 = my1.getValue();
		int myRtn2 = my2.getValue();
		
		System.out.println(myRtn1+"\t"+myRtn2);
		
	}

}
