package kr.or.ddit.sessionlogin.service;

import kr.or.ddit.sessionlogin.dao.MemberDaoImpl;
import kr.or.ddit.sessionlogin.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private static MemberServiceImpl instance;
	
	private MemberDaoImpl dao;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(instance==null) instance = new MemberServiceImpl();
		
		return instance;
	}
	

	@Override
	public MemberVO getLoginMember(MemberVO memvo) {
		
		return dao.getLoginMember(memvo);
	}

}
