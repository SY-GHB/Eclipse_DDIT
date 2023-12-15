package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.AdminService;
import service.AttractionService;
import service.TicketService;
import util.ScanUtil;
import util.View;
import vo.AdminVo;
import vo.AttractionVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.TicketVo;

public class AdminController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	AdminService adService = AdminService.getInstance();
	TicketService tickService = TicketService.getInstance();
	AttractionService attService = AttractionService.getInstance();

	public View admin() {
		printAdminMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.NOTICE;
		case 2:
			return View.ADTICKET;
		case 3:
			return View.ADATT;
		case 4:
			return View.ADMEM;
		case 5:
			return View.ADSELL;
		case 6:
			AdminController.sessionStorage.remove("admin");
			return View.MAIN;
		default:
			printErr();
			return View.ADMIN;
		}
	}
	
	public View adLogin() {
		System.out.println("로그인 후 관리자 메뉴를 이용할 수 있습니다.");
		String id = ScanUtil.nextLine("관리자 ID: ");
		String pass = ScanUtil.nextLine("PASS: ");
		
		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		
		boolean loginchk = adService.adLogin(param);
		if (!loginchk) {
			printLoginCheckMenu();
			int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
			switch (sel) {
			case 1:
				return View.ADMIN_LOGIN;
			case 2:
				return View.MAIN;
			default:
				printErr();
				System.out.println("다시 로그인을 시도합니다.");
				return View.ADMIN_LOGIN;
			}
		}

		System.out.println(id+"님 환영합니다. 관리자 메뉴로 돌아갑니다.");
		return View.ADMIN;
	}

	public View notice() {
		
		printNoticeMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.NOTICE_LIST;
		case 3:
			return View.NOTICE_INSERT;
		default:
			printErr();
			return View.NOTICE;
		}
	}

	public View noticeList() {

		List<Object> param = new ArrayList();
		
		//페이징 기능
		int page_no;
		if(MainController.sessionStorage.get("page_no") == null) {
			 page_no = 1;
		} else {
			 page_no  =(int) MainController.sessionStorage.get("page_no");
		}
		
		int start_no =1+5*(page_no-1);
		int end_no	 =5+5*(page_no-1);
		//if문으로 없는 페이지의 출력을 막을 수 있다.
		
		param.add(start_no);
		param.add(end_no);
		
		List<NoticeVo> notiList = adService.noticeList(param);
		printNoitce(notiList);

		printNoticeListMenu();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			page_no--;
			MainController.sessionStorage.put("page_no", page_no);
			return View.NOTICE_LIST;
		case 2:
			page_no++;
			MainController.sessionStorage.put("page_no", page_no);
			return View.NOTICE_LIST;
		case 3:
			int board_no = ScanUtil.nextInt("조회할 공지 번호를 선택해 주세요: ");
			MainController.sessionStorage.put("board_no", board_no);
			return View.NOTICE_DETAIL;
		case 4:
			MainController.sessionStorage.remove("page_no");
			return View.ADMIN;
		default:
			printErr();
			return View.MEMNOTI;
		}
	}

	public View noticeDetail() {
		/*
		 * 상세공지 출력 메소드~~~
		 */
		int board_no = (int) MainController.sessionStorage.get("board_no");

		NoticeVo nt = adService.noticeDetail(board_no);
		printNoticeDetail(nt);

		printNoticeDetailMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.NOTICE_LIST;
		case 2:
			return View.NOTICE_UPDATE;
		case 3:
			return View.NOTICE_DELETE;
		default:
			printErr();
			return View.NOTICE_DETAIL;
		}
	}
	
	public View noticeInsert() {

		List<Object> param = new ArrayList<Object>();
		AdminVo admin = (AdminVo) AdminController.sessionStorage.get("admin");
		int admin_no = (int) admin.getADMIN_NO();
		String title = ScanUtil.nextLine("등록할 공지의 제목을 입력해주세요: ");
		String content = ScanUtil.nextLine("등록할 공지의 내용을 입력해주세요: ");
		
		param.add(admin_no);
		param.add(title);
		param.add(content);
		
		adService.noticeInsert(param);

		printNoticeInsertMenu();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.NOTICE_INSERT;
		case 2:
			return View.NOTICE_LIST;
		default:
			printErr();
			return View.NOTICE_LIST;
		}
	}

	public View noticeUpdate() {
		int board_no = (int) MainController.sessionStorage.get("board_no");
		List<Object> param = new ArrayList();
		String title = ScanUtil.nextLine("바꿀 공지 제목을 입력해 주세요.");
		String content = ScanUtil.nextLine("바꿀 공지 내용을 입력해 주세요.");
		param.add(title);
		param.add(content); 
		
		adService.noticeUpdate(param, board_no);

		printNoticeUpdateMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			board_no = ScanUtil.nextInt("수정할 번호를 입력해 주세요.");
			sessionStorage.put("board_no", board_no);
			return View.NOTICE_UPDATE;
		case 2:
			return View.NOTICE_LIST;
		default:
			printErr();
			return View.NOTICE_LIST;
		}
	}

	public View noticeDelete() {
		/*
		 * 공지삭제메소드~
		 */
		int board_no = (int) MainController.sessionStorage.get("board_no");
		adService.noticeDelete(board_no);

		printNoticeDeleteMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			board_no = ScanUtil.nextInt("삭제할 번호를 입력해 주세요.");
			sessionStorage.put("board_no", board_no);
			return View.NOTICE_DELETE;
		case 2:
			return View.NOTICE_LIST;
		default:
			printErr();
			return View.NOTICE_LIST;
		}

	}

	public View ticket() {
		printTicket();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.ADTICKET_LIST;
		case 3:
			return View.ADTICKET_INSERT;
		default:
			printErr();
			return View.ADTICKET;
		}
	}

	public View ticketList() {
		List<TicketVo> ticketlist = tickService.ticketList();
		printTicket(ticketlist);

		printTicketListMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			
			printTicketListMenu2();
			
			int nsel = ScanUtil.nextInt("수정하고 싶은 항목의 번호를 골라주세요.");
			
			List<Object> param = new ArrayList();
			switch(nsel) {
			case 1:
				int tick_no = ScanUtil.nextInt("수정할 티켓 번호를 선택해 주세요: ");
				param.add(ScanUtil.nextLine("수정할 티켓 이름: "));
				param.add(tick_no);
				adService.ticNameUp(param);
				System.out.println("수정이 완료되었습니다. 티켓리스트로 돌아갑니다.");
				return View.ADTICKET_LIST;
			case 2:
				tick_no = ScanUtil.nextInt("수정할 티켓 번호를 선택해 주세요: ");
				param.add(ScanUtil.nextInt("티켓가격 새로 입력 >>"));
				param.add(tick_no);
				adService.ticPriceUp(param);
				System.out.println("수정이 완료되었습니다. 티켓리스트로 돌아갑니다.");
				return View.ADTICKET_LIST;
			default:
				System.out.println("잘못 입력하였습니다. 티켓리스트로 돌아갑니다.");
				return View.ADTICKET_LIST;
			}
		case 3:
			return View.ADTICKET_DELETE;
		default:
			printErr();
			return View.ADTICKET_LIST;
		}
	}

	public View ticketInsert() {
		String name = ScanUtil.nextLine("티켓이름:");
		int price = ScanUtil.nextInt("가격 입력:");

		List<Object> param = new ArrayList();
		param.add(name);
		param.add(price);
		adService.ticketInsert(param);

		System.out.println("티켓추가가 완료되었습니다.");

		printTicketInsertMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADTICKET_INSERT;
		case 2:
			return View.ADTICKET_LIST;
		default:
			printErr();
			return View.ADTICKET_LIST;
		}
	}

	public View ticketDelete() {
		List<Object> param = new ArrayList();
		param.add(ScanUtil.nextInt("삭제할 티켓 번호를 선택해 주세요: "));
		adService.ticketDelete(param);

		printTicketDeleteMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADTICKET_DELETE;
		case 2:
			return View.ADTICKET_LIST;
		default:
			printErr();
			return View.ADTICKET_LIST;
		}


	}

	public View adAtt() {
		
		printAdAttMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.ADATT_LIST;
		case 3:
			return View.ADATT_INSERT;
		default:
			printErr();
			return View.ADATT;
		}
	}
	
	public View adattList() {
		
		List<Object> param = new ArrayList();
		int page_no = 1;
		if (sessionStorage.containsKey("page_no")) {
			page_no = (int) sessionStorage.get("page_no");
		}
		int start_no = 1 + 5 * (page_no - 1);
		int end_no = 5 + 5 * (page_no - 1);
		param.add(start_no);
		param.add(end_no);

		List<AttractionVo> attList = attService.attList(param);
		printVar();
		System.out.println("번호\t이름\t\t내용\t\t탑승인원\t위치\t\t소요시간\t운영여부");
		printVar();
		for (AttractionVo att : attList) {
			int no = att.getAtt_no();
			String name = att.getAtt_name();
			String content = att.getAtt_content();
			int person = att.getAtt_person();
			String location = att.getAtt_location();
			String time = att.getAtt_spenttime();
			String run = att.getAtt_runyn();
			System.out.println(no + "\t" + name + "\t\t" + content + "\t" + person + "\t" + location + "\t" + time + "\t" + run);
		}
		printVar();
		
		printAdAttListMenu();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			page_no--;
			sessionStorage.put("page_no", page_no);
			System.out.println();
			return View.ADATT_LIST;
		case 2:
			page_no++;
			sessionStorage.put("page_no", page_no);
			return View.ADATT_LIST;
		case 3:
			return View.ADATT;
		case 4:
			int board_no = ScanUtil.nextInt("놀이기구 번호 입력");
			sessionStorage.put("board_no", board_no);
			return View.ADATT_DETAIL;
		case 5:
			return View.ADATT_UPADATE;
		case 6:
			return View.ADATT_DELETE;
		default:
			return View.ADATT_LIST;
		}


	}

	public View adattDetail() {
		int board_no = (int) sessionStorage.get("board_no");
		
		printLn(2);
		printVar();
		System.out.println("번호\t이름\t\t탑승인원\t위치\t\t소요시간\t운영여부");
		printVar();
		
		AttractionVo att = attService.attDetail(board_no);
		int no = att.getAtt_no();
		String name = att.getAtt_name();
		String content = att.getAtt_content();
		int person = att.getAtt_person();
		String location = att.getAtt_location();
		String time = att.getAtt_spenttime();
		String run = att.getAtt_runyn();
		System.out.println(no + "\t" + name + "\t" + person + "\t" +location + "\t" +time + "\t" + run);
		printVar();
		System.out.println(content);
		printVar();

		printAdAttDetailMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADATT_LIST;
		case 2:
			return View.ADATT_UPADATE;
		case 3:
			return View.ADATT_DELETE;
		default:
			printErr();
			return View.ADATT_LIST;
		}
	}

	public View adattInsert() {

		List<Object> param = new ArrayList<>();
		param.add(ScanUtil.nextLine("놀이기구 이름 입력 >>"));
		param.add(ScanUtil.nextLine("놀이기구 내용 입력 >>"));
		param.add(ScanUtil.nextLine("탑승인원 입력 >>"));
		param.add(ScanUtil.nextLine("위치 입력 >>"));
		param.add(ScanUtil.nextLine("소요시간 입력 (N분)>>"));
		param.add(ScanUtil.nextLine("운영여부 입력 (Y/N)>>"));
		adService.adattInsert(param);
		

		printAdAttInsertMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADATT_INSERT;
		case 2:
			return View.ADATT_LIST;
		default:
			printErr();
			return View.ADATT_LIST;
		}
	}
	
	public View adattUpdate() {
		
		int attsel = ScanUtil.nextInt("변경할 놀이기구 번호 선택 >>");

		List<Object> param = new ArrayList<>();
		printAdAttUpdateMenu();
		
		int atttsel = ScanUtil.nextInt("변경할 항목 >>");
		switch (atttsel) {
		case 1:
			param.add(ScanUtil.nextLine("놀이기구 이름 새로 입력 >>"));
			param.add(attsel);
			adService.attNameUp(param);
			break;
		case 2:
			param.add(ScanUtil.nextLine("놀이기구 내용 새로 입력 >>"));
			param.add(attsel);
			adService.attContentUp(param);
			break;
		case 3:
			param.add(ScanUtil.nextInt("탑승인원 새로 입력 >>"));
			param.add(attsel);
			adService.attPersonUp(param);
			break;
		case 4:
			param.add(ScanUtil.nextLine("위치 새로 입력 >>"));
			param.add(attsel);
			adService.attLocationUp(param);
			break;
		case 5:
			param.add(ScanUtil.nextLine("소요시간 새로 입력 >>"));
			param.add(attsel);
			adService.attTimeUp(param);
			break;
		case 6:
			param.add(ScanUtil.nextLine("운영여부 새로 입력(Y/N)>>"));
			param.add(attsel);
			adService.attRunUp(param);
			break;
		default:
			printErr();
			return View.ADATT_UPADATE;
		}
		
		printAdAttUpdateMenu2();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADATT_UPADATE;
		case 2:
			return View.ADATT_LIST;
		default:
			printErr();
			return View.ADATT_LIST;
		}
	}

	public View adattDelete() {

		List<Object> param = new ArrayList();
		param.add(ScanUtil.nextInt("삭제할 놀이기구 선택 >>"));
		adService.attDelete(param);
		
		printAdAttDeleteMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요: ");
		switch (sel) {
		case 1:
			return View.ADATT_DELETE;
		case 2:
			return View.ADATT_LIST;
		default:
			printErr();
			return View.ADATT_LIST;
		}

	}

	public View admem() {

		printAdmemMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.ADMEM_LIST;
		default:
			printErr();
			return View.ADMEM;
		}
	}

	public View admemList() {
		List<Object> param = new ArrayList();
		int page_no = 1;
		if(sessionStorage.containsKey("page_no")) {
			page_no = (int)sessionStorage.get("page_no");
		}
		int start_no = 1+10*(page_no-1);
		int end_no = 10+10*(page_no-1);
		param.add(start_no);
		param.add(end_no);
		
		List<MemberVo> memList = adService.memList(param);
		printVar();
		System.out.println("회원번호\t아이디\t비밀번호 \t이름 \t닉네임");
		printVar();
		for(MemberVo mem : memList) {
			int no = mem.getMem_no();
			String id = mem.getMem_id();
			String pass =  mem.getMem_pass();
			String name = mem.getMem_name();
			String nick = mem.getMem_nick();
			System.out.println(no +"\t"+ id +"\t"+ pass +"\t"+ name +"\t"+ nick);
		}
		printVar();
		
		printAdmemListMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			page_no--;
			sessionStorage.put("page_no", page_no);
			System.out.println();
			return View.ADMEM_LIST;
		case 2:
			page_no++;
			sessionStorage.put("page_no", page_no);
			return View.ADMEM_LIST;
		case 3:
			return View.ADMEM;
		case 4:
			int mem_no = ScanUtil.nextInt("조회할 회원 번호 입력 >>");
			sessionStorage.put("mem_no", mem_no);
			return View.ADMEM_DETAIL;
		default:
			printErr();
			return View.ADMEM_LIST;
		}
	}

	public View admemDetail() {
		int mem_no = (int) sessionStorage.get("mem_no");
		MemberVo mem = adService.admemDetail(mem_no);
		System.out.println("회원번호\t아이디\t비밀번호 \t이름 \t닉네임");
		int no = mem.getMem_no();
		String id = mem.getMem_id();
		String pass = mem.getMem_pass();
		String name = mem.getMem_name();
		String nick = mem.getMem_nick();
		System.out.println(no+"\t"+id+"\t"+pass+"\t"+name+"\t"+nick);
		

		printAdmemDetailMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMEM_LIST;
		case 2:
			sessionStorage.put("mem_no", mem_no);
			return View.ADMEM_UPDATE;
		case 3:
			sessionStorage.put("mem_no", mem_no);
			return View.ADMEM_DELETE;
		default:
			printErr();
			return View.ADMEM_DETAIL;
		}
	}

	public View admemUpdate() {
		int mem_no = (int) sessionStorage.get("mem_no");
		List<Object> param = new ArrayList<>();
		
		printAdMemUpdateMenu();
		
		int mem_noo = ScanUtil.nextInt("수정할 항목 선택 >>");
		switch(mem_noo) {
		case 1:
			param.add(ScanUtil.nextLine("새로운 비밀번호 입력 >>"));
			param.add(mem_no);
			adService.adMemPassUp(param);
			break;
		case 2:
			param.add(ScanUtil.nextLine("새로운 이름 입력 >>"));
			param.add(mem_no);
			adService.adMemNameUp(param);
			break;
		case 3:
			param.add(ScanUtil.nextLine("새로운 닉네임 입력 >>"));
			param.add(mem_no);
			adService.adMemNickUp(param);
			break;
		}
		
		
		
		printAdMemUpdateMenu2();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			mem_no = (int) sessionStorage.put("mem_no", mem_no);
			return View.ADMEM_UPDATE;
		case 2:
			sessionStorage.remove("page_no");
			return View.ADMEM_LIST;
		default:
			printErr();
			return View.ADMEM_LIST;
		}
	}

	public View admemDelete() {
		int mem_no = (int) sessionStorage.get("mem_no");
		
		List<Object> param = new ArrayList();
		param.add(mem_no);
		adService.adMemDel(param);
		
		printAdMemUDeleteMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			mem_no = ScanUtil.nextInt("삭제할 번호를 입력해 주세요.");
			sessionStorage.put("mem_no", mem_no);
			return View.ADMEM_DELETE;
		case 2:
			return View.ADMEM_LIST;
		default:
			printErr();
			return View.ADMEM_LIST;
		}
	}

	public View adsell() {
		printAdsellMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해주세요.");
		switch (sel) {
		case 1:
			return View.ADMIN;
		case 2:
			return View.ADSELL_MONTH;
		case 3:
			return View.ADSELL_DATE;
		default:
			printErr();
			return View.ADSELL;
		}
	}

