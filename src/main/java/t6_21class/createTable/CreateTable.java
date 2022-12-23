package t6_21class.createTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import t6_21class.util.HibernateUtil;


public class CreateTable {
	
	
	public static void main(String args[]) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		String hql1 ="Create TABLE OrderTable "
				+ "(orderNumber int NOT NULL IDENTITY Primary Key, "
				+ " memberId	    int, " 
				+ " customerEmail    	varchar(50), " 
				+ " customerPhone    	varchar(50), " 
				+ " orderStatus    	varchar(50), " 
				+ " orderDate    	datetime2, " 
				+ " orderPrice    	Money, " 
				+ " )";

		String hql2="Create TABLE classTables "
				+ "(classId int NOT NULL IDENTITY Primary Key, "
				+ " className			varchar(50), " 
				+ " classTeacher    	varchar(28), " 
				+ " classPrice			Money, "
				+ " classPicture		varbinary(max), "
				+ " classCategory		varchar(28), " 
				+ " )";
		String hql3="Create TABLE MemberTable "
				+ "(memberId int NOT NULL IDENTITY Primary Key,, "
				+ " memberAccount	    varchar(50), " 
				+ " memberPassword    	varchar(50), " 
				+ " )";
		try {
			session.beginTransaction();
			session.createQuery(hql1).executeUpdate();
			session.createQuery(hql2).executeUpdate();
			session.createQuery(hql3).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
