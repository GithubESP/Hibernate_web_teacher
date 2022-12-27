package controller.itemSelect;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDao;
import dao.ItemDaoImplHIbernate;
import model.Item;

@WebServlet("/ItemSelect.do")
public class ItemSelect extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemDao iDao = new ItemDaoImplHIbernate();
//		List<Item> list = iDao.selectAll();
		List<Item> list;
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String word = request.getParameter("id");
		if(word.equals("")) {list = iDao.selectAll();}
		else{list = iDao.search(type,word);}
		request.setAttribute("select",list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ItemList/NewItemList.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
