package t6_10.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import jakarta.servlet.annotation.MultipartConfig;
import t6_10.bean.AccountManager;
import t6_10.impl.AccountManagerServiceImpl;
import t6_10.service.AccountManagerService;

@MultipartConfig
@WebServlet("/accountLogin2")
public class AccountmanagerLoginController222 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(username+password);
		System.out.println("有近來唷");
		AccountManagerService accountManagerService=new AccountManagerServiceImpl(); //從SQL裝到Bean
		AccountManager manager= accountManagerService.login(username, password);
		if(manager!=null) {
			System.out.println("有對應資料喔");
			HttpSession session=req.getSession();
			session.setAttribute("manager", manager);
		      // If the login is successful, send a success response
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
		      PrintWriter out = resp.getWriter();
		      out.print(new Gson().toJson(new Response("1")));
		      out.flush();
			
//			resp.sendRedirect(req.getContextPath()+"/showAllAccountControllersafe");
		}else {
			// Otherwise, send an error response
			System.out.println("沒有對應資料");
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		      PrintWriter out = resp.getWriter();
		      
		      out.print(new Gson().toJson(new Response("0")));
		      out.flush();
//			resp.sendRedirect(req.getContextPath()+"/t6_10/accountLogin.html"); // 如果是空返回原畫面
		}
			
		}
	
	}
class Response {
	  String res;
	  String message;

	  public Response(String res) {
	    this.res = res;
	  }

	  public Response(String res, String message) {
	    this.res = res;
	    this.message = message;
	  }
	}






