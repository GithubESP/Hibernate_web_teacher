package t6_23.Dao;

import java.util.List;

import t6_23.bean.PeopleBean_23;

public interface PeopleDao_23 {
	
	public List< PeopleBean_23> selectAll();
	
	public  PeopleBean_23 selectById(Integer id);
	
	public boolean delete(Integer id); 
    
    public PeopleBean_23 update( PeopleBean_23 bean); 
    
    void save(PeopleBean_23 bean);//insert

	PeopleBean_23 findImageById(Integer Id);
    
	public List<PeopleBean_23> selectByName(String name);

}
