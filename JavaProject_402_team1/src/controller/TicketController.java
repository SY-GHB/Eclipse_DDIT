package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.MemberService;
import service.TicketService;
import util.ScanUtil;
import util.View;
import vo.MemberVo;
import vo.TicketVo;

public class TicketController extends Print {
	MemberService memService = MemberService.getInstance();
	TicketService tickService = TicketService.getInstance();
	static public Map<String, Object> sessionStorage = new HashMap<>();
	

	public View ticketList() {
		printVar("티켓 리스트");
		
		List<TicketVo> ticketlist = tickService.ticketList();
		//티켓리스트를 출력해주는 코드
		printTicket(ticketlist);
		
		printTicketList();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.BUY_TICKET;
		default:
			return View.MAIN;
		}
	}
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 상품 구매하는 메뉴메소드, 실제 구매는 process()에서 이뤄진다.
	 */
	public View buyTicket() {
		//로그인해야 사용할 수 있는 메뉴
		MemberVo member = (MemberVo) MemberController.sessionStorage.get("member");
		if(member == null) {
			System.out.println("로그인 정보가 없습니다. 로그인페이지로 이동합니다.");
			MemberController.sessionStorage.put("View", View.TICKET_LIST);
			return View.MEM_LOGIN;
		}
		
		process();
		System.out.println("티켓 구매와 발권이 완료되었습니다. 티켓리스트로 돌아갑니다.");
		printLn(2);
		return View.TICKET_LIST;
	}
	
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 상품 구매하는 메소드
	 */
	public void process() {
		//1. 로그인한 멤버정보에서 그 멤버의 아이디를 가져온다.
		MemberVo member = (MemberVo) MemberController.sessionStorage.get("member");
		String mem_id = member.getMem_id();
		int mem_no = member.getMem_no();
		
		int sum =0;
		// 멤버 아이디를 넘겨줘서 DB에서 주문번호 만든 뒤에 그 주문번호를 가져왔다.
		String order_no = tickService.callOrder_no(mem_id); 
		
		//이 리스트는 나중에 같은 주문번호와 다른 티켓코드를 가진, cart 여러 행이 들어간 리스트가 될 것이다.
		List<List<Object>> paramList =  new ArrayList();
		//0사용일자 1구매할티켓코드가 들어가있다.
		List<Object> userNo = new ArrayList();
		
		while(true) {
			//param이란 리스트는 cart 한 줄(주문번호(while안에서는 고정), 티켓코드(입력), 수량(입력))
			List<TicketVo> ticketList = tickService.ticketList(); //또 db서 가져오기
			
			int usedate = ScanUtil.nextInt("사용일자를 yymmdd 형식으로 입력해주세요.");
			
			String code = ScanUtil.nextLine("티켓 번호를 골라주세요: ");
			TicketVo select = null;
			for (int i = 0; i < ticketList.size(); i++) {
				TicketVo t = ticketList.get(i);
				// 내가 입력한 티켓번호와 비교하기
				if(t.getTick_code().equals(code)) {
					select = t;
				}
			}
			
			int qty = ScanUtil.nextInt("티켓 수량을 입력해주세요: ");
			int price = select.getTick_price();
			sum += qty*price;
			
			//0주문번호, 1티켓코드, 2수량을 담았다. 이게 cart 한줄이 될듯.
			//아직은 똑같은 티켓을 더 구매하는 상황에 대응할 순 없지만, 주문번호 하나로 여러 종류(성인, 청소년, 소아...)의 티켓을 구매하는 건 해결이 됐다.
			List<Object> param = new ArrayList();
			param.add(order_no);
			param.add(code);
			param.add(qty);
			
			String yn = ScanUtil.nextLine("티켓을 구매하시겠습니까?(Y/N)");
			if(yn.equalsIgnoreCase("y")) {
				//cart 여러줄이 담긴 리스트
				paramList.add(param);
				//나중에 이용자번호 만들 때 쓸 것이다. userNoFn에 0사용일자, 1티켓코드를 담았다.
				userNo.add(usedate);
				userNo.add(select.getTick_code());
				break;
			}
			else {
				break;
			}
		} // 여기까지 while문
		
		//받은 데이터들로 order_에 한 행을 추가하고,
		insertOrder(order_no, sum, mem_no);
		// 같은 주문번호를 가진 cart 여러 행, 즉 cart 행 수만큼 insert메소드를 반복시킬것이다.
		// 그러면 카트에는 같은주문번호-다른티켓을 qty개 산 데이터가 들어간다.
		for (int i = 0; i < paramList.size(); i++) {
			insertCart(paramList.get(i));
			//i번째 paramList, 즉 i번째 카트데이터의 인덱스 2번=티켓수량(qty)만큼 반복해서 티켓발권.
			for (int j = 0; j < (int) paramList.get(i).get(2); j++) {
				//user테이블은 이용객번호, 사용일자(입력), 주문번호(fk), 티켓코드(fk)로 이루어져잇다.
				List<Object> param = new ArrayList();
				//0. 이용객번호
				param.add(tickService.callUser_no(userNo));
				//1.사용일자
				param.add(userNo.get(0));
				//2.주문번호(paramList의 첫번째줄이 카트 한 줄, 카트의 0번항목이 주문번호)
				param.add(paramList.get(i).get(0));
				//3.티켓코드(cart의 1번항목이 티켓코드)
				param.add(paramList.get(i).get(1));
				// 그럼 0이용객번호, 1사용일자, 2주문번호, 3구분코드 순으로 INSERT에 넣어줘야겟다.
				insertUser(param);
			}
		}
	}
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : ORDER_테이블에 ISNERT하는 메소드
	 */
	public void insertOrder(String order_no, int sum, int mem_no) {
		List<Object> param = new ArrayList();
		param.add(order_no);
		param.add(sum);
		param.add(mem_no);
		//static으로 바꾸라는 메세지 뜨면 잘못입력한거다...
		tickService.insertOrder(param);
	}
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : CART_테이블에 INSERT하는 메소드
	 */
	public void insertCart(List<Object> param) {
		//매개변수로 param 한 줄, 즉 cart 한 줄, 0.주문번호, 1.티켓코드, 2.티켓수량을 받아올것이다.
		// 그걸 dao로 보내주자.
		tickService.insertCart(param);
	}
	
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : USER테이블에 INSERT하는 메소드(발권메소드)
	 */
	public void insertUser(List<Object> param) {
		tickService.insertUser(param);
	}


}
