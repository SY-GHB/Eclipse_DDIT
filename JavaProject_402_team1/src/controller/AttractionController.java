package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import util.ScanUtil;
import util.View;
import vo.AttractionVo;
import vo.MemberVo;
import service.AttractionService;

public class AttractionController extends Print {
	AttractionService attService = AttractionService.getInstance();
	static public Map<String, Object> sessionStorage = MainController.sessionStorage;

	/*
	 * 놀이기구 전체 리스트
	 */
	public View attList() {

		List<Object> param = new ArrayList();
		int page_no = 1;
		if (sessionStorage.containsKey("page_no")) {
			page_no = (int) sessionStorage.get("page_no");
		}
		int start_no = 1 + 5 * (page_no - 1);
		int end_no = 5 + 5 * (page_no - 1);
		param.add(start_no);
		param.add(end_no);

		printVar();
		List<AttractionVo> attList = attService.attList(param);
		System.out.println("번호\t이름\t 내용\t\t탑승인원\t위치\t\t소요시간\t운영여부");
		printVar();
		for (AttractionVo att : attList) {
			int no = att.getAtt_no();
			String name = att.getAtt_name();
			String content = att.getAtt_content();
			int person = att.getAtt_person();
			String location = att.getAtt_location();
			String time = att.getAtt_spenttime();
			String run = att.getAtt_runyn();
			System.out.println(no + "\t" + name + "\t" + content + "\t" + person + "\t" + location + "\t" + time + "\t"
					+ run);
		}
		printVar();
		printAttListMenu();
		
		int page = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (page) {
		case 1:
			sessionStorage.put("page_no", page_no-1);
			return View.ATT_LIST;
		case 2:
			sessionStorage.put("page_no", page_no+1);
			return View.ATT_LIST;
		case 3:
			int board_no = ScanUtil.nextInt("조회할 놀이기구 번호를 입력하세요: ");
			sessionStorage.put("board_no", board_no);
			return View.ATT_DETAIL;
		default:
			printErr();
			return View.MAIN;
		}
	}

	/*
	 * 놀이기구 상세페이지
	 */
	public View attDetail() {

		int board_no = (int) sessionStorage.get("board_no");
		AttractionVo att = attService.attDetail(board_no);
		int no = att.getAtt_no();
		String name = att.getAtt_name();
		String content = att.getAtt_content();
		int person = att.getAtt_person();
		String location = att.getAtt_location();
		String time = att.getAtt_spenttime();
		String run = att.getAtt_runyn();
		
		System.out.println("번호\t이름\t\t탑승인원\t위치\t\t소요시간\t운영여부");
		printVar();
		System.out.println(no + "\t" + name + "\t\t" + person + "\t" + location + "\t" + time + "\t" + run);
		printVar();
		System.out.println(content);

		printAttDetailMenu();
		
		int sel = ScanUtil.nextInt("메뉴를 선택해 주세요: ");
		switch (sel) {
		case 1:
			return View.ATT_LIST;
		case 2:
			return View.MAIN;
		default:
			return View.ATT_DETAIL;
		}
	}

}