//	public View adsellTicket() {
//		System.out.println("티켓 번호\t연령구분\t판매수량\t가격총합");
//
//		List<Map<String, Object>> param = adService.adsellTicket();
//		for (Map<String, Object> ticket : param) {
//			System.out.println(ticket.get("TICK_CODE") + "\t" + ticket.get("TICK_NAME")+
//					"\t" + ticket.get("CART_QTY") + "\t" + ticket.get("SUM"));
//		}
//
//		System.out.println("1. 매출관리로 돌아가기");
//		System.out.println("2. 월별 매출조회");
//		System.out.println("3. 일별 매출조회");
//
//		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요.");
//		switch (sel) {
//		case 1:
//			return View.ADSELL;
//		case 2:
//			return View.ADSELL_MONTH;
//		case 3:
//			return View.ADSELL_DATE;
//		default:
//			printErr();
//			return View.ADSELL_TICKET;
//		}
//	}

	/**
	 * user: psy date: 12.14 : 티켓 월별 매출 출력 메소드
	 */
	public View adsellMonth() {

		while (true) {
			int yyyymm = ScanUtil.nextInt("조회할 월을 yyyymm 형식으로 입력하세요: ");
			Map<String, Object> param = adService.adsellMonth(yyyymm);
			System.out.println("년도\t월\t총 금액");
			System.out.println(param.get("YEAR") + "\t" + param.get("MON") + "\t" + param.get("SUM"));
			String yn = ScanUtil.nextLine("다른 월을 조회하시겠습니까? (Y/N)");
			if (yn.equalsIgnoreCase("y")) {
				continue;
			} else {
				break;
			}
		}

		printAdsellMonthMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.ADSELL;
		case 2:
			return View.ADSELL_DATE;
		default:
			printErr();
			return View.ADSELL_MONTH;
		}
	}

	/**
	 * user: psy date: 12.14 : 티켓 일별 매출 출력 메소드
	 */
	public View adsellDate() {

		while (true) {
			int yyyymmdd = ScanUtil.nextInt("조회할 일을 yyyymmdd 형식으로 입력하세요: ");
			Map<String, Object> param = adService.adsellDate(yyyymmdd);
			System.out.println("년도\t월\t일\t총 금액");
			System.out.println(param.get("YEAR") + "\t" + param.get("MON") + "\t"
								+ param.get("DAY") + "\t" + param.get("SUM"));
			String yn = ScanUtil.nextLine("다른 날을 조회하시겠습니까? (Y/N)");
			if (yn.equalsIgnoreCase("y")) {
				continue;
			} else {
				break;
			}
		}

		printAdsellDateMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.ADSELL;
		case 2:
			return View.ADSELL_MONTH;
		default:
			printErr();
			return View.ADSELL_DATE;
		}
	}

}
