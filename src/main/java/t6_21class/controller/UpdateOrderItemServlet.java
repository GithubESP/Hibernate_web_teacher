package t6_21class.controller;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.dao.ShoppingCart;


// 本類別可修改購物車內的商品資料，包括刪除某項商品，修改某項商品的數量
@WebServlet("/UpdateItem.do")
public class UpdateOrderItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(UpdateOrderItemServlet.class);
	
	HttpSession session = null;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		if (session == null) {      // 使用逾時
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.html"));
			return;
		}
		//取出session物件內的ShoppingCart物件
		ShoppingCart sc= (ShoppingCart)session.getAttribute("shoppingCart");
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(response.encodeRedirectURL(contextPath + "/index.jsp"));
			return;
        }
		
		String cmd = request.getParameter("cmd");
		String classNumberStr = request.getParameter("classNumber");
		int classNumber = Integer.parseInt(classNumberStr.trim());		
		if (cmd.equalsIgnoreCase("DEL")) {
	        sc.deleteClass(classNumber); // 刪除購物車內的某項商品
	        log.info("刪除購物車內的某項商品=" + classNumber);
	        RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/ShowShoppingCartContent.jsp");
		    rd.forward(request, response);
		    
		    return;
		} else if (cmd.equalsIgnoreCase("MOD")) {
			String newQtyStr = request.getParameter("newQty");
			int newQty = Integer.parseInt(newQtyStr.trim());
			sc.modifyQty(classNumber, newQty);   // 修改某項商品的數項
			System.out.println(newQty);
			 log.info("修改某項商品的數項=" + newQty);
	        RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/ShowShoppingCartContent.jsp");
		    rd.forward(request, response);
		    return;
		}
	}
}