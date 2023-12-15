package print;

public class printPretty {
	
	public void printStart() {
		System.out.println(""
				+ "      888       888 8888888888 888       .d8888b.   .d88888b.  888b     d888 8888888888 \r\n" + 
				"      888   o   888 888        888      d88P  Y88b d88P\" \"Y88b 8888b   d8888 888        \r\n" + 
				"      888  d8b  888 888        888      888    888 888     888 88888b.d88888 888        \r\n" + 
				"      888 d888b 888 8888888    888      888        888     888 888Y88888P888 8888888    \r\n" + 
				"      888d88888b888 888        888      888        888     888 888 Y888P 888 888        \r\n" + 
				"      88888P Y88888 888        888      888    888 888     888 888  Y8P  888 888        \r\n" + 
				"      8888P   Y8888 888        888      Y88b  d88P Y88b. .d88P 888   \"   888 888        \r\n" + 
				"      888P     Y888 8888888888 88888888  \"Y8888P\"   \"Y88888P\"  888       888 8888888888 \r\n" + 
				"                                                                                        \r\n" + 
				"                                                                                        \r\n" + 
				"                                                                                        \r\n" + 
				"      8888888b.  8888888b.  888       888  .d88888b.  8888888b.  888      8888888b.     \r\n" + 
				"      888  \"Y88b 888  \"Y88b 888   o   888 d88P\" \"Y88b 888   Y88b 888      888  \"Y88b    \r\n" + 
				"      888    888 888    888 888  d8b  888 888     888 888    888 888      888    888    \r\n" + 
				"      888    888 888    888 888 d888b 888 888     888 888   d88P 888      888    888    \r\n" + 
				"      888    888 888    888 888d88888b888 888     888 8888888P\"  888      888    888    \r\n" + 
				"      888    888 888    888 88888P Y88888 888     888 888 T88b   888      888    888    \r\n" + 
				"      888  .d88P 888  .d88P 8888P   Y8888 Y88b. .d88P 888  T88b  888      888  .d88P    \r\n" + 
				"      8888888P\"  8888888P\"  888P     Y888  \"Y88888P\"  888   T88b 88888888 8888888P\"   "
				+ "");
	}
	
	public void printVar() {
		System.out.println("──────────────────────────────────────────────────────────────────────────────");
	}
	
	public void printVar(String s) {
		System.out.println("─────────────────────────────────"+s+"─────────────────────────────────");
	}
	
