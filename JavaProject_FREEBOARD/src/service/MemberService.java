package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.MemberVo;

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
	
	MemberDao dao = MemberDao.getInstance();
	
	public boolean login(List<Object> params) {
		MemberVo mem = dao.login(params);
		
		if(mem != null) {
			MainController.sessionStorage.put("member", mem);
			return true;
		}
		
		return false;
	}
}
