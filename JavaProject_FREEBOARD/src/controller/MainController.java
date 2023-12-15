package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.FreeBoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.FreeBoardVo;
import vo.MemberVo;

public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	FreeBoardService freeService = FreeBoardService.getInstance();
	MemberService memberService = MemberService.getInstance();
	
	public static void main(String[] args) {
		//시작하자마자 페이지넘버를 1로 정해줬다.
		sessionStorage.put("page_no",1);
		new MainController().start();
	}
	
	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case LOGIN:
				view = login();
				break;
			case FREE_LIST:
				view = freeList();
				break;
			case FREE_DETAIL:
				view = freeDetail();
				break;
			case FREE_UPDATE:
				view = freeUpdate();
				break;
			case FREE_DELETE:
				view = freeDelete();
				break;
			case ADMIN:
				view = home();
				break;
			default:
				break;
			}
		}
	}


	private View login() {
		
		String id = ScanUtil.nextLine("ID: ");
		String pass = ScanUtil.nextLine("PASS: ");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		
		boolean loginchk = memberService.login(param);
		if(!loginchk) {
			System.out.println("1.다시 로그인");
			System.out.println("2.회원가입");
			System.out.println("3.홈");

			int sel = ScanUtil.nextInt("메뉴 선택: ");
			switch(sel) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.MAIN;
			default: 
				return View.LOGIN;
			}
		}
		
		//삭제페이지에서 로그인을 했으면 삭제페이지로, 수정페이지에서 로그인을 했으면 수정페이지로 보내주자.
		View view = (View) sessionStorage.get("View");
		if(view == null) return View.MAIN;
	
		return view;
	}

	private View freeUpdate() {
		/*
		 * 업데이트는 각자 해보기
		 */
		
		//역시 로그인 먼저 진행해야겟죠.. 로그인정보를 VO에서 가져오고
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		if(mem==null) {
			// 2. 성공 시 update페이지로 돌아오게 해주자.
			sessionStorage.put("View", View.FREE_UPDATE);
			// 1. 로그인이 안 되어있으면 로그인 페이지로 보내주자. 
			return View.LOGIN;
		}
		
		
		// 내 게시판이 맞는지 확인하고 내 게시판만 수정할 수 있게 한다.
		// board_no는 상세페이지 조회에서 특정 게시글 번호를 선택하면서 스토리지에 넣어왔다.
		int board_no = (int) sessionStorage.get("board_no");
		FreeBoardVo fb = freeService.freeDetail(board_no);
		
		// 게시글의 작성자 번호와 멤버번호가 같지 않으면, 즉 작성자가 아니면
		if(fb.getMem_no() != mem.getMem_no()) {
			System.out.println("해당 게시글 작성자가 아닙니다.");
			return View.FREE_DETAIL;
		}
		
		//이제 로그인도 했고 작성자가 맞는지 확인도 했다. 그러면 게시글 수정을 진행하자.
		List<Object> param = new ArrayList();
		String title = ScanUtil.nextLine("바꿀 제목을 입력해 주세요.");
		String content = ScanUtil.nextLine("바꿀 내용을 입력해 주세요.");
		param.add(title);
		param.add(content);
		freeService.freeUpdate(param, board_no);

		return View.FREE_LIST;
	}

	private View freeDelete() {
		
		// 로그인 먼저 진행
		MemberVo mem = (MemberVo) sessionStorage.get("member");
		if(mem == null) {
			// 이걸 담고 로그인페이지로 가서 로그인에 성공하면 delete페이지로 오게 만든다.
			sessionStorage.put("View", View.FREE_DELETE);
			return View.LOGIN;
		}
		
		// 내 게시판이 맞는지 확인하고 내 게시판만 지울 수 있게 해주자.
		int board_no = (int) sessionStorage.get("board_no");
		//vo(전체 게시판 정보를 다 가지고 있음)에서 board_no를 넣었을 때 나오는 게시글 정보
		//그 게시글 정보의 작성자를 fb.getMem_no라고 했다.
		FreeBoardVo fb = freeService.freeDetail(board_no);
		if(fb.getMem_no() != mem.getMem_no()) {
			// 작성자가 아니면 삭제가 안 된다.
			System.out.println("해당 게시글 작성자가 아닙니다.");
			return View.FREE_DETAIL;
		}
		
		//게시글 삭제 진행 서비스를 통해서>dao에서 sql명령을>jdbc로
		freeService.freeDelete(board_no);
		
		return View.FREE_LIST;
	}

	private View freeDetail() {
		/*
		 * 상세페이지 출력
		 * 
		 * 메뉴문구
		 * 1. 게시팡 수정(로그인 진행, 내 게시판 아니라면 수정 불가)
		 * 2. 게시판 삭제(로그인 진행, 내 게시판 아니라면 수정 불가)
		 */
		
		//파라미터로 페이지 넘버값이 들어가야 함
		int board_no = (int) sessionStorage.get("board_no");
		FreeBoardVo fb = freeService.freeDetail(board_no);
		
		printLn(1);
		System.out.println(fb);
		printLn(1);

		
		printDetailMenu();
		
		int sel = ScanUtil.nextInt("메뉴 선택: ");
		switch(sel) {
		case 1:
			return View.FREE_UPDATE;
		case 2:
			return View.FREE_DELETE;
		case 3:
			return View.MAIN;
		default: 
			return View.FREE_DETAIL;
		}
	}

	private View freeList() {
		/*
		 * 전체 게시판  조회
		 */
		List<Object> param = new ArrayList();
		
		//페이징 기능
		int page_no  =(int) sessionStorage.get("page_no");
		int start_no =1+5*(page_no-1);
		int end_no	 =5+5*(page_no-1);
		//if문으로 없는 페이지의 출력을 막을 수 있다.
		
		param.add(start_no);
		param.add(end_no);
		
		List<FreeBoardVo> freeList =  freeService.freeList(param);
		printList(freeList);

		printListMenu();
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			page_no++;
			sessionStorage.put("page_no", page_no);
			return View.FREE_LIST;
		case 2:
			page_no--;
			sessionStorage.put("page_no", page_no);
			return View.FREE_LIST;
		case 3:
			// 만약 없는 번호를 선택하면 잘못 선택했다고 알려주고 다시 선택할 수 있으면 좋겠지만
			// 시간관계상 생략.한다.
			int board_no = ScanUtil.nextInt("게시글 번호 선택 : ");
			sessionStorage.put("board_no", board_no);
			return View.FREE_DETAIL;
		default:
			return View.MAIN;
		}
		
	}

	private View home() {
		printHome();
		printLn(2);
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.FREE_LIST;
		case 2:
			return View.ADMIN;
		case 3:
			sessionStorage.remove("member");
			return View.MAIN;
		default:
			return View.MAIN;
		}
	}
}
