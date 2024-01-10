package kr.or.ddit.basic.IO0103;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		//파일에 잇는 데이터를 출력해보자.
		// FileInputStream을 이용한 파일 내용 읽기
		try {
			
			//읽어올 파일을 매개변수로 받는 FileInputStream 객체 생성
			//객체생성방법 1 ==> 읽어올 파일 정보를 문자열로 지정하기
//			FileInputStream fin = new FileInputStream("e:/d_other/test.txt");
			
			//객체생성방법 2 ==> 읽어올 파일 정보를 File 객체로 지정하기 
			File file = new File("e:/d_other/test.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c; //읽어온 데이터가 저장될 변수
			//바이트기반으로 1byte씩 읽어왔으니 2바이트 이상인 한글은 깨진다. 문자열기반 스트림에서 하는 방법을 배운다.
			while((c=fin.read())!=-1) {
				//읽어온 데이터를 화면(콘솔창)에 출력하기
				System.out.print((char)c);
			}
			
			/*
			 * 잠깐! 컴퓨터는 음수를 어떻게 표현할까?
			 * 숫자형 데이터의 첫 bit는 부호 bit이다. 여기가 0이면 양수, 1이면 음수다.
			 * 1byte에서 13을 2진수로 표현하면 00001101이다. 그럼 음수는 10001101인가? 아니다.
			 * 00000000이 0이면, 10000000은 -0이라는말인가?? -0이어딧어 이런경우는 못쓰는 수가 되는거다. 그래서 이런 표현방식을 쓰지 않고
			 * 
			 * 그래서 음수를 나타낼 때 선택한 방법이 2의 보수법이다. 그게뭔데??
			 * 1의 보수법 +1이다. 1의 보수법은 뭔데????????????????
			 * 0은 1로 바꾸고 1은 0으로 바꾸면 1의 보수법이다.
			 * 
			 * 그럼 다시 -13을 표시해보자.
			 * 일단 13을 00001101으로(2진수) 바꿨고, 1의 보수법을 써서 11110010으로 바꾸었다.
			 * 거기에 1을 더하면(2의 보수법을 쓰면) 11110011이 되고.... ...이게 -13이다. (????????????????????????)
			 * 
			 * 11110011을 보고 어떻게 -13인걸 아느냐? 여따 또 2의 보수법을 하면 안다.
			 * 첫 시작이 1이니까 음수일것이다. 
			 * 다시 1의 보수법을 쓰면 00001100이 되고  a),
			 * 거기에 1을 더하면(2의 보수법을 쓰면) 00001101이 되고,
			 * 이걸 다시 2진수로 바꾸면 13이되는데 a)에서 음수랬으니 -13이 되는거다.
			 */
			
			fin.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
		}
	}
}
