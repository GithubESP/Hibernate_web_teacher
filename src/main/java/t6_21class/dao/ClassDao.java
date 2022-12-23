package t6_21class.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import t6_21class.bean.ClassBean;


public interface ClassDao {
	//所有產品的展現
	public List<ClassBean> selectAll();
	//透過id來找尋課程資料
	public ClassBean findById(int classId);
	//透過id來刪除課程資料
	public ClassBean delete(int id); 
	//修改課程資料
	ClassBean save(ClassBean classBean);
    //新增課程資料
	int updateClass(ClassBean classBean, long sizeInBytes) ;    
	public int updateClass(ClassBean classBean);
	


}
