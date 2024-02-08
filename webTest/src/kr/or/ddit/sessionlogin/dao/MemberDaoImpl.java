package kr.or.ddit.sessionlogin.dao;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.sessionlogin.vo.MemberVO;
import kr.or.ddit.util.MybatisUtil;

public class MemberDaoImpl implements IMemeberDao{

	private static MemberDaoImpl instance;
	
	private MemberDaoImpl() { }
	
	public static MemberDaoImpl getInstance() {
		
		if(instance==null) instance= new MemberDaoImpl();
		return instance;
	}
	
	
	
	@Override
	public MemberVO getLoginMember(MemberVO memvo) {
		MemberVO vo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("mymember.getLoginMember",memvo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return vo;
	}

}
