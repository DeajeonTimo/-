package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.BoardServiceImpl;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardController {
	Scanner sc = new Scanner(System.in);
	BoardServiceImpl service = BoardServiceImpl.getInstance();
	boolean chk = true; 
	public static void main(String[] args) {
		BoardController bc = new BoardController();
		bc.start();
	}

	private void start() {
		while(true) {
			int sel = display();
			switch(sel) {
				case 1 : createNewPost();
					break;
				case 2 :  viewPost();
					break;
				case 3 : serchPost();
					break;
				case 0 : 
					System.out.println("게시판 프로그램 종료....");
					return;
				default : 
					System.out.println("잘못 입력하셨습니다.");
					System.out.println("다시 입력해주세요...");
					break;
			}
			
		}
		
	}

	private void serchPost() {
		chk=false;
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------------------------");
		System.out.println(" - 검색할 제목 입력 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		List<BoardVO> postList = service.getPostByTitle(title);
		System.out.println("--------------------------------------------------------------");
		System.out.println("No\t\t제목\t\t\t작성자\t조회수");
		System.out.println("--------------------------------------------------------------");
		for(BoardVO boardVo : postList) {
			System.out.println(boardVo.getBoard_no()+"\t\t"+boardVo.getBoard_title()+"\t\t"+boardVo.getBoard_writer()+"\t"+boardVo.getBoard_cnt());
		}
		
		
	}

	private void viewPost() {
		System.out.println("보기를 원하는 게시물 번호 입력 >>");
		int board_no = sc.nextInt();
		service.updateHits(board_no);
		BoardVO boardvo = service.getPostOne(board_no);
		System.out.println(board_no+"번글 내용");
		System.out.println("--------------------------------------------------");
		System.out.println("- 제 목 : "+boardvo.getBoard_title());
		System.out.println("- 작성자 : "+boardvo.getBoard_writer());
		System.out.println("- 내용 : "+boardvo.getBoard_content());
		System.out.println("- 작성일 : "+boardvo.getBoard_date());
		System.out.println("- 조회수 : "+boardvo.getBoard_cnt());
		System.out.println("--------------------------------------------------");
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.println("작업선택 >>");
		int sel = sc.nextInt();
		switch(sel) {
			case 1 : editPost(board_no);
				break;
			case 2 : deletePost(board_no);
				break;
			case 3 : 
				break;
		}
		
	}

	private void deletePost(int board_no) {
		int cnt = service.deletePost(board_no);
		
		System.out.println(board_no+"번글이 삭제되었습니다");
		
	}

	private void editPost(int board_no) {
		System.out.println("수정 작업하기");
		System.out.println("---------------------------------");
		System.out.println("- 제 목 :");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("- 내 용 :");
		String content = sc.nextLine();
		Map<String,Object> postMap = new HashMap<String, Object>();
		postMap.put("postTitle", title);
		postMap.put("postContent", content);
		int cnt = service.updatePostOne(postMap);
		
		if(cnt>0) {
			System.out.println(board_no+"번글이 수정되었습니다.");
		}
	}

	private void createNewPost() {
		Map<String,Object> postMap = new HashMap<String, Object>();
		System.out.println("새글 작성하기");
		System.out.println("-------------------");
		System.out.println("- 제  목 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("- 작성자 : ");
		String writer = sc.next();
		System.out.println("- 내  용 : ");
		sc.nextLine(); // 버퍼 비우기
		String content = sc.nextLine();
		System.out.println();
		postMap.put("postTitle",title);
		postMap.put("postWriter",writer);
		postMap.put("postContent",content);
		
		int cnt = service.updatePost(postMap);
		if(cnt>0) System.out.println("새글이 추가되었습니다.");
		
	}

	private int display() {
		
		List<BoardVO> postList = service.getAllPost();

		if(chk) {
		System.out.println("--------------------------------------------------------------");
		System.out.println("No\t\t제목\t\t\t작성자\t조회수");
		System.out.println("--------------------------------------------------------------");
			for(BoardVO boardVo : postList) {
				System.out.println(boardVo.getBoard_no()+"\t\t"+boardVo.getBoard_title()+"\t\t"+boardVo.getBoard_writer()+"\t"+boardVo.getBoard_cnt());
			}
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.println("작업선택 >>");
		chk=true;
		return sc.nextInt();
	}
}
