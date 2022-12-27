package model;

import java.sql.Date;

public class Order {
	private Integer od_id;
	private Date od_date;
	private Date od_lastupdate_date;
	private String cus_id;
	private String od_address;
	
	
	
	
	
	
	public Order() {
		super();
	}
	public Order(Integer od_id, Date od_date, Date od_lastupdate_date, String cus_id, String od_address) {
		super();
		this.od_id = od_id;
		this.od_date = od_date;
		this.od_lastupdate_date = od_lastupdate_date;
		this.cus_id = cus_id;
		this.od_address = od_address;
	}
	public Integer getOd_id() {
		return od_id;
	}
	public void setOd_id(Integer od_id) {
		this.od_id = od_id;
	}
	public Date getOd_date() {
		return od_date;
	}
	public void setOd_date(Date od_date) {
		this.od_date = od_date;
	}
	public Date getOd_lastupdate_date() {
		return od_lastupdate_date;
	}
	public void setOd_lastupdate_date(Date od_lastupdate_date) {
		this.od_lastupdate_date = od_lastupdate_date;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}
	public String getOd_address() {
		return od_address;
	}
	public void setOd_address(String od_address) {
		this.od_address = od_address;
	}
}
