
package t6_21class.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.ClassBean;
import t6_21class.bean.OrderItemBean;
import t6_21class.dao.ClassDao;
import t6_21class.dao.ShoppingCart;
import t6_21class.impl.ClassDaoImpl;


// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
@WebServlet("/BuyClassServlet.do")
public class BuyClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(BuyClassServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
       doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false); 

		if (session == null) {
			// 請使用者登入
			response.sendRedirect(response.encodeRedirectURL(
					request.getContextPath() + "/login.jsp"));
			return;
		}
		
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			log.info("加入購物車之Controller: 新建ShoppingCart物件");
			// 並將此新建ShoppingCart的物件放到session物件內，成為它的屬性物件
			session.setAttribute("shoppingCart", cart);   // ${ShoppingCart.subtotal} 
		}


		
		String classIdStr = request.getParameter("classId");
		int classId  = Integer.parseInt(classIdStr.trim());
		
		String qtyStr = request.getParameter("qty");
		Integer qty = 1 ; 
		
		ClassDao classDao = new ClassDaoImpl();
		ClassBean bean = classDao.findById(classId);
			
		System.out.println(qty);
		
		try{
			qty = Integer.parseInt(qtyStr.trim());
		} catch(NumberFormatException e){
			throw new ServletException(e); 
		}
		OrderItemBean oib = new OrderItemBean(null,null,classId,bean.getDescription(),bean.getClassPrice(),qty);
		System.out.println(classId);
		// 將OrderItem物件內加入ShoppingCart的物件內
		
		cart.addToCart(classId, oib);
		RequestDispatcher rd = request.getRequestDispatcher
								("/controller/classShoppingList");
		rd.forward(request, response);
	}
}