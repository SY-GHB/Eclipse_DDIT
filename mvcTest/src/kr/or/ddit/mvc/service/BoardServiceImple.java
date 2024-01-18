package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.BoardDaoImple;
import kr.or.ddit.mvc.dao.IBoardDao;
import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImple;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardServiceImple implements IBoardService {
	private IBoardDao dao;
	
	private static BoardServiceImple servImple;
	
	private BoardServiceImple() {
		dao = BoardDaoImple.getInstance();
	}
	
	public static BoardServiceImple getInstance() {
		if(servImple==null) {
			servImple = new BoardServiceImple();
		}
		return servImple;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		
		return dao.insertBoard(bv);
	}

	@Override
	public List<BoardVO> allBoard() {
		
		return dao.allBoard();
	}

	@Override
	public BoardVO detailBoard(int board_no) {
		
		return dao.detailBoard(board_no);
	}

	@Override
	public int updateBoard(int board_no, Map<String, String> map) {
		
		return dao.updateBoard(board_no, map);
	}

	@Override
	public int deleteBoard(int board_no) {
		
		return dao.deleteBoard(board_no);
	}

	@Override
	public List<BoardVO> searchBoard(String data) {
		
		return dao.searchBoard(data);
	}

	@Override
	public int countBoard(int board_no) {
		
		return dao.countBoard(board_no);
	}

}
