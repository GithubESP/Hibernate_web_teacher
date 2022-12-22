package t6_6.Action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_6.model.TempleBean;
import t6_6.model.TempleDaoimpl;
import tw.hibernatedemo.model.Member;
import tw.hibernatedemo.model.MemberDao;
import tw.hibernatedemo.util.HibernateUtil;

public class TempleAction {

	public static TempleDaoimpl tmpDao;
	
	public void MemberLoginService() {
		this.tmpDao = new TempleDaoimpl();
	}
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		//新增
		try {
			session.beginTransaction();
			
			Query<TempleBean> query = session.createQuery("from TempleBean", TempleBean.class);
			List<TempleBean> beans = query.getResultList();
			
			for(TempleBean tmp:beans) {
				System.out.println(tmp);
			}
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
		
		
		//查詢
//		try {
//			session.beginTransaction();
//			
//			String hql = "from TempleBean where id = 12";
//			
//			Query<TempleBean>query=session.createQuery(hql, TempleBean.class);
//			List<TempleBean>resultList = query.getResultList();
//			
//			for(TempleBean tmp:resultList) {
//				System.out.println(tmp);
//			}
//			
//			session.getTransaction().commit();
//		}catch(Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}finally {
//			HibernateUtil.closeSessionFactory();
//		}
	}
}
