package t6_23.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import t6_23.bean.PeopleBean_23;
import t6_23.service.GlobalService;
import t6_23.service.PeopleService;
import t6_23.service.impl.PeopleServiceImpl;


//insert資料
@WebServlet("/t6_23/controller/ProcessPeopleServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProcessPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ProcessPeopleServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");



		InputStream in = request.getPart("photo").getInputStream();
		long size = request.getPart("photo").getSize();

		try {
			
			Integer userid = Integer.parseInt(request.getParameter("userId"));
//		if (userid == null ) {
//			errorMessage.put("id", "帳號欄必須輸入");
//		}

			String name = request.getParameter("name");
			if (name == null || name.trim().length() == 0) {
				errorMessage.put("name", "姓名欄必須輸入");
			}

			Integer age = Integer.valueOf(request.getParameter("age"));
			if (age == null) {
				errorMessage.put("age", "年齡欄必須輸入");
			}

			String sex = request.getParameter("gender");

			String address = request.getParameter("address");
			if (address == null) {
				errorMessage.put("address", "地區欄必須輸入");
			}
			Blob image = GlobalService.fileToBlob(in, size);
			
			String star = request.getParameter("star_sign");
			
			String profession = request.getParameter("profession");
			
			String religion = request.getParameter("religion");
			
			
			String value = request.getParameter("income");
			System.out.println(value);
			Double income = 0.0;
			if(!value.equals("")) {
				System.out.println(123456789);
				income = Double.valueOf(value);
			}
			
			String sex_in = request.getParameter("sex_in");
			
			String hobby = request.getParameter("hobby");
			
			String dream = request.getParameter("dream");

			String personality = request.getParameter("personality");
			
			String emotion = request.getParameter("emotion");
			
			String introduction = request.getParameter("introduction");
			
			PeopleService peopleService = new PeopleServiceImpl();
			PeopleBean_23 pb;
			if(income==0.0) {
				pb = new PeopleBean_23(userid, name, age, sex, address, star, emotion, profession, personality, hobby, dream, introduction, image, religion, sex_in);
				peopleService.save(pb);
			} else {
				pb = new PeopleBean_23(userid, name, age, sex, address, star, emotion, profession, personality, hobby, dream, introduction, image, religion, sex_in, income);
				peopleService.save(pb);
			}
			
			
			
			response.sendRedirect(request.getContextPath() + "/t6_23/InsertPeopleSuccess.jsp");
			session.setAttribute("peopleBean", pb);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t6_23/InsertPeopleForm_23.jsp");
			rd.forward(request, response);
			return;
		}


	}

	

}
