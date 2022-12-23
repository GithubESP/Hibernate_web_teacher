package t6_23.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import t6_23.bean.PeopleBean_23;
import t6_23.service.PeopleService;
import t6_23.service.impl.PeopleServiceImpl;

@WebServlet("/t6_23/controller/showPeople.do")
public class ShowAllPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ShowAllPeopleServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			PeopleService peopleService = new PeopleServiceImpl();
			List<PeopleBean_23> beans = peopleService.selectAll();

			request.setAttribute("peopleBeans", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/t6_23/ShowPeople.jsp");
			rd.forward(request, response);

	}

}
