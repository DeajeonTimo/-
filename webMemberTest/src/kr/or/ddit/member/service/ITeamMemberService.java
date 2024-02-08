package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.TeamMemberVO;

public interface ITeamMemberService {

	public List<TeamMemberVO> selectAllMember();
	
	public int insertMember(TeamMemberVO vo);
	
	public TeamMemberVO selectMember(String memId);
	
	public int updateMember(TeamMemberVO vo);
	
	public int deleteMember(String memId);
	
	public int selectCountMember(String memId);
	
}
