package t6_10.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_10.impl.AccountServiceImpl;
import t6_10.service.AccountService;

@WebServlet("/removeAccountControllersafe")
public class RemoveAccountController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.valueOf(request.getParameter("id"));
		AccountService accountService=new AccountServiceImpl();
		accountService.removeAccount(id);
		response.sendRedirect(request.getContextPath()+"/showAllAccountControllersafe");
	}

}
