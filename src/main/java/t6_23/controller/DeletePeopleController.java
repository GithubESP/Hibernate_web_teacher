package t6_23.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import t6_23.service.PeopleService;
import t6_23.service.impl.PeopleServiceImpl;

@WebServlet("/removePeople.do")
public class DeletePeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeletePeopleController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));

		PeopleService peopleService = new PeopleServiceImpl();
		peopleService.delete(id);

		response.sendRedirect(request.getContextPath() + "/t6_23/controller/showPeople.do");

	}

}
