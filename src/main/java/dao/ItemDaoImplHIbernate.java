package dao;

import java.util.List;

import org.hibernate.Transaction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import model.Item;
import util.HibernateUtils;

public class ItemDaoImplHIbernate implements ItemDao {
	SessionFactory factory;
	public ItemDaoImplHIbernate() {
		factory = HibernateUtils.getSessionFactory();
	}
	
	
	@Override
	public void insert(Item item) throws SecurityException {
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(item);
		tx.commit();
	}

	@Override
	public void deleteById(int Pd_id) {
		
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Item item = session.get(Item.class,Pd_id);
		if(item!=null) {
			item.setPd_id(null);
			session.delete(item);
			tx.commit();
		}else {
			throw new RuntimeException("紀錄不存在，無法刪除");
		}
	
	}

	@Override
	public void updateItem(Item item) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(item);
		tx.commit();
	}

	@Override
	public Item selectItem(int Pd_id) {
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Item item = session.get(Item.class,Pd_id);
		tx.commit();
		return item;
	}

	@Override
	public List<Item> selectAll() {
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Item> items=session.createQuery("FROM Item",Item.class).getResultList();
		tx.commit();
		return items;
	}

	@Override
	public List<Item> search(String type, String word) {
		String sql=null;
		if(type.equals("pd_id")) {sql="FROM Item WHERE pd_id like :word";}
		else if(type.equals("pd_name")) {sql="FROM Item WHERE pd_name like :word";}
		else if(type.equals("pd_description")) {sql="FROM Item WHERE pd_description like :word";}
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Item> items=session.createQuery(sql,Item.class).setParameter("word", "%"+word+"%").getResultList();
		tx.commit();
		return items;
	}
	public void close() {
		factory.close();
	}

}
