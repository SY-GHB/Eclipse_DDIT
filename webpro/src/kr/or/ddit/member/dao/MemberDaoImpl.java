package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.LprodVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ProdVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl instance = null;

	private MemberDaoImpl() {
	}

	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}

	@Override
	public String selectById(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


 
}
