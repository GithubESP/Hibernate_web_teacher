package t6_6.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_6.model.Dao.TempleDao;
import tw.hibernatedemo.util.HibernateUtil;

public class TempleDaoimpl implements TempleDao{
	
	private SessionFactory factory;
	public TempleDaoimpl() {
		this.factory =  HibernateUtil.getSessionFactory();
	}
	
	//搜尋
	public List<TempleBean> findById(String templeId) {
		Session session = factory.getCurrentSession();
//		return session.get(TempleBean.class, templeId);
		try {
//			session.beginTransaction();
			
			String hql = "from TempleBean where id="+templeId;
			
			Query<TempleBean>query=session.createQuery(hql, TempleBean.class);
			List<TempleBean> resultList = query.getResultList();
//			session.getTransaction().commit();
			return resultList;
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();
		}
		return null;
	}
	
	//找全部
	public List<TempleBean> sellectAll() {
		Session session = factory.getCurrentSession();
		try {
			Query<TempleBean> query = session.createQuery("from TempleBean order by templeId", TempleBean.class);
			List<TempleBean> beans = query.getResultList();
			return beans;
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();
		}
		return null;
	}

	//新增
	public TempleBean insertTemple(TempleBean tmpb) {
		Session session = factory.getCurrentSession();
		session.save(tmpb);

		return null;
	}
	
	//更改
	public TempleBean updateOneTemple(TempleBean tmpb) {
		Session session = factory.getCurrentSession();
//		session.beginTransaction();
		
		TempleBean tmpBean = session.get(TempleBean.class, tmpb.getTempleId());
		if(tmpBean != null) {
			tmpBean.setTempleName(tmpb.getTempleName());
			tmpBean.setDeitiesName(tmpb.getDeitiesName());
			tmpBean.setAdministrative(tmpb.getAdministrative());
			tmpBean.setAddress(tmpb.getAddress());
			tmpBean.setRegister(tmpb.getRegister());
			tmpBean.setSect(tmpb.getSect());
			tmpBean.setPhone(tmpb.getPhone());
			tmpBean.setPrincipal(tmpb.getPrincipal());
			tmpBean.setOther(tmpb.getOther());
			tmpBean.setWGS84X(tmpb.getWGS84X());
			tmpBean.setWGS84Y(tmpb.getWGS84Y());
			tmpBean.setUniformnumbers(tmpb.getUniformnumbers());
			session.getTransaction().commit();
		}
		
		return tmpBean;
	}
	
	//刪除
	public void deleteTemple(String templeId) {
		Session session = factory.getCurrentSession();
//		session.beginTransaction();
		TempleBean tmpBean = session.get(TempleBean.class, templeId);
		
		if(tmpBean != null) {
			session.delete(tmpBean);
		}
//		session.getTransaction().commit();
	}
}
//-----------------------------------------------------------------------	
	
	
//	public TempleBean findByTempleId(String TempleId) {
//		
//		String hql = "from Temple where id="+TempleId;
//		Session session = factory.getCurrentSession();
//		
//		try {
//			session.beginTransaction();
//			Query<TempleBean>query=session.createQuery(hql, TempleBean.class);
//			List<TempleBean>resultList = query.getResultList();
//			for(TempleBean tmp:resultList) {
//			System.out.println(tmp);
//			return tmp;
//			}
//			session.getTransaction().commit();
//		}catch(Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}finally {
//			HibernateUtil.closeSessionFactory();
//		}
//		return null;
//	}
	
	
//}
//	//查詢
//	public  List<templeBean> selectAll(String templeId) {
//		String sql="select * from Temple where templeId = ?";
//		try {
//			List<templeBean> beans= queryRunner.query(sql, new BeanListHandler<templeBean>(templeBean.class),templeId);
//			return beans;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		return null;
//	}
//	//新增
//	public void insertTemple(templeBean tmpb) throws SQLException {
//
//		String sql="insert into Temple (templeId,templeName,deitiesName,"
//				+ "administrative,address,register,sect,phone,principal,other,"
//				+ "WGS84X,WGS84Y,Uniform_numbers) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		Object[] parms= {tmpb.getTempleId(),tmpb.getTempleName(),tmpb.getDeitiesName(),tmpb.getAdministrative(),tmpb.getAddress(),tmpb.getRegister(),tmpb.getSect(),tmpb.getPhone(),tmpb.getPrincipal(),tmpb.getOther(),
//				tmpb.getWGS84X(),tmpb.getWGS84Y(),tmpb.getUniformnumbers()};
//		queryRunner.update(sql, parms);
//
//	}
//	//修改
//	public void updateTemple(templeBean tmpb) throws SQLException {
//
//		String sql="UPDATE Temple SET templeName=?, deitiesName=?, administrative=?, address=?, register=?, sect=?, phone=?, principal=?, other=?, WGS84X=?, WGS84Y=?, Uniform_numbers=? WHERE templeId = ?";
//		Object[] parms= {tmpb.getTempleName(),tmpb.getDeitiesName(),tmpb.getAdministrative(),tmpb.getAddress(),tmpb.getRegister(),tmpb.getSect(),tmpb.getPhone(),tmpb.getPrincipal(),tmpb.getOther(),
//				tmpb.getWGS84X(),tmpb.getWGS84Y(),tmpb.getUniformnumbers(),tmpb.getTempleId()};
//		queryRunner.update(sql, parms);
//
//	}
//	
//	//刪除
//	public void removeTmp(String templeId) throws SQLException {
//		
//		String sql="delete from Temple where templeId = ?";
//		try {
//			
//			int row = queryRunner.update(sql, templeId);
//			System.out.println(row);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public void updatePivture(InputStream input) throws SQLException, FileNotFoundException {
//		String sql="UPDATE Temple SET other=? where templeId='123'";
//		queryRunner.update(sql, input);
//	}
//}