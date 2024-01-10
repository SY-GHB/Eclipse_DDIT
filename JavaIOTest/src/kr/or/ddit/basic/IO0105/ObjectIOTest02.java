package kr.or.ddit.basic.IO0105;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOTest02 {
	public static void main(String[] args) {
		// 저장된 객체를 읽어와(입력) 그 내용을 화면에 출력하기
		try {
			
			//입력용 스트림객체 생성하기
			ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream("e:/d_other/memObj.data")));
			
			Object obj = null; //읽어온 객체가 저장될 변수
			System.out.println("객체 읽기 작업 시작");
			System.out.println("───────────────────────────────────────────────────────────────────────────────────");
			
			while((obj=oin.readObject())!=null) {
				// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름: " + mem.getName()+"\n" +"나이: " + mem.getAge() +"\n" + "주소 : " + mem.getAdr());
				System.out.println("───────────────────────────────────────────────────────────────────────────────────");
			}
			
			//exception이 발생해서 작업끝메세지가 나오지 않앗다. 무슨 예외였을까? EOFException- End Of File 예외이다.
			//readObject()메서드가 데이터를 끝까지 다 읽어오면 EOFException이 반드시 발생한다.
//			
			// 해결방법 2. 객체를 저장할 때(ObecjtIOTest01에서) 마지막 데이터에 null을 넣어주면 반복문이 더 작동하지 않을것이다.
			System.out.println("oout.writeObject(null) ==> 객체 읽기 작업 끝");
			oin.close(); ///스트림 닫기
			
		}catch (EOFException e) {
			//해결방법 1. eof예외의 예외처리를 해주자. 근데 읽어오는 게 끝이 아니라 읽어온 후에 뭔가를 더 하고자 한다면 이 방법은 부적절할것이다.
			System.out.println("EOFException ==> 객체 읽기 작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
