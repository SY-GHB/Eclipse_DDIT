package dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.OrderVo;
import vo.TicketVo;

public class TicketDao {
	private static TicketDao instance = null;

	private TicketDao() {
	}

	public static TicketDao getInstance() {
		if (instance == null) {
			instance = new TicketDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	

	public Map<String, Object> callOrder_no(String mem_id) {
		String sql = "SELECT FN_CREATE_ORDER_NO(SYSDATE,'"+mem_id+"')"
				+ "	  AS ORDER_NO FROM DUAL";
		return jdbc.selectOne(sql);
	}
	
	public List<TicketVo> ticketList() {
		String sql = "SELECT TICK_CODE,\r\n" + 
				"       TICK_NAME,TICK_PRICE\r\n" + 
				"    FROM TICKET\r\n" + 
				"    WHERE TICK_DELYN = 'N'"
				+ "  ORDER BY 1";
		
		return jdbc.selectList(sql, TicketVo.class);
	}
	
	
	public List<OrderVo> orderList(){
		String sql = "SELECT  ORDER_NO, MEM_NO,\r\n" + 
				"        ORDER_SUMPRICE, ORDER_DATE\r\n" + 
				"		 FROM ORDER_";
		
		return jdbc.selectList(sql, OrderVo.class);
	}
	

	public TicketVo ticketDetail(int tick_code) {
		String sql = "SELCET * FROM TICKET WHERE TICK_CODE = " + tick_code;
		
		return jdbc.selectOne(sql, TicketVo.class);
	}

	public void insertOrder(List<Object> param) {
		String sql = "INSERT INTO ORDER_\r\n"
				+ " (ORDER_NO, ORDER_SUMPRICE, MEM_NO) " + 
				" VALUES (? , ?, ?) ";
		
		jdbc.update(sql, param);
	}

	public void insertCart(List<Object> param){
		String sql = "INSERT INTO CART\r\n" + 
				"	  VALUES (?, ?, ?)";
		
		jdbc.update(sql,param);
	}
	
	public Map<String, Object> callUser_no(List<Object> userNo) {
		String sql = "SELECT FN_CREATE_USER_NO(TO_DATE(?, 'YYMMDD'), ?)"
				+ "	  AS USER_NO FROM DUAL";
		return jdbc.selectOne(sql, userNo);
	}

	public void inserUser(List<Object> param) {
		String sql = "INSERT INTO USER_\r\n" + 
				"VALUES (?, TO_DATE(?, 'YYMMDD'), ?, ?)";
		
		jdbc.update(sql, param);
	}
}



