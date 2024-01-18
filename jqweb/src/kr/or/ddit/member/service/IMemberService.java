package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {
	
	//전체 리스트가져오기
	public List<MemberVO> getAllMember();
}
