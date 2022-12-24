package t6_27.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import t6_27.bean.Post;
import t6_27.dao.PostDao;
import t6_27.impl.PostDaoImpl;

@WebServlet("/SearchAllController")
public class SearchAllController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PostDao postService = new PostDaoImpl();
		List<Post> post = postService.searchAll();
		req.setAttribute("post", post);
		req.getRequestDispatcher("/JSP/SearchAll.jsp").forward(req, resp);
		return;
	}

}
