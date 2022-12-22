package t6_6.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_6.model.TempleBean;
import t6_6.model.TempleDaoimpl;

@WebServlet("/UpdateTempleData.do")
public class UpdateTempleData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateTempleData() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");
		String templeId = request.getParameter("templeId");
		
		if (templeId == null || templeId.trim().length() == 0) {
			errorMessage.add("帳號欄必須輸入");
		}
		String templeName = request.getParameter("templeName");
		String deitiesName = request.getParameter("deitiesName");
		String administrative = request.getParameter("administrative");
		String address = request.getParameter("address");
		String register = request.getParameter("register");
		String sect = request.getParameter("sect");
		String phone = request.getParameter("phone");
		String principal = request.getParameter("principal");
		String other = request.getParameter("other");
		Double WGS84X = Double.valueOf(request.getParameter("wGS84X"));
		Double WGS84Y = Double.valueOf(request.getParameter("wGS84Y"));
		Integer uniformnumbers = Integer.valueOf(request.getParameter("uniformnumbers"));
		
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t6_6.jsp/error.jsp");
			rd.forward(request, response);
			return;
		}
		
		TempleBean tmpb = new TempleBean(templeId, templeName, deitiesName, administrative, address, register, sect, phone, principal, other, WGS84X, WGS84Y, uniformnumbers);

		TempleDaoimpl tpDao= new TempleDaoimpl();
		tpDao.updateOneTemple(tmpb);
		request.setAttribute("templeBean", tmpb);
		RequestDispatcher rd = request.getRequestDispatcher("/t6_6.jsp/success.jsp");
		rd.forward(request, response);
		return;
	}
}

//		try {
//			TempleDao tpDao= new TempleDao();
//			tpDao.updateOneTemple(tmpb);
//			request.setAttribute("templeBean", tmpb);
//			RequestDispatcher rd = request.getRequestDispatcher("/t6_6.jsp/success.jsp");
//			rd.forward(request, response);
//			return;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
