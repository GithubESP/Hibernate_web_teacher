package t6_14Actives.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_14Actives.model.Actives;
import t6_14Actives.service.ActivesService;

@WebServlet("/showAllActiveController")
public class showAllActiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showAllActiveController() {
        super();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActivesService activesService=new ActivesService();
		List<Actives> actives=activesService.findAll();
		request.setAttribute("actives", actives);
		request.getRequestDispatcher("/t6_14Actives/jsp/actives.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	
	

}
