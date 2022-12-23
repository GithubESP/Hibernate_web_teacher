package t6_14Actives.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import t6_14Actives.model.Actives;
import t6_14Actives.service.ActivesService;
import t6_14Actives.service.GlobalService;
@MultipartConfig()
@WebServlet("/updateActiveController")
public class updateActiveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		String name=req.getParameter("name");
		InputStream in=req.getPart("img").getInputStream();
		long size = req.getPart("img").getSize();
		String description=req.getParameter("description");
		Date startDate=Date.valueOf(req.getParameter("start"));
		Date endDate=Date.valueOf(req.getParameter("end"))  ;
		String location=req.getParameter("location");
		String host=req.getParameter("host");
		
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			 
			
			
			Actives active=new Actives(id, name,  description, startDate, endDate, location, host);
			if (req.getPart("img").getSize()!=0) {
                active.setActiveImg(image);
            }
			ActivesService activeService=new ActivesService();
			System.out.println(active);
			activeService.updateOneActive(active);
			
			resp.sendRedirect(req.getContextPath()+"/showAllActiveController");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
