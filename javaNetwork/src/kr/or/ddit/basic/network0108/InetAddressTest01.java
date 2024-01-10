package kr.or.ddit.basic.network0108;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest01 {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		//www.naver.com
		InetAddress ip = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name: " + ip.getHostName());
		//여기서 나온 ip번호를 주소창에 써넣으면 네이버로 이동가능하다.
		//네이버는 접속자 수가 굉장히 많은 사이트므로 여러개가 있어서 그 중 하나가 나온다.
		System.out.println("Host Address: " + ip.getHostAddress());
		System.out.println("toString : " + ip.toString());
		System.out.println("─────────────────────────────────────────────────────────────");
		
		//내 컴퓨터 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("Host Name: " + localIp.getHostName());
		System.out.println("Host Address: " + localIp.getHostAddress());
		System.out.println("toString : " + localIp.toString());
		System.out.println("─────────────────────────────────────────────────────────────");
		
		//IP주소가 여러개인 호스트의 IP정보 가져오기
		InetAddress[] ipArr = InetAddress.getAllByName("www.google.com");
		for (InetAddress temp : ipArr) {
			System.out.println(temp.toString());
		}
	}
}
