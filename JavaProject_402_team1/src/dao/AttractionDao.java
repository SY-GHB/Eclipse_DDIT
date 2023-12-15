package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.AttractionVo;
import vo.PlayVo;
import vo.UserVo;

public class AttractionDao {
	private static AttractionDao instance = null;

	private AttractionDao() {
	}

	public static AttractionDao getInstance() {
		if (instance == null) {
			instance = new AttractionDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<AttractionVo> attList(List<Object> param) {
		String sql = "select  *\r\n" + 
				"from (SELECT ROWNUM RN, A.ATT_NO,SUBSTR(A.ATT_NAME,1,5) AS ATT_NAME,SUBSTR(A.ATT_CONTENT,1,10) AS ATT_CONTENT,A.ATT_PERSON, SUBSTR(A.ATT_LOCATION,1,10) AS ATT_LOCATION,A.ATT_SPENTTIME,A.ATT_RUNYN\r\n" + 
				"        FROM(select ATT_NO,ATT_NAME, ATT_CONTENT,ATT_PERSON, ATT_LOCATION,ATT_SPENTTIME,ATT_RUNYN\r\n" + 
				"               from ATTRACTION\r\n" + 
				"              where ATT_DELYN = 'N'\r\n" + 
				"              order by 1) A)\r\n" + 
				"	WHERE RN BETWEEN ? AND ?";
		return jdbc.selectList(sql, param,AttractionVo.class);
	}

	public AttractionVo attDetail(int board_no) {
		String sql = "SELECT ATT_NO, ATT_NAME,\r\n" + 
				"            ATT_CONTENT, ATT_PERSON,"
				+ "			ATT_LOCATION, ATT_SPENTTIME,ATT_RUNYN\r\n" + 
				"FROM ATTRACTION\r\n" + 
				"WHERE ATT_NO = "+board_no;
		return jdbc.selectOne(sql, AttractionVo.class);
	}

	public UserVo attReserv(List<Object> param) {
		String sql = "SELECT *\r\n" + 
					 "FROM USER_\r\n" + 
					 "WHERE USER_NO = ?";
		return jdbc.selectOne(sql, param, UserVo.class);
	}

	public void playInsert(List<Object> paramm) {
		String sql = "INSERT INTO PLAY(USER_NO, ATT_NO, PLAY_YN)\r\n" + 
					 "VALUES(?,?,?)";
		jdbc.update(sql, paramm);
	}

	public List<AttractionVo> attBest() {
		String sql = "SELECT A.ATT_NO, SUBSTR(A.ATT_NAME,1,5) AS ATT_NAME, SUBSTR(A.ATT_CONTENT,1,10) AS ATT_CONTENT , A.ATT_PERSON,\r\n" + 
				     "       SUBSTR(A.ATT_LOCATION,1,10) AS ATT_LOCATION, A.ATT_SPENTTIME, A.ATT_RUNYN \r\n" + 
				     "FROM ATTRACTION A, (SELECT COUNT(USER_NO) AS CUSER ,ATT_NO AS  ATN\r\n" + 
				     "                    FROM PLAY\r\n" + 
				     "                    GROUP BY ATT_NO\r\n" + 
				     "                    ORDER BY 1 DESC) B\r\n" + 
				     "WHERE A.ATT_NO = B.ATN\r\n" + 
				     "AND ROWNUM BETWEEN 1 AND 3";
		return jdbc.selectList(sql, AttractionVo.class);
	}

	public List<AttractionVo> atList() {
		String sql = "SELECT ATT_NO, SUBSTR(ATT_NAME,1,5) AS ATT_NAME, SUBSTR(ATT_CONTENT,1,10) AS ATT_CONTENT,\r\n" + 
				"     ATT_PERSON, SUBSTR(ATT_LOCATION,1,10) AS ATT_LOCATION, ATT_SPENTTIME,\r\n" + 
				"     ATT_RUNYN\r\n" + 
				"     FROM   ATTRACTION";
		return jdbc.selectList(sql, AttractionVo.class);
	}
}
