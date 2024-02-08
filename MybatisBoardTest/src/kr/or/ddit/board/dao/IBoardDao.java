package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	
	/**
	 * 게시글을 만드는 메소드
	 * 
	 * 게시글의 번호 - 시퀀스
	 * 게시글의 제목 - key : postTitle
	 * 게시글의 작성자 - key : postWriter
	 * 게시글의 날짜 - sysdate
	 * 게시글의 조회수 - 0
	 * 게시글의 내용 - key : postContent
	 * @param postMap
	 * 
	 * @return 게시글 작성 성공  = 1 , 실패 = 0 
	 * 
	 * sql = insert into jdbc_board (BOARD_NO , BOARD_TITLE , BOARD_WRITER , BOARD_DATE , BOARD_CNT,BOARD_CONTENT)
				values(board_seq.nextVal, ?, ?, sysdate , 0 , ?)
	 */
	public int updatePost(Map<String,Object> postMap);
	
	
	
	
	/**
	 * 
	 * 게시글 번호를 매개변수로 해당 게시글의 정보가 담긴 BoardVO를 반환하는 매서드
	 * 
	 * @param board_no 게시글 번호
	 * 
	 * @return 선택한 게시물 번호를 값으로 가진 BoardVO
	 * 
	 * sql = select * from jdbc_board where BOARD_NO =?
	 */
	public BoardVO getPostOne(int board_no);
	
	
	
	
	/**
	 * 게시글 하나의 제목과 내용을 수정하는 메서드
	 * 
	 * @param postMap 수정할 게시글의 새로운 제목과 내용
	 * 				key : postTitle ,  key : postContent 
	 * @return 게시글 작성 수정  = 1 , 실패 = 0 
	 * sql = update jdbc_board set BOARD_TITLE=? , BOARD_CONTENT=? where BOARD_NO=?;
	 */
	public int updatePostOne(Map<String,Object> postMap);
	
	
	
	
	/**
	 * 게시글 하나를 삭제하는 메서드
	 * @param board_no 게시글의 번호
	 * @return 게시글 작성 수정  = 1 , 실패 = 0 
	 * sql  = delete from jdbc_board where BOARD_NO=?
	 */
	public int deletePost(int board_no);
	
	
	
	/**
	 * 
	 * 게시글 제목을 매개변수로 해당 게시글의 정보가 담긴 BoardVO를 반환하는 매서드
	 * 
	 * @param board_title 게시글 제목
	 * 
	 * @return 검색한 게시물제목을 값으로 가진 BoardVO
	 * 
	 * sql = select * from jdbc_board where BOARD_TITLE LIKE ?%
	 */
	public List<BoardVO> getPostByTitle(String board_title);
	
	
	
	
	/**
	 * 
	 * 게시글을 전체를 반환하는 메소드
	 * 
	 * @return 게시글 전체를 List에 담아 반환
	 * 
	 * sql = select * from jdbc_board
	 */
	public List<BoardVO> getAllPost();
	
	
	/**
	 * 게시글 조회수를 1올려주는 메소드
	 * @param board_no
	 * @return
	 */
	public int updateHits(int board_no);
	

}
