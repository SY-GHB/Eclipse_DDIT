package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import service.MemberService;
import service.ProdService;
import util.Print;
import util.ScanUtil;
import util.View;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	//만든 멤버서비스를 불러왔다.(싱글톤이라 겟인스턴스가 있어야 쓸수잇음)
	MemberService memService = MemberService.getInstance();
	ProdService prodService = ProdService.getInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}
	
	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case ADMIN:
				view = home();
				break;
			case MEMBER:
				view = member();
				break;
			case PROD_LIST:
				view = prodList();
				break;
			case PROD_DETAIL:
				view = prodDetail();
				break;
			case PROD_SALE:
				view = prodSale();
				break;
			case LOGIN:
				view = login();
				break;
			default:
				break;
			}
		}
	}

	private View login() {
		
		System.out.println("--------------로그인---------------");
		String id = ScanUtil.nextLine("ID: ");
		String pass = ScanUtil.nextLine("PASS: ");
		
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
		
		
		boolean login = memService.login(list);
		if(!login) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 홈");
			// 이걸 if문 밖에 써버리면 뭘 선택해도 메소드가 끝난다. 그래서 id pass를  세션스토리지에 담는 데 실패한거다.
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			switch (sel) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.HOME;
			default:
				return View.LOGIN;
			}
		}
		
		Map<String, Object> member = (Map<String, Object>) sessionStorage.get("login");
		System.out.println(member.get("NAME")+"님 환영합니다.\r\n");
		
		return View.MEMBER;
	}

	private View prodSale() {
		System.out.println("---------------상품 구매---------------");
		/*
		 * 진짜 구매할건지 또물어보고싶으면 if문을 추가하면 된다.
		 */
		Map<String, Object> prod = (Map<String, Object>) sessionStorage.get("prod");
		int no = (int) prod.get("NO");
		
		int count = ScanUtil.nextInt("구매하실 수량: ");
		int price = (int) prod.get("PRICE");
		
		System.out.println("총 구매 가격은: " + price*count);
		
		String yn = ScanUtil.nextLine("구매하시겠습니까?(Y/N)");
		
		if(yn.equalsIgnoreCase("y")) {
			
			List<Object> param = new ArrayList();
			param.add(count);
			param.add(no);
			param.add(no);
			
			prodService.prodSale(param);
			
		}
		
		return View.PROD_LIST;
	}

	private View prodDetail() {
		System.out.println("---------------상품 상세조회---------------");
		
		/*
		 * 상품 상세내용 출력
		 */
		Map<String, Object> prod = (Map<String, Object>) sessionStorage.get("prod");
//		System.out.println(prod);
		
		
		int no = (int) prod.get("NO");
		String name = (String) prod.get("NAME");
		String content = (String) prod.get("CONTENT");
		int price = (int) prod.get("PRICE");
		int count = (int) prod.get("COUNT");
		String type = (String) prod.get("TYPE");
		
		System.out.println(no+"\t"+name+"\t"+content+"\t"+price+"\t"+count+"\t"+type);

		
		System.out.println("1. 상품 리스트로 돌아가기");
		System.out.println("2. 상품 구매");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			return View.PROD_SALE;
		default:
			return View.PROD_DETAIL;
		}
		
	}

	private View prodList() {
		System.out.println("--------------------상품 리스트---------------------");
		
		
		System.out.println("번호\t이름\t내용\t\t가격\t수량\t종류");
		
		List<Map<String, Object>> list = prodService.prodList();
		for(Map<String, Object> map : list) {
			int no = (int) map.get("NO");
			String name = (String) map.get("NAME");
			String content = (String) map.get("CONTENT");
			int price = (int) map.get("PRICE");
			int count = (int) map.get("COUNT");
			String type = (String) map.get("TYPE");
			
			System.out.println(no+"\t"+name+"\t"+content+"\t"+price+"\t"+count+"\t"+type);
		}
		
		
		
		System.out.println("1. 상품 선택");
		System.out.println("2. 홈\r\n");
		
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			System.out.println("1. 상품 종류 검색");
			System.out.println("2. 상품 이름 검색");
			System.out.println("3. 상품 번호 검색");
			sel = ScanUtil.nextInt("메뉴 선택 : ");
			
			List<Map<String, Object>> prodList = list;
			
			switch (sel) {
			case 1:
				String type = ScanUtil.nextLine("검색할 상품 타입 입력: ");
			    prodList = prodService.prodTypeSearch(type);
				
				System.out.println("번호\t이름\t내용\t\t가격\t수량\t종류");
				for(Map<String, Object> map: prodList) {
					int num = (int) map.get("NO");
					String name = (String) map.get("NAME");
					String content = (String) map.get("CONTENT");
					int price = (int) map.get("PRICE");
					int count = (int) map.get("COUNT");
					type = (String) map.get("TYPE");
					
					System.out.println(num+"\t"+name+"\t"+content+"\t"+price+"\t"+count+"\t"+type);
				}
				
				break;
				
			case 2:
				String name = ScanUtil.nextLine("검색할 상품 이름 입력: ");
				prodService.prodNameSearch(name);
				
				prodList = prodService.prodNameSearch(name);
				System.out.println("번호\t이름\t내용\t\t가격\t수량\t종류");
				for(Map<String, Object> map : prodList) {
					int num = (int) map.get("NO");
					name = (String) map.get("NAME");
					String content = (String) map.get("CONTENT");
					int price = (int) map.get("PRICE");
					int count = (int) map.get("COUNT");
					type = (String) map.get("TYPE");
					
					System.out.println(num+"\t"+name+"\t"+content+"\t"+price+"\t"+count+"\t"+type);
				}

				break;
			case 3:
			default:
			}
			
			// 이 내용은 작은  switch문의 case 123 모두에 속하기 때문에 밖으로 다 빼낼 수 있다.
			int prod_no = ScanUtil.nextInt("상품 번호 입력: ");
			
			Map<String, Object> prod = null;
			for(Map<String, Object> map: prodList) {
				if((int)map.get("NO") == prod_no) {
					prod = map;
				}
			}
			//이건 선택이 잘 됐는지 확인하려고만 뽑은 거다. 주석처리하자.
//			System.out.println(prod);
			sessionStorage.put("prod", prod);
			
			
			return View.PROD_DETAIL;
		case 2:
			return View.HOME;
		default:
			return View.PROD_LIST;
		}
		
	}

	private View member() {
		//로그인부터 진행해야겟죠
		//containsKey: 키에 그 값이 포함되어있는지 검사
		// 키가 있으면 로그인이 되고 없으면 다시 로그인페이지로 가라.
		boolean login = sessionStorage.containsKey("login");
		if(!login) {
			return View.LOGIN;
		}
		System.out.println("1. 상품 조회");
		System.out.println("2. 홈(로그아웃)");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PROD_LIST;
		case 2:
			//홈(로그아웃)할 때 로그인 정보를 제거하기 위함이다.
			sessionStorage.remove("login");
			return View.HOME;
		default:
			return View.MEMBER;
		}
		
	}

	private View home() {
		System.out.println("1. 일반회원");
		System.out.println("2. 관리자");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.MEMBER;
		case 2:
			return View.ADMIN;
		default:
			return View.HOME;
		}
	}
}
