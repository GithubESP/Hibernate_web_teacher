package model;

public class OrderItem {
	private Integer od_id;
	private Integer Pd_id;
	
	
	
	public OrderItem() {
		super();
	}
	public OrderItem(Integer od_id, Integer pd_id) {
		super();
		this.od_id = od_id;
		Pd_id = pd_id;
	}
	public Integer getOd_id() {
		return od_id;
	}
	public void setOd_id(Integer od_id) {
		this.od_id = od_id;
	}
	public Integer getPd_id() {
		return Pd_id;
	}
	public void setPd_id(Integer pd_id) {
		Pd_id = pd_id;
	}
	
	
	
}
