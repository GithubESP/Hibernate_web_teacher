package t6_21class.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.dao.ShoppingCart;


// 當進行『結帳』時，如果按下『放棄購物』超連結，瀏覽器會要求此程式
@WebServlet("/abort.do")
public class AbortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(AbortServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		log.info("放棄購物之Controller: 開始");
		
		HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		if (cart != null) {
			//由session物件中移除ShoppingCart物件
			log.info("放棄購物之Controller: 移除位於Session物件內的購物車物件");
			session.removeAttribute("shoppingCart");
		}
		response.sendRedirect(response.encodeRedirectURL (request.getContextPath() + "/index.html"));
		return;
	}
}
