package t6_23.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_23.bean.PeopleBean_23;
import t6_23.service.PeopleService;
import t6_23.service.impl.PeopleServiceImpl;

@WebServlet("/showPeopleControllersafe")
public class ShowPeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//用ID搜尋
	
	public ShowPeopleController() {
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
		PeopleBean_23 bean = peopleService.selectById(id);
		
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/t6_23/ShowUpdatePeopleForm.jsp").forward(request, response);

		
		
		
	}

}
