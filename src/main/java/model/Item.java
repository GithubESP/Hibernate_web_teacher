package model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Item")
@Table(name = "Item_Table")
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Pd_id;
	@Column(name = "Pd_name", columnDefinition = "VARCHAR(10) NOT NULL")
	private String Pd_name;
	private String Pd_description;
	private Integer Pd_price;
	private Integer Pd_qty;
	private Blob Pd_image;	
	@Temporal(TemporalType.DATE) 
	private Date Pd_date;
	@Temporal(TemporalType.DATE) 
	private Date Pd_last_update;
	
	
	
	public Item() {
		super();
	}
	public Item(Integer pd_id, String pd_name, String pd_description, Integer pd_price, Integer pd_qty, Blob pd_image,
			Date pd_date, Date pd_last_update) {
		super();
		Pd_id = pd_id;
		Pd_name = pd_name;
		Pd_description = pd_description;
		Pd_price = pd_price;
		Pd_qty = pd_qty;
		Pd_image = pd_image;
		Pd_date = pd_date;
		Pd_last_update = pd_last_update;
	}
	public Integer getPd_id() {
		return Pd_id;
	}
	public void setPd_id(Integer pd_id) {
		Pd_id = pd_id;
	}
	public String getPd_name() {
		return Pd_name;
	}
	public void setPd_name(String pd_name) {
		Pd_name = pd_name;
	}
	public String getPd_description() {
		return Pd_description;
	}
	public void setPd_description(String pd_description) {
		Pd_description = pd_description;
	}
	public Integer getPd_price() {
		return Pd_price;
	}
	public void setPd_price(Integer pd_price) {
		Pd_price = pd_price;
	}
	public Integer getPd_qty() {
		return Pd_qty;
	}
	public void setPd_qty(Integer pd_qty) {
		Pd_qty = pd_qty;
	}
	public Blob getPd_image() {
		return Pd_image;
	}
	public void setPd_image(Blob pd_image) {
		Pd_image = pd_image;
	}
	public Date getPd_date() {
		return Pd_date;
	}
	public void setPd_date(Date pd_date) {
		Pd_date = pd_date;
	}
	public Date getPd_last_update() {
		return Pd_last_update;
	}
	public void setPd_last_update(Date pd_last_update) {
		Pd_last_update = pd_last_update;
	}
	
	
	
}
