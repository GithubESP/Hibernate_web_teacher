package t6_10.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import t6_10.service.AccountService;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;
	SessionFactory factory = HibernateUtil.getSessionFactory();

//	public AccountServiceImpl(Session session) {
//		accountDao=new AccountDaoImpl();
//	}
	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}

	@Override
	public List<Account> showAllAccount() {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Account> accountList = null;
			List<Account> temp = accountDao.selectAll();
			if (temp != null) {
				accountList = temp;
			}
			session.getTransaction().commit();
			return accountList;
		} catch (Exception e) {
			System.out.println("RollBack(showAllAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean removeAccount(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			boolean result = accountDao.delete(id);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(removeAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Account modify(Account account) {
		Session session = factory.getCurrentSession();
		try {
			System.out.println(1);
			session.beginTransaction();
			System.out.println(2);
			System.out.println(account);
			System.out.println("modify"+session);
			Account result = accountDao.update(account);
			System.out.println(3);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(modify)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Account showAccount(int id) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Account account = accountDao.select(id);
			session.getTransaction().commit();
			return account;
		} catch (Exception e) {
			System.out.println("RollBack(showAccount)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Account add(Account account) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Account result = accountDao.add(account);
			System.out.println("result"+result);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			System.out.println("RollBack(add)");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}
}
