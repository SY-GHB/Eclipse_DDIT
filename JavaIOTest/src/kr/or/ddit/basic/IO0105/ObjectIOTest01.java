package kr.or.ddit.basic.IO0105;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOTest01 {

	public static void main(String[] args) {
		//Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "강원");
		Member mem3 = new Member("홍길남", 40, "경기");
		Member mem4 = new Member("홍길북", 50, "인천");
		
		//객체를 파일에 저장하기
		try {
			FileOutputStream fout = new FileOutputStream("e:/d_other/memObj.data");
			
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			//쓰기 작업
			System.out.println("객체 저장작업 시작");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			
			//객체를 저장할 때 마지막에 null을 저장하여 EOFException이 발생하는 것을 방지할 수 있다.
			oout.writeObject(null);
			// 처음엔 Member class에 java.io.Serializable를 구현하지 않았어서 작업이 안 됐었다.
			// 구현해주면 된다. 깨져보이는것같아도 객체를 한글로 표현하려고햇으니 그런거고 잘 된거맞다.
			System.out.println("객체 저장작업 끝");
			
			
			oout.close(); //스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
