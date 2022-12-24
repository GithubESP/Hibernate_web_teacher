package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.PostServiceImpl;
import service.PostService;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer postId=Integer.valueOf(req.getParameter("delete"));
		PostService postService=new PostServiceImpl();
		postService.delete(postId);
		System.out.println(postId);
		req.setAttribute("delete", postId);
		req.getRequestDispatcher("/JSP/DeleteOK.jsp").forward(req, resp);
	}

}
