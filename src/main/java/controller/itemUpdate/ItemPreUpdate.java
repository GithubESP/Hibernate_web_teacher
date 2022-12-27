package controller.itemUpdate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.ItemDaoImplHIbernate;
import model.Item;

@WebServlet("/preItemUpdate.do")
public class ItemPreUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemDao iDao = new ItemDaoImplHIbernate();
		Item item=iDao.selectItem(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("Item", item);		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ItemList/ItemUpdate.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
