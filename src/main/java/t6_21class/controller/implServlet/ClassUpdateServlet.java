package t6_21class.controller.implServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.ClassBean;
import t6_21class.createTable.DBService;
import t6_21class.dao.ClassDao;
import t6_21class.impl.ClassDaoImpl;


@WebServlet("/ClassUpdateServlet.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
public class ClassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(ClassUpdateServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("ErrMsg", errorMsgs);
		ClassBean cb =new ClassBean();


		try {
			String className = "";
			String classTeacher = "";
			
			String classPriceStr = "";
			double classPrice = 0;
			
			String classCategory = "";
			
			long sizeInBytes = 0;
			String fileName = "";
			String mimeType = "";
			InputStream is = null;
			
			Collection<Part> parts = request.getParts();
			if (parts != null) {
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {

						if (fldName.equals("name")) {
							className = value;
							cb.setClassName(className);
							if (className == null || className.trim().length() == 0) {
								errorMsgs.put("errclassName", "????????????????????????");
							} else {
								request.setAttribute("name", className);
							}
						} else if (fldName.equals("teacher")) {
							classTeacher = value;
							cb.setClassTeacher(classTeacher);
							if (classTeacher == null || classTeacher.trim().length() == 0) {
								errorMsgs.put("errclassTeacher", "????????????????????????");
							} else {
								request.setAttribute("teacher", classTeacher);
							}
							
						} else if (fldName.equals("price")) {
							classPriceStr = value;
							classPriceStr = classPriceStr.trim();
							if (classPriceStr == null || classPriceStr.trim().length() == 0) {
								errorMsgs.put("errclassPrice", "??????????????????");
							} else {
								try {
									classPrice = Double.parseDouble(classPriceStr);
									cb.setClassPrice(classPrice);
								} catch (Exception e) {
									errorMsgs.put("errclassPrice", "??????????????????");
								}
							}
							request.setAttribute("price", classPriceStr);
						}else if(fldName.equals("category")) {
							classCategory = value;
							cb.setClassCategory(classCategory);
							if(classCategory == null || classCategory.trim().length() == 0) {
								errorMsgs.put("errclassCategory", "??????????????????");
							}
							request.setAttribute("category", classCategory);
						}
					}else {
						fileName = DBService.getFileName(p); // ????????? p ?????????????????????
						if (fileName != null && fileName.trim().length() > 0) {
							fileName = DBService.adjustFileName(fileName, DBService.IMAGE_FILENAME_LENGTH);
							mimeType = getServletContext().getMimeType(fileName);
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							sizeInBytes = -1;
						}
						
					}
				}
			}else {
				errorMsgs.put("errclassName", "??????????????????????????????");
			}
			if(!errorMsgs.isEmpty()) {
				   RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/classUpdateList.jsp");
				   rd.forward(request, response);
				   return;
			}
			ClassDao classDao = new ClassDaoImpl();
			Blob blob = null;
			if (sizeInBytes != -1){
				blob = DBService.fileToBlob(is, sizeInBytes);
			}
			String cId = request.getParameter("id");
			
			Integer classId = Integer.valueOf(cId);
			
			ClassBean newBean = new ClassBean(classId, className,classTeacher, classPrice, classCategory, blob);
			
//			System.out.print(newBean.toString());
			classDao.updateClass(newBean, sizeInBytes); 
			
			response.sendRedirect(request.getContextPath()+
			         "/controller/classListMaintainServlet");
//			RequestDispatcher rd = request.getRequestDispatcher("/controller/classListMaintainServlet");
//			rd.forward(request, response);
//			log.info("???????????????Controller, ?????????newBean=" + newBean);
//			return;


		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("errDBMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/classUpdateList.jsp");
			rd.forward(request, response);


		}
	}
}