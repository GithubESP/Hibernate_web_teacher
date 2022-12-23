package t6_21class.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import t6_21class.bean.OrderItemBean;



public class ShoppingCart {
	private Map<Integer, OrderItemBean> cart = new LinkedHashMap< >();
	
	public ShoppingCart() {
	}
	public Map<Integer, OrderItemBean>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(int classId, OrderItemBean oib) {
		if (oib.getQuantity() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(classId) == null ) {
		    cart.put(classId, oib);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItemBean oiBean = cart.get(classId);
			// 加購的數量：bean.getQuantity()
			// 原有的數量：oBean.getQuantity()			
			oiBean.setQuantity(oib.getQuantity() + oiBean.getQuantity());
		}
	}
 //計算數量
	public boolean modifyQty(int classId, int newQty) {
		if ( cart.get(classId) != null ) {
		   OrderItemBean  bean = cart.get(classId);
		   bean.setQuantity(newQty);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteClass(int classId) {
		if ( cart.get(classId) != null ) {
	       cart.remove(classId);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	public int getQty() {
		int qty =0;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			OrderItemBean oib = cart.get(n);
			double price    = oib.getUnitPrice();
			qty      = oib.getQuantity();
		}
		return qty;

	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			OrderItemBean oib = cart.get(n);
			double price    = oib.getUnitPrice();
			int qty      = oib.getQuantity();
			subTotal +=  price*qty;
		}
		return subTotal;
	}
}

