package kr.or.ddit.jdbcBoardTest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.jdbcBoardTest.dao.BoardDaoImple;
import kr.or.ddit.jdbcBoardTest.dao.IBoardDao;
import kr.or.ddit.jdbcBoardTest.vo.BoardVO;

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
//		//조회수를 먼저 증가한 다음 게시글 정보를 가져온다.
//		if(countBoard(board_no) ==0) {
//			//조회수 올리기가 실패하면
//			return null;
//		};
		
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
