package t6_14Actives.service;

import java.util.List;

import org.hibernate.Session;

import t6_14Actives.model.Actives;
import t6_14Actives.model.ActivesDaoImpl;


public class ActivesService {
	
private ActivesDaoImpl actDao;
	
	public  ActivesService() {
	this.actDao=new ActivesDaoImpl();
	}
	
	public List<Actives> findAll() {
		return actDao.selectAll();
	}
	
	public Actives findBId(Integer id) {
		return actDao.findById(id);
	}
	
	public Boolean deleteById(Integer id) {
		return actDao.deleteById(id);
	}
	
	public Actives updateOneActive(Actives active) {
		return actDao.updateActives(active);
	}
	
	public Actives insertOneActive(Actives active) {
		return actDao.insertActive(active);
	}
	


}
