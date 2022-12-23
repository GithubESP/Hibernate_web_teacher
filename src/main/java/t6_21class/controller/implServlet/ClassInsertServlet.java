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


@WebServlet("/ClassInsertServlet.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
public class ClassInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(ClassInsertServlet.class);

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
		ClassBean cb = new ClassBean();

		try {
//			String classIdStr = "";
//			int classId = 0;

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
						
//						if (fldName.equals("id")) {
//							classIdStr = value;
//							classIdStr = classIdStr.trim();
//							if (classIdStr == null || classIdStr.trim().length() == 0) {
//								errorMsgs.put("errclassId", "必須輸入編號");
//							} else {
//								try {
//									classId = Integer.parseInt(classIdStr);
//									cb.setClassId(classId);
//								} catch (Exception e) {
//									errorMsgs.put("errclassId", "必須輸入編號");
//								}
//							}
//     					request.setAttribute("id", classId);
//						} 
					if (fldName.equals("name")) {
							className = value;
							cb.setClassName(className);
							if (className == null || className.trim().length() == 0) {
								errorMsgs.put("errclassName", "必須輸入課程名稱");
							} else {
								request.setAttribute("name", className);
							}
						} else if (fldName.equals("teacher")) {
							classTeacher = value;
							cb.setClassTeacher(classTeacher);
							if (classTeacher == null || classTeacher.trim().length() == 0) {
								errorMsgs.put("errclassTeacher", "必須輸入老師名稱");
							} else {
								request.setAttribute("teacher", classTeacher);
							}

						} else if (fldName.equals("price")) {
							classPriceStr = value;
							classPriceStr = classPriceStr.trim();
							if (classPriceStr == null || classPriceStr.trim().length() == 0) {
								errorMsgs.put("errclassPrice", "必須輸入價格");
							} else {
								try {
									classPrice = Double.parseDouble(classPriceStr);
									cb.setClassPrice(classPrice);
								} catch (Exception e) {
									errorMsgs.put("errclassPrice", "必須輸入數值");
								}
							}
							request.setAttribute("price", classPriceStr);
						} else if (fldName.equals("category")) {
							classCategory = value;
							cb.setClassCategory(classCategory);
							if (classCategory == null || classCategory.trim().length() == 0) {
								errorMsgs.put("errclassCategory", "必須輸入種類");
							}
							request.setAttribute("category", classCategory);
						}
					} else {
						fileName = DBService.getFileName(p); // 由變數 p 中取出檔案名稱
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
			} else {

				errorMsgs.put("errclassName", "此表單不是上傳的表單");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/t6_21class/classUpdateList.jsp");
				rd.forward(request, response);
				return;
			}
			ClassDao classDao = new ClassDaoImpl();
			Blob blob = null;
			if (sizeInBytes != -1) {
				blob = DBService.fileToBlob(is, sizeInBytes);
			}
			ClassBean newBean = new ClassBean(className, classTeacher, classPrice, classCategory, blob);

			classDao.save(newBean);
			response.sendRedirect(request.getContextPath() + "/controller/classListMaintainServlet");
//			RequestDispatcher rd = request.getRequestDispatcher("/controller/classListMaintainServlet");
//			rd.forward(request, response);
//			log.info("更新書籍之Controller, 成功，newBean=" + newBean);
//			return;

		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("errDBMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/class/classUpdateList.jsp");
			rd.forward(request, response);

		}
	}

	public String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}