package t6_6.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.report;
import dao.TmpRoomDao;

@WebServlet("/SelectTempleRoom.do")
public class SelectTempleRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectTempleRoom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String templeId = request.getParameter("templeId");
		String[] room = request.getParameterValues("room");
		TmpRoomDao tmpr = new TmpRoomDao();
		List<report> beans = tmpr.selectAll(templeId, room);
		request.setAttribute("tmpr", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/t6_6.jsp/resultSelectTempleRoom.jsp");
		rd.forward(request, response);
		return;
		
	}

}
