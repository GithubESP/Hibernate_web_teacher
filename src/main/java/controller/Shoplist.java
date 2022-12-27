package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.ItemService;
import service.ItemServiceImpl;

@WebServlet("/ItemList")
public class Shoplist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//     /
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		ItemService IS = new  ItemServiceImpl();
		//System.out.println(IS.findById(1).getPd_price());
		request.setAttribute("Item", IS.findById(1));//List<Item>
		RequestDispatcher rd = request.getRequestDispatcher("/ItemList/ItemList.jsp");
		rd.forward(request, response);
		return;
		
		
	}
}
