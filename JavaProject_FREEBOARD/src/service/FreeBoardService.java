package service;

import java.util.List;

import dao.FreeBoardDao;
import vo.FreeBoardVo;

public class FreeBoardService {
	private static FreeBoardService instance = null;

	private FreeBoardService() {
	}

	public static FreeBoardService getInstance() {
		if (instance == null) {
			instance = new FreeBoardService();
		}
		return instance;
	}
	
	 FreeBoardDao dao = FreeBoardDao.getInstance();
	
	public List<FreeBoardVo> freeList(List<Object> param) {
		return dao.freeList(param);
	}

	public FreeBoardVo freeDetail(int board_no) {
		return dao.freeDeatil(board_no);
		
	}

	public void freeDelete(int board_no) {
		dao.freeDelete(board_no);
		
	}

	public void freeUpdate(List<Object> param, int board_no) {
		dao.freeUpdate(param, board_no);
		
	}
}
