package t6_10.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_10.bean.Account;
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
//		Blob image = null;
		
//		try { 
//			FileInputStream in = new FileInputStream("C:\\Users\\User\\Desktop\\imgs\\0.png");
//			System.out.println("in done"+in);
//			File imgFile = new File("C:\\Users\\User\\Desktop\\imgs\\0.png");
//			System.out.println("imgFile done"+imgFile);
//			long size = imgFile.length();
//			System.out.println("size done"+size);
//			image = GlobalService.fileToBlob(in, size);
//			System.out.println("toBlob done"+image);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		account.setImage(image);
		System.out.println("圖設好了");
		req.setAttribute("account", account);
//		req.getRequestDispatcher("/showUpdateAccountInfoJSPsafe").forward(req, resp);
		req.getRequestDispatcher("/t6_10/addAccounts.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
