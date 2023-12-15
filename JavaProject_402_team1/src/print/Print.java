package print;

import java.util.List;
import java.util.Map;

import service.MemberService;
import vo.MemberVo;
import vo.NoticeVo;
import vo.TicketVo;


public class Print extends printPretty{
	MemberService memService = MemberService.getInstance();
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 티켓종류를 출력해주는 프린트메소드
	 */
	public void printTicket(List<TicketVo> ticketlist) {
		
		printVar();
		System.out.println("번호\t이름\t가격");
		printVar();
		
		for(TicketVo tk : ticketlist) {
			System.out.println(tk.getTick_code()+"\t"+tk.getTick_name()+"\t"+tk.getTick_price());
		}
		printVar();
	}
	
	public void printTicketDetail(List<TicketVo> ticketlist, int tick_no) {
		printVar();
		System.out.println("번호\t이름\t가격");
		printVar();
		int i = tick_no-1;
		TicketVo tk = ticketlist.get(i);
		System.out.println(tk.getTick_code()+"\t"+tk.getTick_name()+"\t"+tk.getTick_price());
		printVar();
	}
	
	public void printNoitce(List<NoticeVo> notiList) {
		printVar();
		System.out.println("번호\t제목\t\t내용\t\t\t\t일자");
		printVar();
		for(NoticeVo nt : notiList) {
			System.out.println(nt.getNoti_no()+"\t"+nt.getNoti_name()+"\t"+nt.getNoti_content()+"\t"+nt.getNoti_date());
		}
		printVar();
	}
	
	public void printNoticeDetail(NoticeVo nt) {
		printVar();
		System.out.println("번호\t\t제목\t\t일자");
		printVar();
		String content = nt.getNoti_content();
		printVar();
		
		System.out.println(nt.getNoti_no()+"\t"+nt.getNoti_name()+"\t\t"+nt.getNoti_date());
		printVar();
		int length = 200;
		for (int i = 0; i < content.length(); i=i+length) {
			if(i+length>content.length()) {
				System.out.println(content.substring(i,content.length()));
			}
			else {
				System.out.println(content.substring(i,i+length));
			}
		}
		printVar();
		printLn(2);
	}
	
	public void printbuyTicketList(MemberVo member) {
		int mem_no = member.getMem_no();
		List<Map<String, Object>> order = memService.getOrderNo(mem_no);
		printVar();
		System.out.println("이용번호\t\t사용일자\t\t티켓구분");
		printVar();
		for (int i = 0; i < order.size(); i++) {
			//오더넘버들을 하나씩 불렀다.
			String order_no = (String) order.get(i).get("ORDER_NO");
			Map<String, Object> map = memService.buyTicketList(order_no);
			System.out.println(map.get("USER_NO")+"\t"+map.get("USER_DATE")+"\t"+map.get("TICK_NAME"));
		}
		printVar();
	}		
	
}
