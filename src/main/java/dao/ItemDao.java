package dao;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import model.Item;

public interface ItemDao {
	public void insert(Item item) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	public void deleteById(int Pd_id);
	public void updateItem(Item item);
	public Item selectItem(int Pd_id);
	public List<Item>  selectAll();
	public List<Item> search(String type,String word);
	public void close();
}