	public void printLn(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
	
	public void printErr() {
		System.out.println("잘못 입력하였습니다.");
	}
	
	public void printBox() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   메인메뉴                                        ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printhomeMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   메인메뉴                                        ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃   1. 관리자 메뉴       2. 회원 메뉴    3. 티켓 구매하기       ┃");
		System.out.println("┃   4. 놀이기구 메뉴    5. 공지사항                                     ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdminMenu() {
		
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                 관리자 메뉴                                        ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃   1. 공지사항 관리     2. 티켓상품 관리                             ┃");
		System.out.println("┃   3. 놀이기구 관리     4. 회원관리      5. 매출관리            ┃");
		System.out.println("┃   6. 관리자 로그아웃                                                        ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printLoginCheckMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃      없는 계정이거나 비밀번호가 일치하지 않습니다.      ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃      1. 다시 로그인    2. 메인메뉴로 돌아가기                  ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printLoginCheckMenu2() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃      없는 계정이거나 비밀번호가 일치하지 않습니다.      ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃          1. 다시 로그인    2. 회원가입                          ┃");
		System.out.println("┃          2. 메인메뉴로 돌아가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printWelcomeMenu(String id) {
		System.out.println("\r\n" + 
				"                  "+id+"님 환영합니다.                   .        \r\n"+
				" _     _  _______  ___      _______  _______  __   __  _______ \r\n" + 
				"| | _ | ||       ||   |    |       ||       ||  |_|  ||       |\r\n" + 
				"| || || ||    ___||   |    |       ||   _   ||       ||    ___|\r\n" + 
				"|       ||   |___ |   |    |       ||  | |  ||       ||   |___ \r\n" + 
				"|       ||    ___||   |___ |      _||  |_|  ||       ||    ___|\r\n" + 
				"|   _   ||   |___ |       ||     |_ |       || ||_|| ||   |___ \r\n" + 
				"|__| |__||_______||_______||_______||_______||_|   |_||_______|\r\n" + 
				"");
	}
	
	
	public void printNoticeMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   공지메뉴                                        ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃          1. 관리자 메뉴로 돌아가기                                ┃");
		System.out.println("┃          2. 전체 공지 리스트 조회                                  ┃");
		System.out.println("┃          3. 공지 등록                                                   ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printNoticeListMenu(){
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 이전 페이지        2. 다음 페이지                            ┃");
		System.out.println("┃     3. 공지 상세조회     4. 관리자 메뉴로 돌아가기            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printNoticeDetailMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 전체 공지 리스트로 돌아가기                                   ┃");
		System.out.println("┃     2. 공지 수정하기     3. 공지 삭제하기                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printNoticeInsertMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 등록하기     2. 전체 공지 리스트 조회                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printNoticeUpdateMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 수정하기     2. 전체 공지 리스트 조회                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printNoticeDeleteMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 삭제하기     2. 전체 공지 리스트 조회                 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printTicket() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 관리자 메뉴로 돌아가기                                          ┃");
		System.out.println("┃     2. 전체 티켓 리스트 조회                                            ┃");
		System.out.println("┃     3. 티켓 등록                                                             ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printTicketListMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 관리자 메뉴로 돌아가기                                          ┃");
		System.out.println("┃     2. 티켓 수정하기           3.티켓 삭제하기                     ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printTicketListMenu2() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 티켓 이름 수정하기    2. 티켓 가격 수정하기            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printTicketInsertMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 등록하기                                                          ┃");
		System.out.println("┃     2. 전체 티켓  리스트로 돌아가기                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printTicketDeleteMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 삭제하기                                                          ┃");
		System.out.println("┃     2. 전체 티켓  리스트로 돌아가기                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                놀이기구 메뉴                                       ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃     1. 관리자 메뉴로 돌아가기                                          ┃");
		System.out.println("┃     2. 전체 놀이기구 조회     3. 놀이기구 추가                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttListMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 이전 페이지        2. 다음 페이지                            ┃");
		System.out.println("┃     3. 놀이기구 메뉴로 돌아가기                                       ┃");
		System.out.println("┃     4. 놀이기구 상세조회                                                 ┃");
		System.out.println("┃     5. 놀이기구 수정        6. 놀이기구 삭제                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttDetailMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 전체 놀이기구 리스트로 돌아가기                             ┃");
		System.out.println("┃     2. 놀이기구 수정하기      3. 놀이기구 삭제하기            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printAdAttInsertMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃           놀이기구 등록이 완료되었습니다.           ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃     1. 더 등록하기                                                          ┃");
		System.out.println("┃     2. 전체 놀이기구  리스트로 돌아가기                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttUpdateMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 놀이기구 이름 수정   2. 놀이기구 내용 수정             ┃");
		System.out.println("┃     3. 탑승인원 수정          4. 놀이기구 위치 수정             ┃");
		System.out.println("┃     5. 소요시간 수정          6. 운영여부 수정                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttUpdateMenu2() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 수정하기                                                          ┃");
		System.out.println("┃     2. 전체 놀이기구  리스트로 돌아가기                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdAttDeleteMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 삭제하기                                                          ┃");
		System.out.println("┃     2. 전체 놀이기구  리스트로 돌아가기                            ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdmemMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                회원관리 메뉴                                       ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃     1. 관리자 메뉴로 돌아가기                                          ┃");
		System.out.println("┃     2. 전체 회원 조회                                                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdmemListMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 이전 페이지        2. 다음 페이지                            ┃");
		System.out.println("┃     3. 회원관리 메뉴로 돌아가기                                       ┃");
		System.out.println("┃     4. 회원 상세조회                                                       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdmemDetailMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 전체 회원 리스트로 돌아가기                                   ┃");
		System.out.println("┃     2. 회원 수정하기          3. 회원 삭제하기                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdMemUpdateMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 비밀번호 수정          2. 이름 수정                          ┃");
		System.out.println("┃     3. 닉네임 수정                                                          ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printAdMemUpdateMenu2() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 수정하기                                                          ┃");
		System.out.println("┃     2. 전체 회원  리스트로 돌아가기                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdMemUDeleteMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 더 삭제하기                                                          ┃");
		System.out.println("┃     2. 전체 회원  리스트로 돌아가기                                  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdsellMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                매출관리 메뉴                                       ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃     1. 관리자 메뉴로 돌아가기                                          ┃");
		System.out.println("┃     2. 월별 매출 조회                                                      ┃");
		System.out.println("┃     2. 일별 매출 조회                                                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printAdsellMonthMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 매출관리 메뉴로 돌아가기                                       ┃");
		System.out.println("┃     2. 일별 매출 조회                                                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAdsellDateMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 매출관리 메뉴로 돌아가기                                       ┃");
		System.out.println("┃     2. 월별 매출 조회                                                      ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printAttListMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 이전 페이지        2. 다음 페이지                            ┃");
		System.out.println("┃     3. 놀이기구 상세 페이지                                             ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printAttDetailMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 전체 놀이기구 리스트로 돌아가기                             ┃");
		System.out.println("┃     2. 메인메뉴로 돌아가기                                              ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printTicketList() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 티켓 구매하기                                                       ┃");
		System.out.println("┃     2. 메인메뉴로 돌아가기                                              ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printMember() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                   회원 메뉴                                       ┃");
		System.out.println("┃                                             ┃");
		System.out.println("┃     1. 로그인              2. 회원 상세메뉴                          ┃");
		System.out.println("┃     3. 회원가입           4. 로그아웃                                 ┃");
		System.out.println("┃     5. 메인메뉴로 돌아가기                                              ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printMemDetail() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 회원 정보 수정        2. 회원 탈퇴                           ┃");
		System.out.println("┃     3. 티켓 구매내역         4. 회원 메뉴로 돌아가기           ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printMemUpdateMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   1. 비밀번호 수정하기       2. 이름 수정하기                     ┃");
		System.out.println("┃   3. 닉네임 수정하기         4. 회원상세메뉴로 돌아가기       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printbuyTicketListMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 회원상세메뉴로 돌아가기                                        ┃");
		System.out.println("┃     2. 회원메뉴로 돌아가기                                              ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	public void printMemNotiMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃     1. 이전 페이지        2. 다음 페이지                            ┃");
		System.out.println("┃     3. 공지 상세조회     4. 메인메뉴로 돌아가기                ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	public void printMemNotiDetailMenu() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃          1. 공지리스트로 돌아가기                                 ┃");
		System.out.println("┃          2. 메인메뉴로 돌아가기                                    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
	}
	
	
	
	public void printSignUpguide() {
		printLn(2);
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃   ID는 영문과 숫자를 혼용하여 10자 이내로 작성                   ┃");
		System.out.println("┃   PASS는 영문과 숫자를 혼용하여 8~20자 이내로 작성           ┃");
		System.out.println("┃   닉네임은 6글자 이내로 작성해주세요.                ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		printLn(2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

