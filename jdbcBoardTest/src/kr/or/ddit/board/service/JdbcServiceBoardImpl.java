package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.IJdbcBoardDao;
import kr.or.ddit.board.dao.JdbcBoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;

public class JdbcServiceBoardImpl implements IJdbcBoardService{
	
	private IJdbcBoardDao dao;
	
	private static JdbcServiceBoardImpl service;
	
	private JdbcServiceBoardImpl() {
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcServiceBoardImpl getInstance() {
		if(service==null) service = new JdbcServiceBoardImpl();
		return service;
	}
	

	
	@Override
	public int insertBoard(BoardVO boardVo) {
	
		return dao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		
		return dao.getAllBoardList();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		//조회수를 먼저 증가한 다음 게시글 정보를 가져온다.
		if(updateBoardCount(boardNo) ==0) {
			return null;
		}
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getSerchBoardList(String title) {
		
		return dao.getSerchBoardList(title);
	}

	@Override
	public int updateBoardCount(int boardNo) {
		
		return dao.updateBoardCount(boardNo);
	}

}
