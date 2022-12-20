package t6_10.impl;

import java.util.List;

import org.hibernate.Session;

import t6_10.bean.Account;
import t6_10.dao.AccountDao;
import t6_10.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDao accountDao;
	
//	public AccountServiceImpl(Session session) {
//		accountDao=new AccountDaoImpl();
//	}
	public AccountServiceImpl() {
		accountDao=new AccountDaoImpl();
	}
	
	@Override
	public List<Account> showAllAccount() {
		List<Account> accountList=null;
		
		List<Account> temp= accountDao.selectAll();
		if(temp!=null) {
			accountList=temp;
		}
		return accountList;
	}
	@Override
	public boolean removeAccount(int id) {
		boolean result=accountDao.delete(id);
		return result;
		
	}
	@Override
	public Account modify(Account account) {
		Account result= accountDao.update(account);
		return result;
	}
	
	
	@Override
	public Account showAccount(int id) {
		Account account=accountDao.select(id);
		return account;
	}
	@Override
	public Account add(Account account) {
		Account result= accountDao.add(account);
		return result;
	}

}
