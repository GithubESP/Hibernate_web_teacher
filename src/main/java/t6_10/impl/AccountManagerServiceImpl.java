package t6_10.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_10.bean.AccountManager;
import t6_10.dao.AccountManagerDao;
import t6_10.service.AccountManagerService;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountManagerServiceImpl implements AccountManagerService {
//AccountManagerDao accountDao=new AccountManagerDaoImpl();
	private AccountManagerDao accountManagerDao;
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public AccountManagerServiceImpl() {
		accountManagerDao = new AccountManagerDaoImpl();
//		AccountDaoImpl acoAccountDaoImpl = new AccountManagerServiceImpl();
//		accountManagerDao = new AccountManagerService();
	}

	@Override
	public AccountManager login(String username, String password) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			AccountManager accountManager = null;
			AccountManager temp = accountManagerDao.select(username);
			if (temp != null) {
				if (temp.getPassword().equals(password)) {
					accountManager = temp;
				}
			}
			session.getTransaction().commit();
			return accountManager;
		} catch (Exception e) {
			System.out.println("RollBack(showAllAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		
	}

}
