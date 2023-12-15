package vo;

public class FreeBoardVo {
	private int board_no;
	private String title;
	private String content;
	private int mem_no;
	private String write_date;
	private int count;
	private String spare1;
	
	
	
	
	@Override
	public String toString() {
		return "번호: " + board_no + ", 제목: " + title + ", 내용: " + content + ", 작성자: " + mem_no
				+ ", 작성일자: " + write_date + ", 조회수: " + count ;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	
	
}
