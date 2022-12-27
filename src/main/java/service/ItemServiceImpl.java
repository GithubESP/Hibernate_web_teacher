package service;

import dao.ItemDao;
import dao.ItemDaoImpl;
import model.Item;

public class ItemServiceImpl implements ItemService {
	ItemDao  Idao = new ItemDaoImpl();

	@Override
	public Item findById(int i) {
		return Idao.selectItem(i);
	}
}
