package controller.itemInsert;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ItemDao;
import dao.ItemDaoImplHIbernate;
import model.Item;
import util.GlobalService;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
* 1024 * 500 * 5)
@WebServlet("/ItemInsert.do")
public class ItemInsert extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Collection<Part> parts = request.getParts();
		Item item = new Item();
		int count=0;
		for (Part part : parts) {			
			String value = request.getParameter(part.getName());
			Part photo = request.getPart("Pd_image");
			InputStream in = photo.getInputStream();
			long size = photo.getSize();
			String type = photo.getContentType();
			System.out.println(value);
			if(count==0)item.setPd_name(value);
			else if(count==1)item.setPd_description(value);
			else if(count==2)item.setPd_price(Integer.parseInt(value));
			else if(count==3)item.setPd_qty(Integer.parseInt(value));
			else if(count==4) {try {
				Blob image = GlobalService.fileToBlob(in, size);
				if (size!=0 && type.equals("image/jpeg")) {
					item.setPd_image(image);
				}
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			count++;
		}
		ItemDao iDao = new ItemDaoImplHIbernate();
		try {
			iDao.insert(item);
		} catch (SecurityException | RollbackException | HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Item", item);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ItemList/result.jsp");
		rd.forward(request, response);
		return;
		
	}
}
