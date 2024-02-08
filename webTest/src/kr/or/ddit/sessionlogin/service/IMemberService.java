package kr.or.ddit.sessionlogin.service;

import kr.or.ddit.sessionlogin.vo.MemberVO;

public interface IMemberService {
	/**
	 * 회원 ID와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서 해당 회원을 검색하여 반환하는 매서드
	 * 
	 * @param memvo 검색할 회원ID와 패스워드가 저장된 MemberVO객체
	 * @return 검색된 회원정보가 저장된 MemberVO객체(검색된 자료가 없으면 null)
	 */
	public MemberVO getLoginMember(MemberVO memvo);
}
