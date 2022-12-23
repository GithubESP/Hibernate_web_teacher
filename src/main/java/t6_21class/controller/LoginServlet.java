package t6_21class.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.MemberBean;
import t6_21class.dao.MemberDao;
import t6_21class.impl.MemberDaoImpl;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		MemberDao memberDao=new MemberDaoImpl();
		MemberBean memberBean= memberDao.login(username, password);
		
		if(memberBean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("LoginOK", memberBean);
			response.sendRedirect(request.getContextPath()+"/controller/classShoppingList");
		}else {
			response.sendRedirect(request.getContextPath()+"/t6_21login.jsp");
		}
			
		}
	
}
