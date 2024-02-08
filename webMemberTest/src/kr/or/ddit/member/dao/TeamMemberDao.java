package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.TeamMemberVO;
import kr.or.ddit.util.MybatisUtil;

public class TeamMemberDao implements ITeamMemberDao{

	private static TeamMemberDao instance;
	
	private TeamMemberDao() {}
	
	public static TeamMemberDao getInstance() {
		if(instance==null) instance = new TeamMemberDao();
		
		return instance;
	}
	
	
	@Override
	public List<TeamMemberVO> selectAllMember() {
		List<TeamMemberVO> list = null;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("member.selectAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public int insertMember(TeamMemberVO vo) {
		int res = 0;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.insert("member.insertMember",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public TeamMemberVO selectMember(String memId) {
		TeamMemberVO vo = null;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("member.selectMember",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return vo;
	}

	@Override
	public int updateMember(TeamMemberVO vo) {
		int res = 0;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.update("member.updateMember",vo);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int deleteMember(String memId) {
		int res = 0;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.delete("member.deleteMember",memId);
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	@Override
	public int selectCountMember(String memId) {
		int res = 0;
		SqlSession session =null;
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.selectCountMember",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return res;
	}

	
}
