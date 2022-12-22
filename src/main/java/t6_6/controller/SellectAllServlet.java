package t6_6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_6.model.TempleBean;
import t6_6.model.TempleDaoimpl;

@WebServlet("/SellectAllServlet.do")
public class SellectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TempleDaoimpl tpDao= new TempleDaoimpl();
		List<TempleBean> beans = tpDao.sellectAll();
		request.setAttribute("tmp", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/t6_6.jsp/SellectAll.jsp");
		rd.forward(request, response);
		return;
	}
	
}