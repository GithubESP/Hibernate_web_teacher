package t6_10.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_10.bean.AccountManager;
import t6_10.dao.AccountManagerDao;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountManagerDaoImpl implements AccountManagerDao{
	
	private SessionFactory factory=HibernateUtil.getSessionFactory();
	private Session session = factory.getCurrentSession();
	
	
	public AccountManagerDaoImpl() {
	}
	
//	public AccountManagerDaoImpl(Session session) {
//		this.session = session;
//	}
	
	public Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public AccountManager select(String username) {
		return session.get(AccountManager.class, username);
	}
}
