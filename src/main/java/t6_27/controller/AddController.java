package t6_27.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bean.Account;
import t6_27.bean.Post;
//import dao.AccountDao;
import t6_27.dao.PostDao;
//import impl.AccountDaoImpl;
//import impl.AccountServiceImpl;
import t6_27.impl.PostDaoImpl;
import t6_27.impl.PostServiceImpl;
//import service.AccountService;
//import service.GlobalService;
import t6_27.service.PostService;



@WebServlet("/AddController")
public class AddController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
		String postTitle=req.getParameter("postTitle");
		String postDate=req.getParameter("postDate");
		String postContent=req.getParameter("postContent");
		String postLike=req.getParameter("postLike");
		String postDislike=req.getParameter("postDislike");
		String postComment=req.getParameter("postComment");

		Post post=new Post(null, postTitle, postDate, postContent, postLike, postDislike, postComment);
		
		PostDao postService = new PostDaoImpl();
		
		postService.add(post);
		System.out.println(post.toString());
		
		req.setAttribute("add", post);
		req.getRequestDispatcher("/JSP/AddOK.jsp").forward(req, resp);
		return;		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
