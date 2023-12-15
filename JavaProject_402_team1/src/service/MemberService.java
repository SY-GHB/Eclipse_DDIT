package service;

import java.util.List;
import java.util.Map;

import controller.MemberController;
import dao.MemberDao;
import vo.MemberVo;
import vo.OrderVo;
import vo.TicketVo;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	MemberDao dao = MemberDao.getInstance();
	
	public boolean memLogin(List<Object> param) {
		MemberVo mem = dao.memLogin(param);
		if(mem != null) {
			MemberController.sessionStorage.put("member", mem);
			return true;
		}
		return false;
	}

	public void updatePass(List<Object> param) {
		dao.updatePass(param);
	}

	public void updateName(List<Object> param) {
		dao.updateName(param);
	}

	public void updateNick(List<Object> param) {
		dao.updateNick(param);
		
	}

	public void memOut(String mem_id) {
		dao.memOut(mem_id);
		
	}

	public List<Map<String, Object>> getOrderNo(int mem_no) {
		//키값이 "ORDER_NO"인 ORDER_NO들이 리스트로 출력됨
		return dao.getOrderNo(mem_no);
	}

	public Map<String, Object> buyTicketList(String order_no) {
		return dao.buyTicketList(order_no);
	}

	public void memSignup(List<Object> param) {
		dao.memSignup(param);
		
	}

}
