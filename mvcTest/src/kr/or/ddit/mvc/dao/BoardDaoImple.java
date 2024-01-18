package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtill3;

public class BoardDaoImple implements IBoardDao {
	private static BoardDaoImple dao;
	
	private BoardDaoImple() {
		
	}
	
	public static BoardDaoImple getInstance() {
		if(dao==null) {
			dao = new BoardDaoImple();
		}
		
		return dao;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into jdbc_board\r\n" + 
				"(BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT)\r\n" + 
				"values (BOARD_SEQ.nextval, ?, ?, ?)";
		
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_writer());
			pstmt.setString(3, bv.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> allBoard() {
		List<BoardVO> bList= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBUtill3.getConnection();
			String sql = "select * from jdbc_board order by BOARD_NO ASC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			bList = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setBoard_no(rs.getInt("Board_no"));
				bv.setBoard_title(rs.getString("Board_title"));
				bv.setBoard_writer(rs.getString("board_writer"));
				bv.setBoard_date(rs.getString("Board_date"));
				bv.setBoard_cnt(rs.getInt("Board_cnt"));
				bv.setBoard_content(rs.getString("Board_content"));
				
				bList.add(bv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
			if(rs!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return bList;
	}

	@Override
	public BoardVO detailBoard(int board_no) {
		
		BoardVO bv = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from jdbc_board where board_no=?";
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
			bv = new BoardVO();
			rs = pstmt.executeQuery();
			
//			rs.next();	//rs가 빈 곳을 가리키고 있기 때문에 한칸 내려가준다.
			//아니면 있는만큼만 내보내라는 의미로 이렇게 해줘도 된다.
			while(rs.next()) {
				bv.setBoard_no(rs.getInt("Board_no"));
				bv.setBoard_title(rs.getString("Board_title"));
				bv.setBoard_writer(rs.getString("board_writer"));
				bv.setBoard_date(rs.getString("Board_date").substring(0, 10));
				bv.setBoard_cnt(rs.getInt("Board_cnt"));
				bv.setBoard_content(rs.getString("Board_content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
			if(rs!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return bv;
	}

	@Override
	//어차피 vo안에도 board_no가 잇기때문에 매개변수를 두개줄것없이 그냥 VO로 받아와도된다.
	public int updateBoard(int board_no, Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update JDBC_BOARD set BOARD_TITLE = ? ,\r\n" + 
				"BOARD_CONTENT = ? where board_no = ?";
		
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, map.get("board_title"));
			pstmt.setString(2, map.get("board_content"));
			pstmt.setInt(3, board_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int board_no) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from JDBC_BOARD where board_no = ?";
		
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> searchBoard(String data) {
		
		List<BoardVO> bList= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from JDBC_BOARD where BOARD_TITLE like ?";
		data = "%"+data+"%";
		
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);
			
			rs = pstmt.executeQuery();
			bList = new ArrayList<BoardVO>();
			while(rs.next()) {
				
				BoardVO bv = new BoardVO();
				bv.setBoard_no(rs.getInt("Board_no"));
				bv.setBoard_title(rs.getString("Board_title"));
				bv.setBoard_writer(rs.getString("board_writer"));
				bv.setBoard_date(rs.getString("Board_date"));
				bv.setBoard_cnt(rs.getInt("Board_cnt"));
				bv.setBoard_content(rs.getString("Board_content"));
				
				bList.add(bv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
			if(rs!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return bList;
	}

	@Override
	public int countBoard(int board_no) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// set BOARD_cnt = BOARD_cnt+1로 만들수도 있다.
		String sql = "update JDBC_BOARD\r\n" + 
				"set BOARD_cnt = (select BOARD_cnt from jdbc_board where board_no = ?)+1\r\n" + 
				"where board_no=?";
		
		try {
			conn = DBUtill3.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board_no);
			pstmt.setInt(2, board_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return cnt;
	}
}
