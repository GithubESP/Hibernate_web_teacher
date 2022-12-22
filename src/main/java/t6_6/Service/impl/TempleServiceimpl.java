package t6_6.Service.impl;

import java.util.List;
import t6_6.Service.TempleService;
import t6_6.model.TempleBean;
import t6_6.model.Dao.TempleDao;

public class TempleServiceimpl implements TempleService {
	
	private TempleDao tmpDao;
	
	@Override
	public List<TempleBean> findById(String templeId) {
		return tmpDao.findById(templeId);
	}

	@Override
	public List<TempleBean> sellectAll() {
		return tmpDao.sellectAll();
	}

	@Override
	public TempleBean insertTemple(TempleBean tmpb) {
		return tmpDao.insertTemple(tmpb);
	}

	@Override
	public TempleBean updateOneTemple(TempleBean tmpb) {
		return tmpDao.updateOneTemple(tmpb);
	}

	@Override
	public void deleteTemple(String templeId) {
		tmpDao.deleteTemple(templeId);		
	}

}
