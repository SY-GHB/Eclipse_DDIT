package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import dao.TicketDao;
import vo.OrderVo;
import vo.TicketVo;

public class TicketService {
	private static TicketService instance = null;

	private TicketService() {
	}

	public static TicketService getInstance() {
		if (instance == null) {
			instance = new TicketService();
		}
		return instance;
	}
	
	TicketDao dao = TicketDao.getInstance();
	
	
	
	public List<TicketVo> ticketList() {
		return dao.ticketList();
	}
	
	
	public TicketVo ticketDetail(int tick_code) {
		return dao.ticketDetail(tick_code);
	}

	
	public List<OrderVo> orderList() {
		return dao.orderList();
	}

	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 주문번호를 생성하는 메소드
	 */
	public String callOrder_no(String mem_id) {
		//jdbc는 map을 반환하는데, 거기서 원하는 데이터만 뽑아서 컨트롤러로 넘겨주는게 서비스의 역할이다.
		Map<String, Object> map = dao.callOrder_no(mem_id);
		String order_no = (String) map.get("ORDER_NO"); 
		return order_no;
	}
	
	public void insertOrder(List<Object> param) {
		dao.insertOrder(param);
	}
	
	public void insertCart(List<Object> param) {
		dao.insertCart(param);
	}
	
	/**
	 * user: psy
	 * date: 12.13
	 * 	   : 이용자번호를 생성하는 메소드
	 */
	public BigDecimal callUser_no(List<Object> userNo) {
		Map<String, Object> map = dao.callUser_no(userNo);
		return (BigDecimal) map.get("USER_NO");
	}

	public void insertUser(List<Object> param) {
		dao.inserUser(param);
		
	}
	
	
}
