package t6_14Actives.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_14Actives.util.HibernateUtil;


public class ActivesDaoImpl implements ActivesDao{
private SessionFactory factory;
private Session session;


	
	public ActivesDaoImpl() {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		this.factory=HibernateUtil.getSessionFactory();
	}
	
	 
	 public List<Actives> selectAll(){
		 String hql="from Actives";
		 try {
			 Session session=factory.getCurrentSession();
		 session.beginTransaction();
			Query<Actives> query=session.createQuery(hql,Actives.class);
		 List<Actives> result=query.getResultList();
		 session.getTransaction().commit();
		 return result;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("發生錯誤");
			return null;
		}
		 
	 }
	 
	 
	 
	 public Actives findById(Integer id){
		
		 
		 try {
			  Session session=factory.getCurrentSession();
			  session.beginTransaction();
			Actives active= session.get(Actives.class, id);
			session.getTransaction().commit();
		return active;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("發生錯誤");
			return null;
		}
		 
		 
		 
		
	 }
	 
	 
	public Boolean deleteById(Integer id) {
		Session session=factory.getCurrentSession();
		
		
		
		 try {
			 
			  session.beginTransaction();
			Actives active= session.get(Actives.class, id);
			session.delete(active);
			session.getTransaction().commit();
		return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("發生錯誤");
			return false;
		}}
		
		
		
	
	
	public Actives updateActives(Actives actives) {
		Session session=factory.getCurrentSession();
		
		 try {
			 
			  session.beginTransaction();
			Actives act= session.get(Actives.class, actives.getActiveID());
			
			if(act!=null) {
				act.setActiveDescription(actives.getActiveDescription());
				act.setActiveEndDate(actives.getActiveEndDate());
				act.setActiveHost(actives.getActiveHost());
				act.setActiveImg(actives.getActiveImg());
				act.setActiveLocation(actives.getActiveLocation());
				act.setActiveStartDate(actives.getActiveStartDate());
				act.setActiveName(actives.getActiveName());
			}
			
			session.getTransaction().commit();
		return act;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("發生錯誤");
			return null;
		}
	 
	 
	}
	
	public Actives insertActive(Actives active) {
		
		try {
			Session session=factory.getCurrentSession();
		 session.beginTransaction();
		 
			 session.save(active);
			 session.getTransaction().commit();
			 return active;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("發生錯誤");
			return null;
		}
	}
	 
	 
	 
	 
	

}
