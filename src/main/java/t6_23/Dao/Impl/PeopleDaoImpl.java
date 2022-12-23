package t6_23.Dao.Impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_23.Dao.PeopleDao_23;
import t6_23.bean.PeopleBean_23;
import tw.hibernatedemo.util.HibernateUtil;

public class PeopleDaoImpl implements PeopleDao_23 {

	private SessionFactory factory;
	
	public PeopleDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	
	
	@Override
	public List<PeopleBean_23> selectAll() {
		Session session = factory.getCurrentSession();
		try {
		Query<PeopleBean_23> query = session.createQuery("from PeopleBean_23", PeopleBean_23.class);
		
		List<PeopleBean_23> result = query.getResultList();
	
		return result;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PeopleBean_23 selectById(Integer id) {
		Session session = factory.getCurrentSession();
		
		try {
		return session.get(PeopleBean_23.class, id);
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		Session session = factory.getCurrentSession();
		try {
		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, id);
		
		if(peoBean!=null) {
			session.delete(peoBean);
			return true;
		}
		return false;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PeopleBean_23 update(PeopleBean_23 bean) {
		Session session = factory.getCurrentSession();
		try {
		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, bean.getUserID());
		
//		if(peoBean.getUserID()!=null) {
			peoBean.setName(bean.getName());
			peoBean.setAge(bean.getAge());
//			peoBean.setSex(bean.getSex());
			peoBean.setAddress(bean.getAddress());
			peoBean.setStar(bean.getStar());
			peoBean.setEmotion(bean.getEmotion());
			peoBean.setProfession(bean.getProfession());
			peoBean.setPersonality(bean.getPersonality());
			peoBean.setHobby(bean.getHobby());
			peoBean.setDream(bean.getDream());
			peoBean.setIntroduction(bean.getIntroduction());
			peoBean.setImages(bean.getImages());
			peoBean.setReligion(bean.getReligion());
			peoBean.setSex_in(bean.getSex_in());
			peoBean.setIncome(bean.getIncome());
//		}
		return peoBean;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(PeopleBean_23 bean) {
		Session session = factory.getCurrentSession();
		try {
		PeopleBean_23 peoBean = session.get(PeopleBean_23.class, bean.getUserID());
		
		if(peoBean==null) {
			session.save(bean);
		}
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PeopleBean_23 findImageById(Integer Id) {
		String hql = "select pb.Images from PeopleBean_23 pb where pb.userID = :Id";
		Session session = factory.getCurrentSession();
		try {
		PeopleBean_23 result = session.createQuery(hql, PeopleBean_23.class)
		.setParameter("Id", Id)
		.getSingleResult();
		return result;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PeopleBean_23> selectByName(String name) {
		String hql = "from PeopleBean_23 pb where pb.Name like :name";
		Session session = factory.getCurrentSession();
		try {
		List<PeopleBean_23> result = session.createQuery(hql, PeopleBean_23.class)
				.setParameter("name", "%"+name+"%")
				.getResultList();
		
		return result;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
	}

}
