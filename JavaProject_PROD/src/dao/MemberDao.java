package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

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
	
	public Map<String, Object> login(List<Object> param){ 
		String sql = " SELECT * FROM MEMBER\r\n " + 
				" WHERE ID = ? \r\n " + 
				" AND pass = ? ";
		
		
		return jdbc.selectOne(sql, param);
	}
}
