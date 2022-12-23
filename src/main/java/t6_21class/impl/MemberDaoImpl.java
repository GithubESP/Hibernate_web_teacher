package t6_21class.impl;

import t6_21class.bean.MemberBean;
import t6_21class.dao.MemberDao;
import t6_21class.dao.MemberServiceDao;

public class MemberDaoImpl implements MemberDao {
	
	MemberServiceDao memberServiceDao=new MemberServiceDaoImpl();

	@Override
	public MemberBean login(String username, String password) {
		
		MemberBean member= null;
		
		MemberBean memberBean= memberServiceDao.select(username);
		if(memberBean!=null) {
			
			if(memberBean.getMemberPassword().equals(password)) {
				member=memberBean;
			}
		}
		return member;
	}
	
	}


