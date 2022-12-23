package t6_21class.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_21class.bean.ClassBean;
import t6_21class.dao.ClassDao;
import t6_21class.util.HibernateUtil;


public class ClassDaoImpl implements ClassDao {
	private SessionFactory factory;

	public ClassDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<ClassBean> selectAll() {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query<ClassBean> query = session.createQuery("from ClassBean", ClassBean.class);
			List<ClassBean> result = query.getResultList();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public ClassBean delete(int classId) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			ClassBean classBean = session.get(ClassBean.class,classId);
			session.delete(classBean);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public ClassBean findById(int classId) {
		String hql = "from ClassBean where classId=?1";
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Query<ClassBean> query = session.createQuery(hql, ClassBean.class)
					.setParameter(1, classId);

			ClassBean result = query.getSingleResult();
			
			session.getTransaction().commit();
			return result;

		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return null;
	}


	public int updateClass(ClassBean classBean, long sizeInBytes) {
		String hql = "UPDATE ClassBean SET " + "className=?1,  classTeacher=?2, classPrice = ?3, "
				+ " classPicture=?4, classCategory=?5 where classId=?6";
		Session session = factory.getCurrentSession();

		if (sizeInBytes == -1) { // 不修改圖片
			int r = updateClass(classBean);// 取用另一個沒圖片的更新方法
			return r;
		}
		try {
			session.beginTransaction();
			session.createQuery(hql)
					.setParameter(1, classBean.getClassName())
					.setParameter(2, classBean.getClassTeacher())
					.setParameter(3, classBean.getClassPrice())
					.setParameter(4, classBean.getClassPicture())
					.setParameter(5, classBean.getClassCategory())
					.setParameter(6, classBean.getClassId())
					.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateClass(ClassBean classBean) {
		String hql = "update ClassBean set className=?1,classTeacher=?2,classPrice=?3,classCategory=?4 where classId=?5";
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.createQuery(hql)
					.setParameter(1, classBean.getClassName())
					.setParameter(2, classBean.getClassTeacher())
					.setParameter(3, classBean.getClassPicture())
					.setParameter(4, classBean.getClassCategory())
					.setParameter(5, classBean.getClassId())
					.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ClassBean save(ClassBean classBean) {
		Session session = factory.getCurrentSession();


		try {

		session.beginTransaction();
		
		ClassBean cBean = session.get(ClassBean.class,classBean.getClassId());
		session.save(classBean);

		
		session.getTransaction().commit();
		
	} catch (Exception e) {
		session.getTransaction().rollback();
		e.printStackTrace();
	}
	return null;
}

}
