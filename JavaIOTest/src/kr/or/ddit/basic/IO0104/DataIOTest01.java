package kr.or.ddit.basic.IO0104;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest01 {
	public static void main(String[] args) {
		try {
			FileOutputStream fout= new FileOutputStream("e:/d_other/test.dat");
			
			//자료형 단위로 출력할 보조스트림 (DataOUtputStream)객체 생성
			DataOutputStream dout = new DataOutputStream(fout);
			
			//그냥 write도 쓸수는잇긴함. 그러나 자료형단위로 출력하고싶으니...
			dout.writeInt(250);			//정수형 출력
			dout.writeFloat(3.14f);		//실수형 출력
			dout.writeBoolean(true);	//논리형 출력
			dout.writeUTF("ABCDEabcde");			//문자열 출력
			
			//문자열외엔 다 이상하게 저장되었다.
			System.out.println("출력 완료");
			dout.close(); //스트림 닫기
			
			String str = "";
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		//=------------------------------------------------------
		
		try {
			//출력한 자료 읽어오기
			FileInputStream fin = new FileInputStream("e:/d_other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			//DataInputStream 으로 자료를 읽어올 때는 DataInputStream으로 출력한 순서와 같은 순서로 읽어와야 한다.
			System.out.println("정수형: " + din.readInt());
			System.out.println("실수형: " + din.readFloat());
			System.out.println("논리형: " + din.readBoolean());
			System.out.println("문자열: " + din.readUTF());
			
			
			System.out.println("읽기작업 끝.");
			din.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
