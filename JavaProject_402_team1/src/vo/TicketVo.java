package vo;

public class TicketVo {
	
	private String tick_code;
	private String tick_name;
	private int tick_price;
	private String tick_delyn;
	
	
	
	@Override
	public String toString() {
		return "TicketVo [tick_code=" + tick_code + ", tick_name=" + tick_name + ", tick_price=" + tick_price
				+ ", tick_delyn=" + tick_delyn + "]";
	}
	
	
	public String getTick_code() {
		return tick_code;
	}
	public void setTick_code(String tick_code) {
		this.tick_code = tick_code;
	}
	public String getTick_name() {
		return tick_name;
	}
	public void setTick_name(String tick_name) {
		this.tick_name = tick_name;
	}
	public int getTick_price() {
		return tick_price;
	}
	public void setTick_price(int tick_price) {
		this.tick_price = tick_price;
	}
	public String getTick_delyn() {
		return tick_delyn;
	}
	public void setTick_delyn(String tick_delyn) {
		this.tick_delyn = tick_delyn;
	}
	
	
	
}
