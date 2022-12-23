package t6_21class.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_21class.bean.OrderBean;
import t6_21class.dao.OrderDao;
import t6_21class.util.HibernateUtil;


public class OrderDaoImpl implements OrderDao{
	
	private SessionFactory factory;

	public OrderDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}


	@Override
	public int save(OrderBean ob) {
//		String sql = "INSERT INTO OrderTable " 
//				+ " (memberId, customerEmail, customerPhone, "
//				+ " orderStatus, orderDate,orderPrice) " 
//				+ " VALUES (?, ?, ?, ?, ?, ?)";
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			OrderBean oBean = session.get(OrderBean.class,ob.getOrderNumber());
			session.save(ob);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return 0;
			
	}

	@Override
	public OrderBean findById(int orderNumber) {
		String hql = "from OrderBean where orderNumber=?";
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Query<OrderBean> query = session.createQuery(hql, OrderBean.class)
					.setParameter(1, orderNumber);

			OrderBean result = query.getSingleResult();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}
		return null;
	}

	@Override
	public List<OrderBean> findByMemberId(int memberId) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Query<OrderBean> query = session.createQuery("from OrderBean", OrderBean.class);
			List<OrderBean> result = query.getResultList();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return null;
	}


}
