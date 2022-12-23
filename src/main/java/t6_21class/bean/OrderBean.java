package t6_21class.bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="orderTable")
//訂單資料整理
public class OrderBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderNumber")
	int orderNumber;
	@Column(name="memberId")
	int memberId;
	@Column(name="customerEmail")
	String customerEmail;
	@Column(name="customerPhone")
	String customerPhoneStr;
	@Column(name="orderStatus")
	String orderStatus;
	@Column(name="orderDate")
	Date orderDate;
	@Column(name="orderPrice")
	Double orderPrice;
//	Set<OrderItemBean> items = new LinkedHashSet<>();
//
//	public Set<OrderItemBean> getItems() {
//		Set<OrderItemBean> items = new LinkedHashSet<>();
//		return items;
//	}
	
	public void setItems(Set<OrderItemBean> items) {
//		Set<OrderItemBean> items1 = new LinkedHashSet<>();
//		this.items = items1;
	}
	public String getCustomerPhoneStr() {
		return customerPhoneStr;
	}
	public void setCustomerPhoneStr(String customerPhoneStr) {
		this.customerPhoneStr = customerPhoneStr;
	}
	public OrderBean(int orderNumber, int memberId, String customerEmail,String customerPhoneStr,
			String orderStatus, Date orderDate, Double orderPrice) {
		super();
		this.orderNumber = orderNumber;
		this.memberId = memberId;
		this.customerEmail = customerEmail;
		this.customerPhoneStr = customerPhoneStr;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}
//	public String getOrderDateStr() {
//		return orderDateStr;
//	}
//	public void setOrderDateStr(String orderDateStr) {
//		this.orderDateStr = orderDateStr;
//	}
	public OrderBean() {
		super();
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	

}
