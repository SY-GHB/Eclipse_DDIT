package kr.or.ddit.basic;

import java.util.Stack;

import print.Print;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.history();
		
		b.goURL("1. 네이버");
		b.history();
		
		b.goURL("2. 야후");
		b.history();
		
		b.goURL("3. 구글");
		b.goURL("4. 다음");
		b.history();
		
		System.out.println("뒤로 가기 후");
		b.goBack();
		b.history();
		
//		System.out.println("앞으로 가기 후");
//		b.goForward();
//		b.history();
		
		System.out.println("새로운 사이트로 접속한 후");
		b.goURL("5. 네이트");
		b.history();
	}
}

// 웹브라우저에서 앞으로/뒤로 가기 기능 구현 클래스 작성(스택 이용)
class Browser extends Print{
	//url주소가 저장되어야 하니까 String.
	private Stack<String> back; 	// 이전 방문 내용이 저장될 스택
	private Stack<String> forward;  // 다음 방문 내용이 저장될 스택
	private String currentURL;  	// 현재 페이지
	
	
	//생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	//사이트를 방문하는 메서드 ==> 매개변수에는 방문할 URL이 저장된다.
	public void goURL(String url) {
		System.out.println(url + " 사이트에 접속합니다.");
		
		//현재페이지가 있으면(공백(초기값)도 null도 아니면) 현재 페이지를 back스택에 추가한다.
		if(currentURL != null && !"".equals(currentURL)) {
			back.push(currentURL);
		}
		
		currentURL = url; // 현재 페이지를 이동할 페이지로 변경한다.
		forward.clear(); // 뒤로 한번 간 상태에서 앞으로가기가 아닌 다른 방법으로 다른 사이트에 이동한다면 앞으로 가기 목록이 사라진다.
	}
	
	//뒤로가는 메서드  ==> 현재 페이지를 forward 스택에 추가하고, back스택에서 주소를 꺼내와 현재 페이지로 변경한다.
	public void goBack() {
		if(!back.isEmpty()) {
			forward.push(currentURL);
			// 스택에 쌓인 가장 마지막 주소를 현재페이지에 넣어준다.
			currentURL = back.pop();
		}
	}
	
	//앞으로 가는 메서드 ==> 현재페이지를 back스택에 추가하고, forward스택에서 주소를 꺼내와 현재 페이지로 변경한다.
	public void goForward() {
		if(!forward.isEmpty()) {
			back.push(currentURL);
		}
		currentURL = forward.pop();
	}
	
	//방문 기록을 확인(출력)하는 메서드
	public void history() {
		printBox("방문기록");
		
		System.out.println("back ==> " + back);
		System.out.println("현재 ==> " + currentURL);
		System.out.println("forward ==> " + forward);
	}
	
}