package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.MybatisUtil;

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

		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updatePost",postMap);
			if(cnt>0) {
				 session.commit(); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}
	@Override
	public BoardVO getPostOne(int board_no) {

		BoardVO boardVo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			boardVo = session.selectOne("board.getPostOne",board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}

		return boardVo;
	}

	@Override
	public int updatePostOne(Map<String, Object> postMap) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updatePostOne",postMap);
			if(cnt>0) {
				 session.commit(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deletePost(int board_no) {

		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("board.deletePost",board_no);
			if(cnt>0) {
				 session.commit(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	
	//
	@Override
	public List<BoardVO> getPostByTitle(String board_title) {

		List<BoardVO> postList = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			postList = session.selectList("board.getPostByTitle",board_title);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return postList;
	}

	@Override
	public List<BoardVO> getAllPost() {

		List<BoardVO> postList = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			postList = session.selectList("board.getAllPost");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return postList;
	}

	@Override
	public int updateHits(int board_no) {

		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updateHits",board_no);
			if(cnt>0) {
				 session.commit(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

}
