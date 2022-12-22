package t6_10.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import tw.hibernatedemo.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao{
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
//	private Session session = factory.getCurrentSession();
	
	// 依賴注入，Dependency Injection
	//	public AccountDaoImpl(Session session) {
	//		this.session = session;
	//	}
	
//	public Session getSession() {
//		return session;
//	}
//	
	public AccountDaoImpl() {
	
	}

	@Override
	public List<Account> selectAll(){
		Session session = factory.getCurrentSession();
    	Query<Account> query = session.createQuery("from Account ORDER BY id ASC", Account.class);
    	List<Account> result = query.getResultList();
    	System.out.println(result);
    	return result;
	}	
	
	@Override
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		Account account = session.get(Account.class, id);
		
		if(account != null) {
			session.delete(account);
			return true;
		}
		return false;
	}
	
	@Override
	public Account update(Account account) {
		Session session = factory.getCurrentSession();
		Account accountBean = session.get(Account.class, account.getId());
		if(accountBean != null) {
			accountBean.setAccount(account.getAccount());
			accountBean.setPassword(account.getPassword());
			accountBean.setImage(account.getImage());
		}
		return accountBean;
	}
	
	@Override
	public Account select(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Account.class, id);
	}

	@Override
	public Account add(Account account) {
		Session session = factory.getCurrentSession();
			System.out.println("account: "+account);
			session.save(account);
			System.out.println("save account: "+account);
			return account;
	}
}
