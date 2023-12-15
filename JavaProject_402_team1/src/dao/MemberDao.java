package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.MemberVo;
import vo.OrderVo;
import vo.TicketVo;

public class MemberDao {
	private static MemberDao instance = null;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public MemberVo memLogin(List<Object> param) {
		String sql = "SELECT * FROM MEMBER\r\n" + 
				"WHERE MEM_ID = ?"
				+ "AND MEM_PASS = ?"
				+ "AND MEM_DELYN = 'N' ";
		return jdbc.selectOne(sql, param, MemberVo.class);
	}

	public void updatePass(List<Object> param) {
		String sql = " UPDATE MEMBER\r\n " + 
				"    SET MEM_PASS = ? \r\n" + 
				"    WHERE MEM_ID = ? ";
		
		jdbc.update(sql, param);
	}

	public void updateName(List<Object> param) {
		String sql = " UPDATE MEMBER\r\n " + 
				"    SET MEM_NAME = ? \r\n" + 
				"    WHERE MEM_ID = ? ";
		jdbc.update(sql, param);
	}

	public void updateNick(List<Object> param) {
		String sql = " UPDATE MEMBER\r\n " + 
				"    SET MEM_NICK = ? \r\n" + 
				"    WHERE MEM_ID = ? ";
		jdbc.update(sql, param);
	}

	public void memOut(String mem_id) {
		String sql = "UPDATE MEMBER\r\n" + 
				"    SET MEM_DELYN = 'Y'\r\n" + 
				"    WHERE MEM_ID = '" + mem_id +"'";
		jdbc.update(sql);
		
	}

	public List<Map<String, Object>> getOrderNo(int mem_no) {
		String sql = "select order_no from order_\r\n" + 
				"where mem_no =" + mem_no ;
		
		return jdbc.selectList(sql);
	}

	public Map<String, Object> buyTicketList(String order_no) {
		String sql = "SELECT USER_NO, TO_CHAR(USER_DATE, 'YYYY/MM/DD') AS USER_DATE, TICK_NAME\r\n " + 
				" FROM USER_ A, TICKET B\r\n " + 
				" WHERE A.TICK_CODE = B.TICK_CODE\r\n " + 
				"      AND ORDER_NO = '" + order_no + "'" + 
				" ORDER BY 1 ";
		
		return (Map<String, Object>) jdbc.selectOne(sql);
	}

	public void memSignup(List<Object> param) {
		String sql = "INSERT INTO MEMBER\r\n" + 
				" VALUES ((SELECT MAX(MEM_NO)+1 FROM MEMBER),\r\n" + 
				"        ?, ?, ?, ?, 'N')";
		
		jdbc.update(sql, param);
		
	}

	
}
