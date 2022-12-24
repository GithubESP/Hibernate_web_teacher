package t6_10.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_10.bean.Account;
import t6_10.impl.AccountServiceImpl;
import t6_10.service.AccountService;
import t6_10.service.GlobalService;

/**
 * Servlet implementation class ShowAccountController
 * 有接棒自showAllAccountsafe
 */
@WebServlet("/addAccountControllersafe")
public class AddAccountController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
//		AccountService accountService=new AccountServiceImpl(); //第幾項的BEAN
		Account account = new Account(id);
		
//		File imgFile = new File("C:\\Users\\User\\Desktop\\imgs\\1.jpg");
//		Blob image = GlobalService.fileToBlob(in, size);
//		account.setImage(null);
		
		req.setAttribute("account", account);
//		req.getRequestDispatcher("/showUpdateAccountInfoJSPsafe").forward(req, resp);
		req.getRequestDispatcher("/t6_10/addAccounts.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
