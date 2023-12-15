package vo;

public class UserVo {
	private int user_no;
	private String user_date;
	private String order_no;
	private String tick_code;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getTick_code() {
		return tick_code;
	}
	public void setTick_code(String tick_code) {
		this.tick_code = tick_code;
	}
}
