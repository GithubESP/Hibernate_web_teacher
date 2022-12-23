package t6_14Actives.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import t6_14Actives.util.HibernateUtil;

public interface ActivesDao {
	


		
		
		
		 
		 public List<Actives> selectAll();
		 
		 
		 
		 public Actives findById(Integer id);
			 
			 
			
		 
		 
		 
		public Boolean deleteById(Integer id);
			
			
			
		
		
		public Actives updateActives(Actives actives);
		
		public Actives insertActive(Actives active) ;
		 
		 
		 
		 
		

	}
