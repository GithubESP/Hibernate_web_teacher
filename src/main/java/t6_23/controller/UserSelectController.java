package t6_23.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t6_23.bean.PeopleBean_23;
import t6_23.service.PeopleService;
import t6_23.service.impl.PeopleServiceImpl;

@WebServlet("/userSelectControllersafe")
public class UserSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//用戶搜尋ID或名字
	
	public UserSelectController() {
		super();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		PeopleService peopleService = new PeopleServiceImpl();
		List<PeopleBean_23> bean;
		int id = 0;
		String name = null;
		boolean isLetter = false;// 定義一個boolean值,用來表示是否包含字母
		String str = request.getParameter("userId");
		if(str.equals("")) {
			bean = peopleService.selectAll();
		}else {
			
			for (int i = 0; i < str.length(); i++) { // 迴圈遍歷字串
				if (Character.isLetter(str.charAt(i))) { // 用char包裝類中的判斷字母的方法判斷每一個字元
					isLetter = true;
				}
			}
			if(isLetter == true) {
				name = str;
			} else {
				id = Integer.valueOf(str);
				
			}
			bean = peopleService.selectByName(name);
		}
		request.setAttribute("peopleBeans", bean);
		request.getRequestDispatcher("/t6_23/ShowUserSelect.jsp").forward(request, response);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	}

}
