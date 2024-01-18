package kr.or.ddit.jdbcBoardTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.jdbcBoardTest.service.BoardServiceImple;
import kr.or.ddit.jdbcBoardTest.service.IBoardService;
import kr.or.ddit.jdbcBoardTest.vo.BoardVO;

public class BoardController {
	private Scanner sc;
	private IBoardService service;
	private Map<String, Integer> sessionstorage;
	boolean chk = false;
	
	public BoardController() {
		//new Map<>으로 구현못함. Map은 interface
		sessionstorage = new HashMap<String, Integer>();
		sc = new Scanner(System.in);
		service = BoardServiceImple.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().startBoard();
	}
	
	public int printMenu() {
		System.out.println("1. 새글작성    2. 게시글보기    3. 검색    0. 프로그램 종료");
		System.out.println();
		System.out.println("작업선택 >> ");
		int sel = sc.nextInt();
		sc.nextLine(); //버퍼비우기
		
		return sel;
	}

	public void startBoard() {
		while(true) {
			if(!chk) {
				System.out.println("*****메인페이지입니다.*****");
				allBoard();
			}
			chk = false;
			switch (printMenu()) {
			case 1:
				insertBoard();
				break;
			case 2:
				detailBoard();
				break;
			case 3:
				searchBoard();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println();
				break;
			}
		}
	}

	private void allBoard() {
		List<BoardVO> bList = service.allBoard();
		System.out.println("─────────────────────────────────────────────");
		System.out.println("No\t제목\t\t작성자\t\t조회수");
		System.out.println("─────────────────────────────────────────────");
		if(bList.isEmpty()) {
			System.out.println("\t작성된 게시글이 없습니다.");
		}else {
			for (BoardVO bv : bList) {
				System.out.println(bv.getBoard_no()+"\t"+bv.getBoard_title()+"\t"
						+bv.getBoard_writer()+"\t"+bv.getBoard_cnt());
			}
		}
		System.out.println("─────────────────────────────────────────────");
		System.out.println();
		
	}

	private void insertBoard() {
		BoardVO bv = new BoardVO();
		System.out.println("새 글의 제목 입력 >> ");
		String title = sc.nextLine();
		System.out.println("새 글의 작성자 입력 >> ");
		String writer = sc.nextLine();
		System.out.println("새 글의 내용 입력 >> ");
		String content = sc.nextLine();
		
		bv.setBoard_title(title);
		bv.setBoard_writer(writer);
		bv.setBoard_content(content);
		
		int cnt = service.insertBoard(bv);
		if(cnt>0) System.out.println("새 글 작성에 성공하였습니다.");
		else System.out.println("ERROR!");
		
	}

	private void detailBoard() {
		System.out.println("상세보기를 원하는 게시물 번호 입력 >> ");
		int board_no = sc.nextInt();
		sc.nextLine();
		
		sessionstorage.put("board_no", board_no);
		
		//조회수 올리기 - 원래는 service단에서 실행
		service.countBoard(board_no);
		
		BoardVO bv = service.detailBoard(board_no);
		System.out.println("─────────────────────────────────────────────");
		if(bv.getBoard_no()==0) {
			System.out.println();
			System.out.println("\t없는 게시글 번호입니다.");
			System.out.println();
			
		}else {
			System.out.println("작성일 : " + bv.getBoard_date() + "\t조회수 : " + bv.getBoard_cnt());
			System.out.println("제목 : " + bv.getBoard_title()+ "\t작성자 : " + bv.getBoard_writer());
			System.out.println("─────────────────────────────────────────────");
			System.out.println("  내용 ");
			System.out.println("─────────────────────────────────────────────");
			System.out.println();
			System.out.println("  "+bv.getBoard_content());
			System.out.println();
		}
		System.out.println("─────────────────────────────────────────────");
		
		
		
		System.out.println("1. 수정    2. 삭제    3. 리스트로 가기");
		int sel = sc.nextInt();
		sc.nextLine();
		detailMenu(sel);
	}
	
	private void detailMenu(int sel) {
		switch (sel) {
		case 1:
			updateBoard();
			break;
		case 2:
			deleteBoard();
			break;
		case 3:
			return;
		default:
			break;
		}
	}

	private void updateBoard() {
		Map<String, String> map = new HashMap<String, String>();
		
		int board_no = sessionstorage.get("board_no");
		System.out.println("수정할 제목 >> ");
		String board_title = sc.nextLine();
		System.out.println("수정할 내용 >> ");
		String board_content = sc.nextLine();
		
		map.put("board_title", board_title);
		map.put("board_content", board_content);
		
		int cnt = service.updateBoard(board_no, map);
		
		if(cnt<1) System.out.println("수정에 실패하였습니다.");
		else System.out.println("수정에 성공하였습니다.");
		
		sessionstorage.remove("board_no");
	}
	
	private void deleteBoard() {
		int board_no = sessionstorage.get("board_no");
		int cnt = service.deleteBoard(board_no);
		
		if(cnt<1) System.out.println("삭제에 실패하였습니다.");
		else System.out.println("삭제에 성공하였습니다.");
		
		sessionstorage.remove("board_no");
	}
	
 	private void searchBoard() {
 		
 		chk = true;
		System.out.println("검색할 제목 입력 >> ");
		String data = sc.nextLine().trim();
		
		List<BoardVO> bList = service.searchBoard(data);
		
		if(bList.isEmpty()) {
			System.out.println("검색결과가 없어 전체 목록을 보내드립니다.");
			allBoard();
		}else {
			System.out.println("─────────────────────────────────────────────");
			System.out.println("No\t제목\t\t작성자\t\t조회수");
			System.out.println("─────────────────────────────────────────────");
			for (BoardVO bv : bList) {
				System.out.println(bv.getBoard_no()+"\t"+bv.getBoard_title()+"\t"
						+bv.getBoard_writer()+"\t"+bv.getBoard_cnt());
			}
			System.out.println("─────────────────────────────────────────────");
			System.out.println();
		}
		
	}
	
}
