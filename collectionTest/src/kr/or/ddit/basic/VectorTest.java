package kr.or.ddit.basic;

import java.util.Vector;

import print.Print;


public class VectorTest extends Print{
	public static void main(String[] args) {
		// Vector는 자바의 초기부터 지원했던 객체로, 동기화 처리가 되어 있다.

		// 객체 생성
		Vector v1 = new Vector();

		// 데이터를 추가하지 않고 크기를 재어 보면 크기가 0으로 나온다.
		System.out.println("처음 크기: " + v1.size());

		// 데이터 추가하기1: .add(추가할데이터)
		// => 반환값이 있다: 추가성공이면 true, 추가실패면 false
		// 숫자는 객체화를 시켜서 저장하는게 일반적이다.(래퍼 클래스를 통해서 객체화-이걸 boxing이라고 한다. 풀어주는 건 unboxing)
		// 예전에는 꼭 객체화를 했어야 했는데, 요즘은 그냥 숫자를 넣어도 들어간다! (벡터 안에서 자동으로 객체화해줌)

		v1.add("첫 데이터");
		v1.add(new Integer(111));
		v1.add(Integer.valueOf(200));
		v1.add(123); // boxing을 자동으로 해줌, auto boxing ==> auto unboxing
		v1.add('a');
		v1.add(true);

		boolean r = v1.add(3.14); // 데이터가 잘 들어가면 true, 안들어가면 false가 반환된다.
		System.out.println("반환값: " + r);

		System.out.println("현재 크기: " + v1.size());

		// 데이터 추가하기2: addElement(추가할 데이터) 옛날에 사용하던 방식의 .add이다. 잘 안 쓰지만, 이걸 빼면 옛날 프로그램들
		// 터질까봐 살려둔 기능.
		// ==> 이전 버전의 프로그램과의 호환성을 위해서 남아있는 메서드로, .add()와 같은 기능이다.

		v1.addElement("데이터 추가2");
		System.out.println("v1 => " + v1.toString());
		// toString은 생략가능하다.
		System.out.println("v1 => " + v1);

		// 데이터 추가하기3: add(index, 데이터)
		// => 'index'번째에 '데이터'를 끼워 넣는다. 반환값은 없음!
		v1.add(1, "끼워넣은 데이터");
		System.out.println("v1 => " + v1);

		// 데이터 꺼내오기♡: get(index)
		// ==> 'index'번재 데이터를 꺼내서 반환한다.

		System.out.println(v1.get(0));

		// 벡터는 안에 있는 데이터를 관리할 때 object 타입의 배열을 사용한다.
		// 그러니 꺼내올 때에도 object니까 casting을 해줘야 원하는 타입으로 쓸 수 있다.
		// 원래는 Integer로 꺼내와서 int로 바꿔야 하는데 요즘은 그냥 int해도 된다-auto unboxing
		int iTemp = (int) v1.get(2);
		System.out.println("2번째 데이터: " + iTemp);

		// 데이터 수정하기: set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 변경한다.
		String a = (String) v1.set(0, "zzzz");
		System.out.println("원래의 데이터: " + a + ", 바꾼 데이터: " + v1.get(0));

		// 데이터 삭제하기1: remove(index)
		// ==> 'index'번째 데이터를 삭제한다.
		// ==> 반환값: 삭제된 데이터
		String b = (String) v1.remove(0);
		System.out.println(v1);
		System.out.println("삭제된 데이터: " + b);

		// 데이터 삭제하기2: remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제할 수 있다.
		// ==> '삭제할 데이터'가 복수일 경우 가장 처음 검색된 자료가 삭제된다.
		// ==> 반환값: 삭제가 성공되면 true, 삭제에 실패하면 false이다.
		// ==> 반환값: '삭제할 데이터'가 정수형(보다 더 작은 형태도 포함)이거나 char형일 경우에는 반드시 객체로 변환해서 사용해야 한다.
		// 			실수형 데이터는 인덱스번호로 변환될수없으니까 그냥 써도 된다.
		
		v1.remove("데이터 추가2");
		System.out.println("데이터 추가2 삭제 후  v1 =>" + v1);

//		v1.remove(123); // 이 숫자를 삭제하고 싶은건데 숫자를 인덱스번호로 받아버려서 예외가 발생된다.
		// 그럴때에는 원하는 int형 숫자를 객체화시키면 된다.
//		v1.remove(new Integer(123)); //방법1 ==> 1.9버전부터는 사용을 권장하지 않는다.
		v1.remove(Integer.valueOf(123)); //방법2 ==> 되도록 이렇게 하자.

		//char형은 실제로 저장될 때 a의 코드값이 저장되기때문에 얘도 객체화시켜서 찾아야 한다.
		v1.remove(Character.valueOf('a'));
		System.out.println("123삭제 후  v1 =>" + v1);
		
		v1.remove(true);
		System.out.println("true 삭제 후  v1 =>" + v1);
		
		v1.remove(3.14);
		System.out.println("3.14 삭제 후  v1 =>" + v1);
		
		
		//전체 데이터 삭제하기: clear();
		v1.clear();
		System.out.println("clear 사용 후 v1 => "+v1);
		printVar();
		/*
		 * 제네릭 타입(Generic Type)
		 * 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때 외부에서 지정해주는 기법.
		 * 객체를 선언할 때 <>괄호 안에 그 객체의 내부에서 사용할 데이터의 타입을 지정해주는 것을 말한다.
		 * 
		 * 제네릭 타입으로 선언하면 지정된 데이터 타입 의외의, 다른 종류의 데이터를 저장할 수 없다.
		 * 이 때, 제네릭으로 선언될 수 있는 데이터 타입은 '클래스형'으로 지정해야 한다.
		 * 그래서 int는 Integer, boolean은 Boolean, char은 Character 등으로 대체해서 사용해야 한다.
		 * 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 대 별도의 형변환이 필요하지 않다.
		 */
		
		Vector<Integer> v2 = new Vector<Integer>(); // int형 자료만 저장할 수 있는 Vector
		Vector<String> v3 = new Vector<String>(); // String형 자료만 저장할 수 있는 Vector
		
		v3.add("안녕하세요.");
		
//		v3.add(100);//예외: 제네릭으로 선언되지 않은 타입의 데이터를 저장할 수 없다.
		
		//제네릭으로 선언된 데이터는 형변환을 안해도 꺼내올 수 있다.
		String sTemp2 = v3.get(0);
		
		//벡터안에 벡터(혹은 다른 컬렉션)를 담을수도 있다. 실제로 쓰는 경우는 잘 없지만...
		Vector<Vector> vv = new Vector<Vector>();
		System.out.println("v3의 size => " + v3.size());
		v3.clear();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("DDD");
		
		
		System.out.println("v3 => " +v3);
		System.out.println("v4 => " +v4);
		
		// 데이터 삭제하기 3: removeAll(Collection 객체);
		// ==> vector의 데이터 중에서 'Collection객체'가 가지고 있는 모든 데이터를 삭제한다.
		// ==> 반환값: 성공(true), 실패(flase)
		
		//v3에 있는 데이터 중 v4가 가지고 있는 데이터와 같은 데이터를 지워라. (v4는 안지워짐)
		v3.removeAll(v4);
		System.out.println("removeAll 이후의 v3 => " +v3);
		
		// 벡터의 데이터 전체를 순서대로 가져와 사용하려면 반복문을 이용한다. (주로 for문 사용)
		v3.clear();
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		for (int i = 0; i < v3.size(); i++) {
				System.out.print(v3.get(i)+" ");
		}
		printLn(1);
		
		//향상된 for문
		for(String str : v3) {
			System.out.print(str+" ");
		}
		
	}
}
