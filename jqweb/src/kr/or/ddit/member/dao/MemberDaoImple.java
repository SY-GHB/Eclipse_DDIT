package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.DBUtill3;

public class MemberDaoImple implements IMemberDao {
	
	
	
	//DB에 접근하기 위한 객체, Data access object DAO
	//DB접근 실행 설정
	private Connection conn = null;	
	private PreparedStatement pstmst;
	private ResultSet rs;
			
	//싱글톤 선언
	private static IMemberDao dao;
	
	private MemberDaoImple(){
		
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDaoImple();
		}
		return dao;
	}
	
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> mList= null;
		String sql = "select * from member";
		
		try {
			conn = DBUtill3.getConnection();
			pstmst = conn.prepareStatement(sql);
			//rs:커서위치
			rs = pstmst.executeQuery();
			mList = new ArrayList<MemberVO>();
			
			while(rs.next()) {
				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_pass(rs.getString("mem_pass"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_bir(rs.getString("mem_bir"));
				mv.setMem_zip(rs.getString("mem_zip"));
				mv.setMem_add1(rs.getString("mem_add1"));
				mv.setMem_add2(rs.getString("mem_add2"));
				mv.setMem_hp(rs.getString("mem_hp"));
				mv.setMem_mail(rs.getString("mem_mail"));
				
				mList.add(mv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmst!=null) try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(rs!=null) try {conn.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		return mList;
	}

}
