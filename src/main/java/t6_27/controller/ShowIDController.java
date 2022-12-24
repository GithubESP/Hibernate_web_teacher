package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Post;
import impl.PostServiceImpl;
import service.PostService;


@WebServlet("/ShowIDController")
public class ShowIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer postId=Integer.parseInt(req.getParameter("showid"));
		PostService postService=new PostServiceImpl();
		Post post=postService.searchById(postId);
		
		req.setAttribute("post", post);
		req.getRequestDispatcher("/JSP/ShowContent.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
