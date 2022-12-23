package t6_14Actives.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import t6_14Actives.service.ActivesService;

@WebServlet("/removeActiveController")
public class RemoveActiveController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.valueOf(request.getParameter("id"));
		ActivesService activeService=new ActivesService();
		activeService.deleteById(id);
		response.sendRedirect(request.getContextPath()+"/showAllActiveController");
	}

}
