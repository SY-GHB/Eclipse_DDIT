package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

// JDBC 드라이버를 로딩하고 DB에 접속하여
// Connection객체를 반환하는 메서드로 구성된 class만들기 
// dbinfo.properties파일의 내용으로 설정하기
public class DBUtill3 {
	private static ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
	
	//클래스 초기화 블럭
	//생성자나 인스턴스 초기화 블록으로는 수행할 수 없는 클래스 변수의 초기화를 수행할 때 사용된다.
	static {
		try {
			Class.forName(bundle.getString("driver"));
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ㅠㅈㅠ");
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(bundle.getString("url"),
												bundle.getString("user"), bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB연결 실패 ㅠㅈㅠ");
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}
}
