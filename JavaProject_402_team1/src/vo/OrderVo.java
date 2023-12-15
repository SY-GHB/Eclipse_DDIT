package vo;

public class OrderVo {
	private String order_no;
	private int order_sumprice;
	private String order_date;
	private int mem_no;
	
	
	
	@Override
	public String toString() {
		return "OrderVo [order_no=" + order_no + ", order_sumprice=" + order_sumprice + ", order_date=" + order_date
				+ ", mem_no=" + mem_no + "]";
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public int getOrder_sumprice() {
		return order_sumprice;
	}
	public void setOrder_sumprice(int order_sumprice) {
		this.order_sumprice = order_sumprice;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	
	
}
