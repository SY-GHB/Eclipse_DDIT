package service;

import java.util.List;
import java.util.Map;

import controller.AttractionController;
import dao.AttractionDao;
import vo.AttractionVo;
import vo.PlayVo;
import vo.UserVo;

public class AttractionService {
	private static AttractionService instance = null;

	private AttractionService() {
	}

	public static AttractionService getInstance() {
		if (instance == null) {
			instance = new AttractionService();
		}
		return instance;
	}
	
	AttractionDao dao = AttractionDao.getInstance();

	public List<AttractionVo> attList(List<Object> param) {
		return dao.attList(param);
	}

	public AttractionVo attDetail(int board_no) {
		return dao.attDetail(board_no);
	}

	public boolean attReserv(List<Object> param) {
		UserVo att = dao.attReserv(param);
		
		if(att != null) {
			AttractionController.sessionStorage .put("atttick", att);
			return true;
		}
		return false;
	}

	public void playInsert(List<Object> paramm) {
		dao.playInsert(paramm);
	}

	public List<AttractionVo> attBest() {
		return dao.attBest();
	}

	public List<AttractionVo> atList() {
		return dao.atList();
	}

	
}