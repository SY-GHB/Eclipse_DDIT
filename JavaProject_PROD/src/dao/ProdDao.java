package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ProdDao { // 테이블이 달라지게 되면 클래스가 새로 만들어진다.
	private static ProdDao instance = null;

	private ProdDao() {
	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}

		JDBCUtil jdbc = JDBCUtil.getInstance();
		
		public List<Map<String, Object>> prodList() {
			String sql = " SELECT * FROM PROD \r\n ";
			return jdbc.selectList(sql);
		}

		public List<Map<String, Object>> prodTypeSearch(String type) {
			//1.
//			String format = " SELECT * FROM PROD\r\n " + 
//						 " WHERE TYPE = '%s' ";
//			String sql = String.format(format, type);
//			
//			jdbc.selectList(sql);
			
//			//2. 파라미터가 하나일 때는 1, 2번 방식이 편하겠다.
//			String format = " SELECT * FROM PROD\r\n " + 
//						 " WHERE TYPE ='"+type+"'";
//			jdbc.selectList(sql);
			
			
			//3. 파라미터가 여러개일때는 이게 편하겠지만.
			String sql = " SELECT * FROM PROD\r\n " + 
					 " 	   WHERE TYPE =? ";
			List<Object> param = new ArrayList();
			param.add(type);
			return jdbc.selectList(sql, param);
			
		
		}

		public List<Map<String, Object>> prodNameSearch(String name) {
			String sql = " SELECT * FROM PROD\r\n " + 
						 " WHERE NAME LIKE '%'||?||'%' ";
			List<Object> param = new ArrayList();
			param.add(name);
			
			return jdbc.selectList(sql, param);
			
		}

		public void prodSale(List<Object> param) {
			String sql = " update prod\r\n " + 
						 " set count = (select count -?\r\n " + 
						 "                from prod\r\n " + 
						 "                where no= ?\r\n " + 
						 "                )\r\n " + 
						 " where no = ? ";
			
			
			jdbc.update(sql, param);
		}
	
}
