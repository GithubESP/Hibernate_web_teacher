package t6_14Actives.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_14Actives.model.Actives;
import t6_14Actives.service.ActivesService;

@WebServlet("/showActiveController")
public class ShowActiveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		ActivesService activeService=new ActivesService();
		Actives active=activeService.findBId(id);
		
		req.setAttribute("active", active);
		req.getRequestDispatcher("/t6_14Actives/jsp/showUpdateActiveInfo.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
