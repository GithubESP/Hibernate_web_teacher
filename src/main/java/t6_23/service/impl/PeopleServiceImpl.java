package t6_23.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_23.Dao.PeopleDao_23;
import t6_23.Dao.Impl.PeopleDaoImpl;
import t6_23.bean.PeopleBean_23;
import t6_23.service.PeopleService;
import tw.hibernatedemo.util.HibernateUtil;

public class PeopleServiceImpl implements PeopleService {

	private PeopleDao_23 peoDao;
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public PeopleServiceImpl() {
		this.peoDao = new PeopleDaoImpl();
	}

	@Override
	public List<PeopleBean_23> selectAll() {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<PeopleBean_23> selectAll = peoDao.selectAll();
			session.getTransaction().commit();
			return selectAll;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PeopleBean_23 selectById(Integer id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			PeopleBean_23 selectById = peoDao.selectById(id);
			session.getTransaction().commit();
			return selectById;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			boolean delete = peoDao.delete(id);
			session.getTransaction().commit();
			return delete;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PeopleBean_23 update(PeopleBean_23 bean) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			PeopleBean_23 update = peoDao.update(bean);
			session.getTransaction().commit();
			return update;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(PeopleBean_23 bean) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			peoDao.save(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public PeopleBean_23 findImageById(Integer Id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			PeopleBean_23 findImageById = peoDao.findImageById(Id);
			session.getTransaction().commit();
			return findImageById;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PeopleBean_23> selectByName(String name) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<PeopleBean_23> selectByName = peoDao.selectByName(name);
			session.getTransaction().commit();
			return selectByName;
		} catch (Exception e) {
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

}
