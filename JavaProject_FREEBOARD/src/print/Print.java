package print;

import java.util.List;

import vo.FreeBoardVo;

//나중에 HTML로 변환할 것이다.
public class Print {

	public void printVar() {
		System.out.println("--------------------------------------------------------------------------");
	}

	
	public void printVar(String s) {
		System.out.println("-----------------"+s+"-----------------");
		
	}
	
	
	public void printLn(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}
	
	public void printHome() {
		
		printVar();
		System.out.println("1. 자유게시판 전체 조회");
		System.out.println("2. 관리자 로그인");
		System.out.println("3. 로그아웃");
		printVar();
	}
	
	public void printList(List<FreeBoardVo> freeList) {
		printLn(1);
		printVar();
		System.out.println("번호\t제목\t내용\t작성자\t작성일자\t\t조회수");
		printVar();
		
		// 여기서는 서비스랑 연결하면 안 되니까 파라미터로 데이터를 주입해줄것이다. void 옆을 보
//		List<FreeBoardVo> freeList =  freeService.freeList();
		
		for(FreeBoardVo freeBoard : freeList) {
			System.out.println(freeBoard.getBoard_no()+"\t"+freeBoard.getTitle()+"\t"
					+freeBoard.getContent()+"\t"+freeBoard.getMem_no()+"\t"
					+freeBoard.getWrite_date()+"\t"+freeBoard.getCount()+"\t");
		}
		printVar();
		printLn(1);
	}
	
	public void printDetail(List<FreeBoardVo> freeList) {
		FreeBoardVo freeBoard = (FreeBoardVo) freeList;
		
		System.out.println("번호\t제목\t내용\t작성자\t작성일자\t\t조회수");
		System.out.println(freeBoard.getBoard_no()+"\t"+freeBoard.getTitle()+"\t"
				+freeBoard.getContent()+"\t"+freeBoard.getMem_no()+"\t"
				+freeBoard.getWrite_date()+"\t"+freeBoard.getCount()+"\t");
	}
	
	
	public void printListMenu() {
		
		printLn(1);
		System.out.println("1. 다음 페이지");
		System.out.println("2. 이전 페이지");
		System.out.println("3. 상세 페이지 조회");
		System.out.println("4. 홈");
		printLn(1);
	}
	
	public void printDetailMenu() {
	
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
		System.out.println("3. 홈으로");
		printLn(1);
	}
}
