package t6_6.Service;

import java.util.List;

import t6_6.model.TempleBean;

	public interface TempleService {
			//搜尋
			public List<TempleBean> findById(String templeId);
			
			//找全部
			public List<TempleBean> sellectAll();
			
			//新增
			public TempleBean insertTemple(TempleBean tmpb);
			
			//更改
			public TempleBean updateOneTemple(TempleBean tmpb);
			
			//刪除
			public void deleteTemple(String templeId);
	}

