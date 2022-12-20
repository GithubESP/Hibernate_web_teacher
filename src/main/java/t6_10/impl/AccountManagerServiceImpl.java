package t6_10.impl;

import t6_10.bean.AccountManager;
import t6_10.dao.AccountManagerDao;
import t6_10.service.AccountManagerService;

public class AccountManagerServiceImpl implements AccountManagerService{
AccountManagerDao accountDao=new AccountManagerDaoImpl();
	@Override
	public AccountManager login(String username, String password) {
		AccountManager accountManager= null;
		AccountManager temp=accountDao.select(username);
		if(temp!=null) {
			if(temp.getPassword().equals(password)) {
				accountManager=temp;
			}
		}
		return accountManager;
	}

}
