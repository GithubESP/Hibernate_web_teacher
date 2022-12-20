package t6_10.service;


import java.util.List;

import t6_10.bean.Account;

public interface AccountService {
	public List<Account> showAllAccount();
	
	public Account showAccount(int id);
	
	public boolean removeAccount(int id);
	
	public Account modify(Account account);
	
	public Account add(Account account);

}
