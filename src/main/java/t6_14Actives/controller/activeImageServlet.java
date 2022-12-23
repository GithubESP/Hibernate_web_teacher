package t6_14Actives.controller;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import t6_14Actives.model.Actives;
import t6_14Actives.model.ActivesDaoImpl;
import t6_14Actives.service.ActivesService;
import t6_14Actives.util.HibernateUtil;


@WebServlet("/toActiveImage")
public class activeImageServlet extends HttpServlet {
	private Session session;
	private static Logger log = LoggerFactory.getLogger(activeImageServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	OutputStream os = null;
        InputStream is = null;
        Blob blob = null;
        try {
            // 讀取瀏覽器傳送來的主鍵
            String id = req.getParameter("id");
            // 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
            ActivesService service=new ActivesService();
            int nId = 0;
            try {
                nId = Integer.parseInt(id);
            } catch(NumberFormatException ex) {
                ;
            }
            
     
           
             Actives	bean = service.findBId(nId); ///findById
 
 
            
            if (bean != null) {
                blob = bean.getActiveImg();
                System.out.println("圖片"+nId+" 大小 : "+blob.length());
                if (blob != null) {
                    is = blob.getBinaryStream();

                }
            }
            // 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
            resp.setContentType("jpg/png");//"jpg/png"
// 取得能寫出非文字資料的OutputStream物件
            os = resp.getOutputStream();
            // 由InputStream讀取位元組，然後由OutputStream寫出
            int len = 0;
            byte[] bytes = new byte[8192];
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            log.info("送出圖片, id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (is != null) is.close();
            if (os != null) os.close();

        }
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}