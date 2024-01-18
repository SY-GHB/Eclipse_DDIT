package kr.or.ddit.jdbcBoardTest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.jdbcBoardTest.vo.BoardVO;

public interface IBoardService {
	/**
	 * BoardVO객체에 담긴 내용을 insert하는 메소드
	 * @param bv DB에 저장할 게시판 내용이 담긴 BoardVO객체
	 * @return 작업성공 1 작업실패 0
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 게시판의 모든 글을 글번호, 제목, 작성자, 조회수만 보여주는 메소드
	 * @return 한 행(BoardVO)이 담긴 List
	 */
	public List<BoardVO> allBoard();
	
	/**
	 * 게시판 번호를 입력받아 해당 번호의 게시판 내용을 상세히 보여주는 메소드
	 * 제목, 작성자, 내용, 작성일, 조회수를 보여줄 것.
	 * @param board_no 보고싶은 게시판의 번호
	 * @return 한 행, 즉 게시글 1개의 BoardVO
	 */
	public BoardVO detailBoard(int board_no);
	
	/**
	 * detailBoard에서 선택된 게시글에서 제목과 내용만 수정하는 메소드
	 * @param board_no 선택된 게시글의 번호.
	 * @param map 제목과 내용의 컬럼명을 key로 갖고 수정된 내용을 value로 갖는 map
	 * @return 작업성공 1 작업실패 0
	 */
	public int updateBoard(int board_no, Map<String, String> map);
	
	
	/**
	 * detailBoard에서 선택된 게시글을 삭제하는 메소드
	 * @param board_no 선택된 게시글의 번호
	 * @return 작업성공 1 작업실패 0
	 */
	public int deleteBoard(int board_no);
	
	
	/**
	 * 제목에 검색 키워드를 포함하고 있는 게시글을 찾아내어 간략하게 보여주는 메소드
	 * @param data 검색 키워드
	 * @return 제목에 키워드가 포함된 게시글(BoardVO)이 모인 List
	 */
	public List<BoardVO> searchBoard(String data);
	
	/**
	 *  상세정보를 조회한 게시글의 조회수를 올리는 메소드
	 * @param board_no 상세정보를 조회할 게시글의 번호
	 * @return 작업성공1 작업실패 0
	 */
	public int countBoard(int board_no);
}
