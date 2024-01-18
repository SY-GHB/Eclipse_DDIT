package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메소드를 원하는 작업에 맞게 호출하여
 * 실행 결과를 받아오고, 받아온 결과를 Controller에 전달하는 역할.
 *
 * 우리 시간(자바 고급)에는 일단 DAO의 interface와 구조가 같게 만든다. -만들기젤쉬움,,,
 */
public interface IMemberService {
		
		/**
		 * MemberVO객체에 담겨진 자료를 insert하는 메서드
		 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
		 * @return 작업성공: 1, 작업실패: 0
		 */
		public int insertMember(MemberVO memVo);

		
		/**
		 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
		 * @param mem_id 삭제할 회원ID
		 * @return 작업성공: 1, 작업실패: 0
		 */
		public int deleteMember(String mem_id);
		
		
		/**
		 * MemberVo객체 자료를 이용하여 해당 회원의 정보를 수정하는 메서드.
		 * @param memVo
		 * @return 작업성공: 1, 작업실패: 0
		 */
		public int updateMember(MemberVO memVo);
		
		/**
		 * Map의 정보를 이dyd하여 회원정보 중 원하는 컬럼을 수정하는 메소드
		 * key정보 ==> 회원ID(mem_id), 수정할 컬럼명(fieldName), 수정할데이터(data)
		 * 
		 * @param map 회원id, 수정할컬럼명, 수정할 데이터가 저장된 map객체
		 * @return 작업성공:1, 작업실패: 0
		 */
		public int updateMember2(Map<String, String> map);
		
		/**
		 * 매개변수 없이 모든 회원의 정보를 읽어오는 메서드
		 * @return MemberVO객체가 저장된 List객체
		 */
		public List<MemberVO> getAllMember();
		
		/**
		 * ID를 매개변수로 받아 해당 아이디가 몇 개 있는지 읽어오는 메소드
		 * @param mem_id 검사할 회원ID
		 * @return 기존에 존재하는(검색된) ID갯수
		 */
		public int countID(String mem_id);
}
