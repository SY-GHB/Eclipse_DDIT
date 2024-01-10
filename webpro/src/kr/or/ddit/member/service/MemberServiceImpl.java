package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService{
	
	private static MemberServiceImpl instance = null;

	private MemberServiceImpl() {
	}

	public static MemberServiceImpl getInstance() {
		if (instance == null) {
			instance = new MemberServiceImpl();
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
