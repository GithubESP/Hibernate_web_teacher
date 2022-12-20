package t6_10.dao;

import java.sql.Blob;
import java.util.List;

import javax.servlet.http.Part;

import t6_10.bean.Account;

public interface AccountDao {
	
	public List<Account> selectAll();
	
	public Account select(Integer id);
	
	public boolean delete(Integer id); 
	
//	public int update(Account account, Blob image); 
    	
	public Account update(Account account);//多加圖片

	public Account add(Account account);
	




    
    

}
