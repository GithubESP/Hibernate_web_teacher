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



@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
		Integer postId = Integer.valueOf(req.getParameter("postId"));
		String postTitle=req.getParameter("postTitle");
		String postDate=req.getParameter("postDate");
		String postContent=req.getParameter("postContent");
		String postLike=req.getParameter("postLike");
		String postDislike=req.getParameter("postDislike");
		String postComment=req.getParameter("postComment");

		Post post=new Post(postId, postTitle, postDate, postContent, postLike, postDislike, postComment);
		
		PostService postService=new PostServiceImpl();
		
		postService.update(post);
		System.out.println(post.toString());
		
		req.setAttribute("update", post);
		req.getRequestDispatcher("/JSP/UpdateOK.jsp").forward(req, resp);
		return;		
	}
	
//		try {
//			PostService postService=new PostServiceImpl();
//			System.out.println("456");
//			PostDaoTest postDaoTest = new PostDaoImpl();
//			System.out.println("789");
//			Post post = postDaoTest.searchById(postId);
//			System.out.println(post);
//			
//			post.setpostId(postId);
//			post.setpostTitle(postTitle);
//			post.setpostDate(postDate);
//			post.setpostContent(postContent);
//			post.setpostLike(postLike);
//			post.setpostDislike(postDislike);
//			post.setpostComment(postComment);
//			postService.update(post);
//			
//			resp.sendRedirect(req.getContextPath()+"/JSP/UpdateOK.jsp");
//		} catch (IOException  e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
