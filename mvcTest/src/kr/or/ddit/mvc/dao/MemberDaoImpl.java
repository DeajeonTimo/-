package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {
	private Logger logger = Logger.getLogger(MemberDaoImpl.class);

	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {
		
	}
	
	public  static MemberDaoImpl getInstance() {
		if(instance ==null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0; //반환값이 저장될 변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil3.getConnection();
			logger.debug("Connection 객체 생성...");
			String sql = "insert into mymember (mem_id,mem_pass,mem_name,mem_tel,mem_addr) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memVo.getMem_id());
			pstmt.setString(2,memVo.getMem_pass());
			pstmt.setString(3,memVo.getMem_name());
			pstmt.setString(4,memVo.getMem_tel());
			pstmt.setString(5,memVo.getMem_addr());
			
			logger.debug("PreparedStatement 객체 생성");
			logger.debug("실행SQL : " + sql);
			logger.debug("사용 데이터 : ["+memVo.getMem_id()+","+memVo.getMem_pass()
			+","+memVo.getMem_name()+","+memVo.getMem_tel()+","+memVo.getMem_addr()+"]");

			cnt = pstmt.executeUpdate();
			logger.info("insert 작업 성공!!!");
		} catch (SQLException e) {
			logger.error("insert 작업 실패~~~",e);
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
			logger.info("사용했던 자원 반납...");
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from MYMEMBER where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_pass=?,mem_name=?,mem_tel=?,mem_addr=? where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO>memList = null; // 반환값이 저장될 변수 선언
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memList = new ArrayList<MemberVO>();
			
			while(rs.next()) {
				//1개의 레코드가 저장될 VO객체 생성
				MemberVO memVo = new MemberVO();
				
				//ResultSet 객체의 데이터를 꺼내서 VO객체에 저장한다.
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				//List에 Vo객체를 추가한다.
				memList.add(memVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count=0; // 반환값이 저장될 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, memId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
		}
		return count;
	}

	@Override
	public int updateOne(Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set " + map.get("col") + " = ? where mem_id= ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("val"));
			pstmt.setString(2, map.get("memId"));
			cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		
		return cnt;
	}
}
