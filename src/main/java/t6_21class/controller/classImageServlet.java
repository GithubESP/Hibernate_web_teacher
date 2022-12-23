package t6_21class.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_21class.bean.ClassBean;
import t6_21class.dao.ClassDao;
import t6_21class.impl.ClassDaoImpl;


@WebServlet("/controller/classImage")
public class classImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(classImageServlet.class);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			ClassDao classService = new ClassDaoImpl();
			int nId = 0;
			try {
				nId = Integer.parseInt(id);
			} catch(NumberFormatException ex) {
				;
			}
			ClassBean bean = classService.findById(nId);
			
			if (bean != null) {
				blob = bean.getClassPicture();
				if (blob != null) {
					is = blob.getBinaryStream();

				}
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)	

			// 設定輸出資料的MIME型態
			response.setContentType("jpg/png");
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();	
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (is != null) is.close();
			if (os != null) os.close();
			
		}
	}
}