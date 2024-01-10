package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		/*
		 	Properties는 Map보다 축소된 기능의 객체라고 할 수 있다.
		 	
		 	Map은 key값과 value값에 자바 모든 형태의 객체를 사용할 수 있지만
		 	Properties는 key값과 value값에 String만 사용할 수 있다.
		 	
		 	Map은 put()메서드와 get()메서드를 이용하여 데이터를 입출력하지만
		 	Properties는 setProperty(), getProperty()메서드를 이용하여 데이터를 입출력한다.
		 	
		 	Properties는 데이터를 파일로 입출력할 수 있다. 파일에 저장할 수 있고 파일에 있는 걸 읽어올수도 있단 얘기다.
		 	
		 */
		
		Properties prop = new Properties();
		
		// 데이터 저장하기 ==> setProperty()메서드 이용, key도 value도  string임을 잊지말자.
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "30");
		prop.setProperty("age2", 30+"");
		prop.setProperty("age3", String.valueOf(30));
		prop.setProperty("tel", "010-5555-5555");
		
		
		//저장된 데이터 읽기 ==> getProperty(key값) 메서드 이용
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		
		System.out.println( "이름: " + name +" \n나이: " +  age +"세 \n전화번호: "+ tel);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
