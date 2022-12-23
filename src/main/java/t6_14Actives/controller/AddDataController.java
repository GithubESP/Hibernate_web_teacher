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
@WebServlet("/addController")
public class AddDataController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		System.out.println(name);
		InputStream in=req.getPart("img").getInputStream();
		long size = req.getPart("img").getSize();
		String description=req.getParameter("description");
		Date startDate=Date.valueOf(req.getParameter("start"));
		Date endDate=Date.valueOf(req.getParameter("end"))  ;
		String location=req.getParameter("location");
		String host=req.getParameter("host");
		Actives active=new Actives(name, description, startDate, endDate, location, host);
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			
			if (req.getPart("img").getSize()!=0) {
                active.setActiveImg(image);
                System.out.println(active);
            }
			
			active.setActiveDescription(description);
			active.setActiveEndDate(endDate);
			active.setActiveHost(host);
			active.setActiveLocation(location);
			active.setActiveStartDate(startDate);
		
			 
//			Active active=new Active(name, description, startDate, endDate, location, host);
			
			ActivesService activeService=new ActivesService();
			activeService.insertOneActive(active);
			
			res.sendRedirect(req.getContextPath()+"/showAllActiveController");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
