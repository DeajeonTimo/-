package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao {
	
	private static BoardDaoImpl boardDao;
	
	private BoardDaoImpl() { }
	
	public static BoardDaoImpl getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}

	@Override
	public int updatePost(Map<String, Object> postMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board (BOARD_NO , BOARD_TITLE , BOARD_WRITER , BOARD_DATE , BOARD_CNT,BOARD_CONTENT) "
					+ "values(board_seq.nextVal, ?, ?, sysdate , 0 , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) postMap.get("postTitle"));
			pstmt.setString(2, (String) postMap.get("postWriter"));
			pstmt.setString(3, (String) postMap.get("postContent"));
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}
	@Override
	public BoardVO getPostOne(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVo = new BoardVO();
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where BOARD_NO =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return boardVo;
	}

	@Override
	public int updatePostOne(Map<String, Object> postMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set BOARD_TITLE=? , BOARD_CONTENT=? where BOARD_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) postMap.get("postTitle"));
			pstmt.setString(2, (String) postMap.get("postContent"));
			pstmt.setInt(3, (int)postMap.get("postNo"));
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deletePost(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql  = "delete from jdbc_board where BOARD_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

	
	//
	@Override
	public List<BoardVO> getPostByTitle(String board_title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVo = null;
		List<BoardVO> postList = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where BOARD_TITLE LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+board_title+"%");
			rs = pstmt.executeQuery();
			postList = new ArrayList<BoardVO>();
			while(rs.next()) {
				boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				postList.add(boardVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return postList;
	}

	@Override
	public List<BoardVO> getAllPost() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVo = null;
		List<BoardVO> postList = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			postList = new ArrayList<BoardVO>();
			while(rs.next()) {
				boardVo = new BoardVO();
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				postList.add(boardVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return postList;
	}

	@Override
	public int updateHits(int board_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board set BOARD_CNT=(select BOARD_CNT from JDBC_BOARD where BOARD_NO=?)+1 where BOARD_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			pstmt.setInt(2,board_no);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return cnt;
	}

}
