package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.TeamMemberDao;
import kr.or.ddit.member.vo.TeamMemberVO;

public class TeamMemberService implements ITeamMemberService {


	private static TeamMemberService instance;
	
	private TeamMemberDao dao;
	
	private TeamMemberService() {
		dao = TeamMemberDao.getInstance();
	}
	
	public static TeamMemberService getInstance() {
		if(instance==null) instance = new TeamMemberService();
		
		return instance;
}

	@Override
	public List<TeamMemberVO> selectAllMember() {
		
		return dao.selectAllMember();
	}

	@Override
	public int insertMember(TeamMemberVO vo) {
		
		return dao.insertMember(vo);
	}

	@Override
	public TeamMemberVO selectMember(String memId) {
		
		return dao.selectMember(memId);
	}

	@Override
	public int updateMember(TeamMemberVO vo) {
		
		return dao.updateMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		
		return dao.deleteMember(memId);
	}

	@Override
	public int selectCountMember(String memId) {
		
		return dao.selectCountMember(memId);
	}
}
