package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service 객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 실행결과를 받아오고
 * 		받아온 결과를 Controller에게 보내주는 역할
 * 
 * 	우리 시간에는 DAO의 interface와 구조가 같게 만든다.
 * @author PC-27
 *
 */
public interface IMemberService {

		/**
		 * MemberVo객체에 담겨진 자료를 insert하는 매서드
		 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
		 * @return 작업 성공 : 1, 작업실패 :0
		 */
		public int insertMember(MemberVO memVo);
		
		/**
		 * 회원  ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 매서드
		 * @param memId 삭제할 회원ID
		 * @return 작업성공 : 1, 작업 실패 : 0
		 */
		
		public int deleteMember(String memId);
		
		/**
		 *  MemberVO객체 자료를 이용하여 DB에 update 하는 매서드
		 * @param memVo update할 회원 정보가 저장된 MemberVO객체
		 * @return 작업성공 : 1 , 작업실패 : 0
		 */
		public int updateMember(MemberVO memVo);
		/**
		 * DB의 전체 회원 정보를 가져와서 List에 담아서 반환하는 매서드
		 * @return MemberVO객체가 저장된 List객체
		 */
		public List<MemberVO> getAllMember();
		
		/**
		 * 회원 ID를 매개변수로 받아서 해당 회원 ID의 개수를 반환하는 매서드
		 * @param memId 검색할 회원 ID
		 * @return 검색된 회원ID의 갯수
		 */
		public int getMemberCount(String memId);
		
		public int updateOne(Map<String, String> map);
	
}
