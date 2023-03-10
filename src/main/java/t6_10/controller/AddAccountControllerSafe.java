package t6_10.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import t6_10.impl.AccountDaoImpl;
import t6_10.impl.AccountServiceImpl;
import t6_10.service.AccountService;
import t6_10.service.GlobalService;

@MultipartConfig()
@WebServlet("/AddAccountControllersafe") //接棒自ShowUpdateAccountInfoController
public class AddAccountControllerSafe extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		System.out.println(id);
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		Part photo = req.getPart("photo");
		InputStream in = photo.getInputStream();
		long size = photo.getSize();
		String type = photo.getContentType();
		try {
	
			
			Blob image = GlobalService.fileToBlob(in, size);
			AccountService accountService=new AccountServiceImpl();
			Account accounts = new Account();
			
			
			if ((type.equals("image/jpeg")||type.equals("image/png")) && size != 0) {
				accounts.setImage(image);
				System.out.println("設定圖片");
			}else {

				String picPath = "C:\\hibernate\\workspace\\Hibernate_web_teacher\\src\\main\\webapp\\t6_10_imgs\\0.png";
//				C:\hibernate\workspace\Hibernate_web_teacher\src\main\webapp\t6_10_imgs\0.png
		
				System.out.println(picPath+"4564546");
				in = new FileInputStream(picPath);
				File imgFile = new File(picPath);
				size = imgFile.length();
				System.out.println(in+" 預設圖片 "+size);
				image = GlobalService.fileToBlob(in, size);
				accounts.setImage(image);
			}
			
			
			accounts.setAccount(account);
			accounts.setPassword(password);
			accounts.setId(id);
			accountService.add(accounts);
			resp.sendRedirect(req.getContextPath()+"/showAllAccountControllersafe");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
