package t6_21class.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderItemBean {
	Integer seqno; //訂單流水號
	Integer orderNumber; //訂單號碼
	Integer classNumber; //購買課程編號
	String description;  //購買課程名稱
	Double unitPrice;   //單筆訂單總價錢
	Integer quantity;	//單筆訂單數量
	public OrderItemBean(Integer seqno, Integer orderNumber, Integer classNumber, String description, Double unitPrice,
			Integer quantity) {
		super();
		this.seqno = seqno;
		this.orderNumber = orderNumber;
		this.classNumber = classNumber;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	public OrderItemBean() {
		super();
	}
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItemBean [seqno=" + seqno + ", orderNumber=" + orderNumber + ", classNumber=" + classNumber
				+ ", description=" + description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
	}
	public int totalPrice() {
		return (int) (unitPrice*quantity);
	}

}
