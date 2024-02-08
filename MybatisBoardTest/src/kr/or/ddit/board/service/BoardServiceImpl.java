package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private static BoardServiceImpl boardService = null;
	
	BoardDaoImpl boardDao = null;
	
	private BoardServiceImpl() { 
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	
	@Override
	public int updatePost(Map<String, Object> postMap) {
		
		return boardDao.updatePost(postMap);
	}

	@Override
	public BoardVO getPostOne(int board_no) {
		
		return boardDao.getPostOne(board_no);
	}

	@Override
	public int updatePostOne(Map<String, Object> postMap) {
		
		return boardDao.updatePostOne(postMap);
	}

	@Override
	public int deletePost(int board_no) {
		
		return boardDao.deletePost(board_no);
	}

	@Override
	public List<BoardVO> getPostByTitle(String board_title) {
		
		return boardDao.getPostByTitle(board_title);
	}

	@Override
	public List<BoardVO> getAllPost() {
		
		return boardDao.getAllPost();
	}

	@Override
	public int updateHits(int board_no) {
	
		return boardDao.updateHits(board_no);
	}

}
