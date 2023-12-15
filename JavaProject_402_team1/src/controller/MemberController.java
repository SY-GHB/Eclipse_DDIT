package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import print.Print;
import service.AdminService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrderVo;
import vo.TicketVo;

public class MemberController extends Print {
	public static Object obj;
	MemberService memService = MemberService.getInstance();
	AdminService adService = AdminService.getInstance();
	static public Map<String, Object> sessionStorage = new HashMap<>();

	public View member() {

		printMember();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.MEM_LOGIN;
		case 2:
			return View.MEM_DETAIL;
		case 3:
			return View.MEM_SIGNUP;
		case 4:
			sessionStorage.remove("member");
			return View.MAIN;
		case 5:
			return View.MAIN;	
		default:
			printErr();
			return View.MEMBER;
		}
	}
	
	public View memLogin() {
		List<Object> param = new ArrayList();

		String id = ScanUtil.nextLine("ID: ");
		String pass = ScanUtil.nextLine("PASS: ");
		param.add(id);
		param.add(pass);

		memService.memLogin(param);
		MemberVo member = (MemberVo) sessionStorage.get("member");

		if (member == null) {
			printLoginCheckMenu2();

			int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
			switch (sel) {
			case 1:
				return View.MEM_LOGIN;
			case 2:
				return View.MEM_SIGNUP;
			case 3:
				return View.MAIN;
			default:
				return View.MEM_LOGIN;
			}
		}
		
		System.out.println(id+"님 환영합니다. 메인메뉴로 돌아갑니다.");
		printLn(3);
		
		View view = (View) MemberController.sessionStorage.get("View");
		if (view == null) {
			return View.MAIN;
		}
		return view;

	}

	public View memDetail() {

		//로그인해야 사용할 수 있는 메뉴
		MemberVo member = (MemberVo) sessionStorage.get("member");
		if(member == null) {
			System.out.println("로그인 정보가 없습니다. 로그인페이지로 이동합니다.");
			MemberController.sessionStorage.put("View", View.MEM_DETAIL);
			return View.MEM_LOGIN;
		}
		
		printMemDetail();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.MEM_UPDATE;
		case 2:
			return View.MEM_OUT;
		case 3:
			return View.BUYTICK_LIST;
		case 4:
			return View.MEMBER;
		default:
			return View.MAIN;
		}
	}

	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 멤버 정보 수정하는 메뉴메소드
	 */
	public View memUpdate() {
		MemberVo member = (MemberVo) MemberController.sessionStorage.get("member");
		String mem_id = member.getMem_id();
		
		printMemUpdateMenu();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		List<Object> param =  new ArrayList();
		switch (sel) {
		case 1:
			String pass = ScanUtil.nextLine("수정할 비밀번호: ");
			param.add(pass);
			param.add(mem_id);
			
			memService.updatePass(param);
			System.out.println("비밀번호가 수정되었습니다. 회원 정보 페이지로 돌아갑니다.");
			return View.MEM_DETAIL;
			
		case 2:
			String name = ScanUtil.nextLine("수정할 이름: ");
			param.add(name);
			param.add(mem_id);
			
			memService.updateName(param);
			System.out.println("이름이 수정되었습니다. 회원 정보 페이지로 돌아갑니다.");
			return View.MEM_DETAIL;
			
		case 3:
			String nick = ScanUtil.nextLine("수정할 별명: ");
			param.add(nick);
			param.add(mem_id);
			
			memService.updateNick(param);
			System.out.println("닉네임이 수정되었습니다. 회원 정보 페이지로 돌아갑니다.");
			return View.MEM_DETAIL;
			
		case 4:
			return View.MEM_DETAIL;
			
		default:
			printErr();
			return View.MEM_DETAIL;
		}
	}

	public View memOut() {
		
		MemberVo member = (MemberVo) sessionStorage.get("member");
		String mem_id = member.getMem_id();
		
		memService.memOut(mem_id);
		
		sessionStorage.remove("member");
		System.out.println("회원탈퇴가 완료되었습니다. 메인화면으로 돌아갑니다.");
		return View.MAIN;
	}

	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 구매내역 출력하는 메뉴메소드
	 */
	public View buyTicketList() {
		MemberVo member = (MemberVo) sessionStorage.get("member");
		printbuyTicketList(member);
				
		printbuyTicketListMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.MEM_DETAIL;
		case 2:
			return View.MEMBER;
		default:
			printErr();
			return View.MEM_DETAIL;
		}
	}
	
	public View memSignup() {
		List<Object> param = new ArrayList<Object>();
		
		printSignUpguide();
		
		String id = ScanUtil.nextLine("ID: ");
		String pass = ScanUtil.nextLine("PASS: ");
		String name = ScanUtil.nextLine("이름: ");
		String nick = ScanUtil.nextLine("닉네임: ");
		
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(nick);
		
		memService.memSignup(param);
		System.out.println("회원가입이 완료되었습니다. 회원메뉴로 이동합니다.");

		return View.MEMBER;
	}

	public View memNoti() {
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
		printMemNotiMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			page_no--;
			MainController.sessionStorage.put("page_no", page_no);
			return View.MEMNOTI;
		case 2:
			page_no++;
			MainController.sessionStorage.put("page_no", page_no);
			return View.MEMNOTI;
		case 3:
			int board_no = ScanUtil.nextInt("조회할 번호를 입력하세요");
			MainController.sessionStorage.put("board_no", board_no);
			return View.MEMNOTI_DEATIL;
		case 4:
			MainController.sessionStorage.remove("board_no");
			return View.MAIN;
		default:
			return View.MEMNOTI;
		}
	}

	public View memNotiDetail() {
		
		int board_no = (int) MainController.sessionStorage.get("board_no");
		NoticeVo nt = adService.noticeDetail(board_no);
		printNoticeDetail(nt);
		
		printMemNotiDetailMenu();

		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.MEMNOTI;
		case 2:
			return View.MAIN;
		default:
			printErr();
			return View.MEMNOTI_DEATIL;
		}
	}




}