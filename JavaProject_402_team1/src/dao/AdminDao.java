package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.AdminVo;
import vo.MemberVo;
import vo.NoticeVo;

public class AdminDao {
	private static AdminDao instance = null;

	private AdminDao() {
	}

	public static AdminDao getInstance() {
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> adsellTicket() {
		String sql = "SELECT A.TICK_CODE,\r\n " + 
				"       A.TICK_NAME,\r\n " + 
				"       B.CART_QTY,\r\n " + 
				"       (B.CART_QTY*A.TICK_PRICE) AS SUM \r\n " + 
				"  FROM TICKET A, CART B\r\n " + 
				"  WHERE A.TICK_CODE=B.TICK_CODE ";
		 
		return jdbc.selectList(sql);
		
	}

	public Map<String, Object> adsellMonth(int yyyymm) {
		String sql = "SELECT SUBSTR(A.ORDER_NO, 1, 4)  AS YEAR,\r\n" + 
				"       SUBSTR(A.ORDER_NO, 5, 2) AS MON,\r\n" + 
				"       SUM (A.CART_QTY*B.TICK_PRICE)AS SUM\r\n" + 
				" FROM CART A, TICKET B\r\n" + 
				" WHERE A.TICK_CODE=B.TICK_CODE\r\n" + 
				"  AND SUBSTR(A.ORDER_NO, 1,6) LIKE '"+yyyymm+"'\r\n" + 
				" GROUP BY SUBSTR(A.ORDER_NO, 1, 4), SUBSTR(A.ORDER_NO, 5, 2)";
		return jdbc.selectOne(sql);
	}

	public Map<String, Object> adsellDate(int yyyymmdd) {
		String sql = "SELECT SUBSTR(A.ORDER_NO, 1, 4)  AS YEAR,\r\n " + 
				"       SUBSTR(A.ORDER_NO, 5, 2) AS MON,\r\n " + 
				"       SUBSTR(A.ORDER_NO, 7, 2) AS DAY,\r\n " + 
				"       SUM (A.CART_QTY*B.TICK_PRICE)AS SUM\r\n " + 
				" FROM CART A, TICKET B\r\n " + 
				" WHERE A.TICK_CODE=B.TICK_CODE\r\n " + 
				"  AND SUBSTR(A.ORDER_NO, 1,8) LIKE '"+yyyymmdd+"'\r\n" + 
				" GROUP BY SUBSTR(A.ORDER_NO, 1, 4), SUBSTR(A.ORDER_NO, 5, 2),\r\n " + 
				"         SUBSTR(A.ORDER_NO, 7, 2) ";
		return jdbc.selectOne(sql);
	}

	public List<NoticeVo> noticeList(List<Object> param) {
		String sql = " SELECT *\r\n" + 
				"FROM (SELECT ROWNUM NO, A.*\r\n" + 
				"            FROM (SELECT NOTI_NO,\r\n" + 
				"                        SUBSTR(NOTI_NAME,1,10) AS NOTI_NAME,\r\n" + 
				"                        SUBSTR(NOTI_CONTENT, 1, 20) AS NOTI_CONTENT,\r\n" + 
				"                        NOTI_COUNT,\r\n" + 
				"                        SUBSTR(TO_CHAR(NOTI_DATE), 1, 10) AS NOTI_DATE\r\n" + 
				"                     FROM NOTICE\r\n" + 
				"                     WHERE NOTI_DELYN = 'N'\r\n" + 
				"                     ORDER BY 1)A)\r\n" + 
				"WHERE NO BETWEEN ? AND ? ";
		
		return jdbc.selectList(sql, param, NoticeVo.class);
	}

	public NoticeVo noticeDetail(int board_no) {
		String sql = "SELECT NOTI_NO,\r\n" + 
				"       NOTI_NAME,\r\n" + 
				"       NOTI_CONTENT,\r\n" + 
				"       NOTI_COUNT,\r\n" + 
				"      SUBSTR(TO_CHAR(NOTI_DATE), 1, 10) AS NOTI_DATE\r\n" + 
				" FROM NOTICE\r\n" + 
				" WHERE NOTI_DELYN = 'N'\r\n" + 
				" AND NOTI_NO ="+board_no+
				" ORDER BY 1";
		
		
		return jdbc.selectOne(sql, NoticeVo.class);
	}

	
		//아직 미완성임!!!
	public void noticeInsert(List<Object> param) {
		String sql = "INSERT INTO NOTICE (NOTI_NO, ADMIN_NO, NOTI_NAME, NOTI_CONTENT)\r\n" + 
				"VALUES ((SELECT MAX(NOTI_NO)+1 FROM NOTICE), ?, ?, ?)";
		jdbc.update(sql, param);
	}

	public void noticeUpdate(List<Object> param, int board_no) {
		String sql = "UPDATE NOTICE \r\n" + 
				"SET NOTI_NAME = ? ,\r\n" + 
				"    NOTI_CONTENT = ? \r\n" + 
				"WHERE NOTI_NO ="+board_no;
		
		jdbc.update(sql, param);
		
	}

	public void noticeDelete(int board_no) {
		String sql = "UPDATE NOTICE \r\n" + 
				"SET NOTI_DELYN = 'Y'\r\n" + 
				"WHERE NOTI_NO ="+board_no;
		
		jdbc.update(sql);
	}

	public AdminVo adLogin(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				 "FROM ADMIN\r\n" + 
				 "WHERE ADMIN_ID = ? AND ADMIN_PASS = ?";
	
		return jdbc.selectOne(sql, param, AdminVo.class);
	}

	public void ticketInsert(List<Object> param) {
		String sql = "INSERT INTO TICKET(TICK_CODE, TICK_NAME, TICK_PRICE)\r\n" + 
				 "VALUES((SELECT MAX(TICK_CODE)+1\r\n" + 
				 "        FROM TICKET), ?, ?)";
		jdbc.update(sql, param);
	}

	public void ticNameUp(List<Object> param) {
		String sql = "UPDATE TICKET\r\n" + 
				 "SET TICK_NAME = ? \r\n" + 
				 "WHERE TICK_CODE = ?";
		jdbc.update(sql, param);
		
	}

	public void ticPriceUp(List<Object> param) {
		String sql = "UPDATE TICKET\r\n" + 
				 "SET TICK_PRICE = ? \r\n" + 
				 "WHERE TICK_CODE = ?";
		jdbc.update(sql, param);
	}

	public void ticketDelete(List<Object> param) {
		String sql = " UPDATE TICKET\r\n" + 
				 " SET TICK_DELYN = 'Y'\r\n" + 
				 " WHERE TICK_CODE = ?";
		jdbc.update(sql, param);
	}

	public void adattInsert(List<Object> param) {
		String sql = "INSERT INTO ATTRACTION(ATT_NO,ATT_NAME,ATT_CONTENT,ATT_PERSON,ATT_LOCATION,ATT_SPENTTIME,ATT_RUNYN)\r\n" + 
			   	"     VALUES((SELECT MAX(ATT_NO)+1\r\n" + 
				"     FROM ATTRACTION), ?, ?, ?, ?, ?, ?)";
		jdbc.update(sql, param);
	}
	
	public void attNameup(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
				     "SET ATT_NAME = ? \r\n" + 
					 "WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}

	public void attContentUp(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
					 "SET ATT_CONTENT = ? \r\n" + 
					 "WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}

	public void attPersonUp(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
				 	 "SET ATT_PERSON = ? \r\n" + 
				 	 "WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}

	public void attTimeUp(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
					 "SET ATT_SPENTTIME = ? \r\n" + 
					 "WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}

	public void attRunUp(List<Object> param) {
		String sql = " UPDATE ATTRACTION \r\n" + 
					 " SET ATT_RUNYN = ? \r\n" + 
					 " WHERE ATT_NO = ? ";
		jdbc.update(sql, param);
	}

	public void attLocationUp(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
				 	 "SET ATT_LOCATION = ? \r\n" + 
				 	 "WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}

	public void attDelete(List<Object> param) {
		String sql = "UPDATE ATTRACTION\r\n" + 
				 "    SET ATT_DELYN = 'Y'\r\n" + 
			   	"     WHERE ATT_NO = ?";
		jdbc.update(sql, param);
	}
	
	public List<MemberVo> memList(List<Object> param) {
		String sql = " select *  \r\n" + 
				"    from (SELECT ROWNUM RN, A.MEM_NO,A.MEM_ID,A.MEM_PASS,A.MEM_NAME,A.MEM_NICK \r\n" + 
				"          FROM(select MEM_NO,MEM_ID,MEM_PASS,MEM_NAME,MEM_NICK\r\n" + 
				"               from MEMBER\r\n" + 
				"               where MEM_DELYN = 'N'\r\n" + 
				"               order by 1) A)\r\n" + 
				"          WHERE RN BETWEEN ? AND ?";
		return jdbc.selectList(sql, param, MemberVo.class);
	}

	public MemberVo admemDetail(int mem_no) {
		String sql = "SELECT MEM_NO,MEM_ID,MEM_PASS,MEM_NAME,MEM_NICK\r\n" + 
				"     FROM MEMBER\r\n" + 
				"     WHERE MEM_NO = "+mem_no;
		return jdbc.selectOne(sql, MemberVo.class);
	}

	public void adMemPassUp(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
					 "SET MEM_PASS = ?\r\n" + 
					 "WHERE MEM_NO = ?";
		jdbc.update(sql, param);
	}

	public void adMemNameUp(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
					 "SET MEM_NAME = ?\r\n" + 
					 "WHERE MEM_NO = ?";
		jdbc.update(sql, param);
	}

	public void adMemNickUp(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
					 "SET MEM_NICK = ?\r\n" + 
					 "WHERE MEM_NO = ?";
		jdbc.update(sql, param);
	}

	public void adMemDel(List<Object> param) {
		String sql = "UPDATE MEMBER\r\n" + 
					 "SET MEM_DELYN = 'Y'\r\n" + 
					 "WHERE MEM_NO = ?";
		jdbc.update(sql, param);
	}

}
