package t6_21class.controller.implServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.dao.ClassDao;
import t6_21class.impl.ClassDaoImpl;


// 依照書籍的書號來刪除一本書籍的紀錄。本控制器會呼叫 BookService介面的deleteBook()方法來完成。
@WebServlet("/ClassDelete.do")
public class ClassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(ClassDeleteServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String cId = request.getParameter("id");
		Integer classId = Integer.valueOf(cId);
		ClassDao classDao = new ClassDaoImpl();
		classDao.delete(classId);
		response.sendRedirect(request.getContextPath()+
				         "/controller/classListMaintainServlet");
	}
	
}
