package dao;

import java.util.List;

import util.JDBCUtil;
import vo.FreeBoardVo;

public class FreeBoardDao {
	private static FreeBoardDao instance = null;

	private FreeBoardDao() {
	}

	public static FreeBoardDao getInstance() {
		if (instance == null) {
			instance = new FreeBoardDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<FreeBoardVo> freeList(List<Object> param) {
		 String sql = " SELECT *\r\n" + 
		 		" FROM \r\n" + 
		 		"     (SELECT ROWNUM RN, A.*\r\n " + 
		 		"     FROM (SELECT BOARD_NO, TITLE, CONTENT, F.MEM_NO,\r\n " + 
		 		"            TO_CHAR(WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE,\r\n " + 
		 		"            COUNT, M.NAME SPARE1\r\n " + 
		 		"     FROM FREE_BOARD2 F, MEMBER_BOARD M\r\n " + 
		 		"     WHERE F.MEM_NO = M.MEM_NO\r\n "
		 		+ "		AND F.DEL_YN = 'N'" + 
		 		"     ORDER BY 1) A)\r\n " + 
		 		" WHERE RN BETWEEN ? AND ? ";
		 
		 return jdbc.selectList(sql, param, FreeBoardVo.class);
	}

	public FreeBoardVo freeDeatil(int board_no) {
		String sql = " SELECT BOARD_NO, TITLE, CONTENT, F.MEM_NO,\r\n" + 
				"        TO_CHAR(WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE,\r\n" + 
				"        COUNT, M.NAME SPARE1\r\n" + 
				"FROM FREE_BOARD2 F,  MEMBER_BOARD M\r\n" + 
				"WHERE F.MEM_NO = M.MEM_NO\r\n" + 
				"  AND  BOARD_NO= " + board_no;
	
		
		return jdbc.selectOne(sql, FreeBoardVo.class);
	}

	public void freeDelete(int board_no) {
		String sql = " Update free_board2 "
				+ " set del_yn = 'Y' "
				+ " where board_no = " + board_no;
		
		jdbc.update(sql);
		
	}

	public void freeUpdate(List<Object> param, int board_no) {
		// ? 를 넣으면 메인컨트롤러에서 보내줄 파라미터를 받을 공간이 있어야 한다. 
		String sql = " UPDATE FREE_BOARD2\r\n " + 
				" SET TITLE = ?,\r\n" + 
				"    CONTENT = ? \r\n" + 
				" WHERE BOARD_NO = " + board_no;
		
		jdbc.update(sql, param);
		
	}
}
