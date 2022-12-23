package t6_21class.controller.implServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.ClassBean;
import t6_21class.dao.ClassDao;
import t6_21class.impl.ClassDaoImpl;


@WebServlet("/ClassPreUpdateServlet.do")
public class ClassPreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = LoggerFactory.getLogger(ClassPreUpdateServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int classId = 0;
		String strclassId = request.getParameter("classId");
		classId = Integer.parseInt(strclassId);
		ClassDao classDao = new ClassDaoImpl();
		ClassBean bean = classDao.findById(classId);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/classUpdateList.jsp");
		rd.forward(request, response);
		return;

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}