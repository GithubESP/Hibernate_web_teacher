package t6_10.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_10.bean.Account;
import t6_10.impl.AccountServiceImpl;
import t6_10.service.AccountService;

/**
 * Servlet implementation class ShowAccountController
 * 有接棒自showAllAccountsafe
 */
@WebServlet("/showAccountControllersafe")
public class ShowAccountController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		AccountService accountService=new AccountServiceImpl(); //第幾項的BEAN
		Account account=accountService.showAccount(id);
		
		req.setAttribute("account", account);
		req.getRequestDispatcher("/t6_10/showAllAccounts.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
