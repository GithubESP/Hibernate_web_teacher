package t6_21class.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_21class.bean.MemberBean;
import t6_21class.dao.MemberServiceDao;
import t6_21class.util.HibernateUtil;


public class MemberServiceDaoImpl implements MemberServiceDao{
	
	private SessionFactory factory;

	public MemberServiceDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	public MemberBean select(String username) {
		
		String hql="from MemberBean where memberAccount=?1";
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Query<MemberBean> query = session.createQuery(hql, MemberBean.class)
					.setParameter(1,username);

			MemberBean result = query.getSingleResult();
			session.getTransaction().commit();

			return result;
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
		

}

}
