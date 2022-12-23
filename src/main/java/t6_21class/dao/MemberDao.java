package t6_21class.dao;

import t6_21class.bean.MemberBean;

public interface MemberDao {
	public MemberBean login(String username,String password);

}
