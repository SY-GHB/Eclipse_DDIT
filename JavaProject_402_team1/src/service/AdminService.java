package service;

import java.util.List;
import java.util.Map;

import controller.AdminController;
import controller.MainController;
import dao.AdminDao;
import vo.AdminVo;
import vo.MemberVo;
import vo.NoticeVo;

public class AdminService {
	private static AdminService instance = null;

	private AdminService() {
	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}
	
	AdminDao dao = AdminDao.getInstance();

	public List<Map<String, Object>> adsellTicket() {
		return dao.adsellTicket();
	}

	public Map<String, Object> adsellMonth(int yyyymm) {
		return dao.adsellMonth(yyyymm);
	}

	public Map<String, Object> adsellDate(int yyyymmdd) {
		return dao.adsellDate(yyyymmdd);
	}

	public List<NoticeVo> noticeList(List<Object> param) {
		return dao.noticeList(param);
	}

	public NoticeVo noticeDetail(int board_no) {
		return dao.noticeDetail(board_no);
	}

	public void noticeInsert(List<Object> param) {
		dao.noticeInsert(param);
	}

	public void noticeUpdate(List<Object> param, int board_no) {
		dao.noticeUpdate(param, board_no);
	}

	public void noticeDelete(int board_no) {
		dao.noticeDelete(board_no);
		
	}

	public boolean adLogin(List<Object> param) {

		AdminVo admin = dao.adLogin(param);
		
		if(admin != null) {
			AdminController.sessionStorage.put("admin", admin);
			return true;
		}
		return false;
	}

	public void ticketInsert(List<Object> param) {
		dao.ticketInsert(param);
	}

	public void ticNameUp(List<Object> param) {
		dao.ticNameUp(param);
		
	}

	public void ticPriceUp(List<Object> param) {
		dao.ticPriceUp(param);
		
	}

	public void ticketDelete(List<Object> param) {
		dao.ticketDelete(param);
	}

	public void adattInsert(List<Object> param) {
		dao.adattInsert(param);
		
	}

	public void attNameUp(List<Object> param) {
		dao.attNameup(param);
	}

	public void attContentUp(List<Object> param) {
		dao.attContentUp(param);
	}

	public void attPersonUp(List<Object> param) {
		dao.attPersonUp(param);
	}

	public void attTimeUp(List<Object> param) {
		dao.attTimeUp(param);
	}

	public void attRunUp(List<Object> param) {
		dao.attRunUp(param);
	}

	public void attLocationUp(List<Object> param) {
		dao.attLocationUp(param);
	}

	public void attDelete(List<Object> param) {
		dao.attDelete(param);
	}

	public List<MemberVo> memList(List<Object> param) {
		return dao.memList(param);
	}

	public MemberVo admemDetail(int mem_no) {
		return dao.admemDetail(mem_no);
	}

	public void adMemPassUp(List<Object> param) {
		dao.adMemPassUp(param);
	}

	public void adMemNameUp(List<Object> param) {
		dao.adMemNameUp(param);
	}
	
	public void adMemNickUp(List<Object> param) {
		dao.adMemNickUp(param);
	}

	public void adMemDel(List<Object> param) {
		dao.adMemDel(param);
	}

}
