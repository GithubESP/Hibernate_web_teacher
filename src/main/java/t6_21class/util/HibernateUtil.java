package t6_21class.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory factory = CreateSessionFactory();
	
	private static SessionFactory CreateSessionFactory() {
		StandardServiceRegistry service = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(service).buildMetadata().buildSessionFactory();
		return factory;
		
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static void closeSessionFactory() {
		if(factory != null) {
			factory.close();
		}
	}
	
}
