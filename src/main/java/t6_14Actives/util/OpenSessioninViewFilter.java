//package t6_14Actives.util;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//@WebFilter("/Transaction/*")
//public class OpenSessioninViewFilter extends HttpFilter implements Filter {
//       
//   private Session session;
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		
//		
//		try {
//			SessionFactory factory=HibernateUtil.getSessionFactory();
//		this.session=factory.openSession();
//		
//		session.beginTransaction();
//		System.out.println("begin transaction");
//		
//		chain.doFilter(request, response);
//		
//		session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			System.out.println("roll back!!!");
//			e.printStackTrace();
//		}finally {
//			System.out.println("close!!");
//		}
//		
//		
//	}
//
//	
//
//}
