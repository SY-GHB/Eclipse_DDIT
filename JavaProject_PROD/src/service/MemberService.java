package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.MemberDao;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	//서비스랑 dao랑 연결됐다.
	MemberDao dao = MemberDao.getInstance();
	
	public boolean login(List<Object> param) {
	
		/*
		 * 로그인 시도를 했을 때 데이터가 있다면 로그인 성공,
		 * 데이터가 없다면 로그인 실패.
		 * 로그인 데이터가 맵이죠
		 */
		
		Map<String, Object> member = dao.login(param);
		
		//맵 데이터가 null이 아니면(아이디/비번 정보가 있다면) 로그인이 성공한것이다.
		if(member !=null) {
			
			MainController.sessionStorage.put("login", member);
			return true;
		}

		return false;
		
	}
}
