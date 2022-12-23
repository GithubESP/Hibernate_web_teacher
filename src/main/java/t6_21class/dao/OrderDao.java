package t6_21class.dao;

import java.util.List;

import t6_21class.bean.OrderBean;



public interface OrderDao {
	//存入訂單
	int save(OrderBean ob);
	//用訂單號碼找出那筆訂單資訊
	OrderBean findById(int orderNumber);
	//利用會員id找出會員的訂單
	List<OrderBean> findByMemberId(int memberId);
	
}
