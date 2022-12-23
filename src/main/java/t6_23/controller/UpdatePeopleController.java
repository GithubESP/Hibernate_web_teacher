package t6_23.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

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

@WebServlet("/updatePeopleControllersafe")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class UpdatePeopleController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public UpdatePeopleController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		InputStream in = request.getPart("photo").getInputStream();
		long size = request.getPart("photo").getSize();
		String type = request.getPart("photo").getContentType();
		PeopleBean_23 pb;

		try {

			PeopleService peopleService = new PeopleServiceImpl();

			Integer id = Integer.parseInt(request.getParameter("userId"));

			String name = request.getParameter("name");

			Integer age = Integer.valueOf(request.getParameter("age"));

//			String sex = request.getParameter("gender");

			String address = request.getParameter("address");

			Blob image = GlobalService.fileToBlob(in, size);
			pb = peopleService.selectById(id);

			System.out.println(type+"  6656556565656565");
			if (size != 0 && (type.equals("image/jpeg") || type.equals("image/png"))) {
				pb.setImages(image);
			}

			String star = request.getParameter("star_sign");

			String profession = request.getParameter("profession");

			String religion = request.getParameter("religion");

			Double income = Double.valueOf(request.getParameter("income"));

			String sex_in = request.getParameter("sex_in");

			String hobby = request.getParameter("hobby");

			String dream = request.getParameter("dream");

			String personality = request.getParameter("personality");

			String emotion = request.getParameter("emotion");

			String introduction = request.getParameter("introduction");

			pb.setUserID(id);
			pb.setName(name);
			pb.setAge(age);
//			pb.setSex(sex);
			pb.setAddress(address);
			pb.setStar(star);
			pb.setEmotion(emotion);
			pb.setProfession(profession);
			pb.setPersonality(personality);
			pb.setHobby(hobby);
			pb.setDream(dream);
			pb.setIntroduction(introduction);
			pb.setReligion(religion);
			pb.setSex_in(sex_in);
			pb.setIncome(income);

			peopleService.update(pb);

			System.out.println("update555555555555555");
			response.sendRedirect(request.getContextPath() + "/t6_23/controller/showPeople.do");
			session.setAttribute("peopleBean", pb);

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
