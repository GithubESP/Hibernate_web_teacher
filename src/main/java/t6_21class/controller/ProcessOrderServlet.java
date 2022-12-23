package t6_21class.controller;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.MemberBean;
import t6_21class.bean.OrderBean;
import t6_21class.bean.OrderItemBean;
import t6_21class.createTable.DBService;
import t6_21class.dao.OrderDao;
import t6_21class.dao.ShoppingCart;
import t6_21class.impl.OrderDaoImpl;


// OrderConfirm.jsp 呼叫本程式。
@WebServlet("/ProcessOrder.do")
public class ProcessOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(ProcessOrderServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("處理訂單之Controller: 開始");
		
		String contextPath = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		
		String finalDecision = request.getParameter("finalDecision");		
		HttpSession session = request.getSession(false);
		if (session == null) {   // 使用逾時
			response.sendRedirect(response.encodeRedirectURL (contextPath + "/index.html" ));
			return;
		}
		MemberBean memberBean = (MemberBean) session.getAttribute("LoginOK");
		if (memberBean == null) {
			response.sendRedirect(response.encodeRedirectURL (contextPath + "/index.html" ));
			return;
		}
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			// 處理訂單時如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(response.encodeRedirectURL (contextPath + "/index.html" ));
			return;
		}
		// 如果使用者取消訂單
		if  (finalDecision.equals("CANCEL")){
			log.info("處理訂單之Controller: 取消訂單");
			session.removeAttribute("shoppingCart");
			response.sendRedirect(response.encodeRedirectURL (contextPath + "/index.html" ));
			return;  			// 一定要記得 return 
		}
		log.info("處理訂單之Controller: 將購物車內的訂購商品與訂單的其他資訊封裝到OrderBean內");
		int memberId = memberBean.getMemberId();   						// 取出會員代號
		double totalAmount = Math.round(shoppingCart.getSubtotal() * 1);  	// 計算訂單總金額 
		String customerEmail = request.getParameter("customerEmail");  // 出貨地址
		String customerPhoneStr = request.getParameter("customerPhone");
		String orderStatus = request.getParameter("orderStatus");	// 發票的抬頭
		
		Date today = new Date();
		DBService dbService = new DBService();
		// 新建訂單物件。OrderBean:封裝一筆訂單資料的容器，包含訂單主檔與訂單明細檔的資料。目前只存放訂單主檔的資料。
		OrderBean orderBean = new OrderBean(0, memberId, customerEmail, customerPhoneStr, 
				orderStatus,today , totalAmount);
		System.out.println(orderBean.toString());
		// 取出存放在購物車內的商品，放入Map型態的變數cart，準備將其內的商品一個一個轉換為OrderItemBean，
		
		Map<Integer, OrderItemBean> content = shoppingCart.getContent();
		
		Set<OrderItemBean> items = new LinkedHashSet<>();
		Set<Integer> set = content.keySet();
		for(Integer i : set) {
			items.add(content.get(i));
		}
		
		// 執行到此，購物車內所有購買的商品已經全部轉換為為OrderItemBean物件，並放在Items內
		orderBean.setItems(items);  
		
		try {
			log.info("處理訂單之Controller: orderBean=" + orderBean);
			OrderDao orderDao = (OrderDao) new OrderDaoImpl();
			orderDao.save(orderBean);
			session.removeAttribute("shoppingCart");
			response.sendRedirect(response.encodeRedirectURL (
									contextPath + "/index.html"));
			log.info("處理訂單之Controller: 處理訂單已正常結束");
			return;
		} catch(RuntimeException ex){
			String message = ex.getMessage();
			String shortMsg = "" ;   
			shortMsg =  message.substring(message.indexOf(":") + 1);
			System.out.println(shortMsg);
			log.info("處理訂單之Controller: 處理訂單時發生異常: " + 
										shortMsg  + "，需要調正訂單內容");
			session.setAttribute("OrderErrorMessage", "處理訂單時發生異常: " + 
										shortMsg  + "，請調正訂單內容" );
			response.sendRedirect(response.encodeRedirectURL (
					                 contextPath + "/t6_21class/ShowShoppingCartContent.jsp"));
			return;
		}
	}
}