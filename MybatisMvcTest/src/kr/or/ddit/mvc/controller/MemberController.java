package kr.or.ddit.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	// Service객체의 참조값이 저장될 변수 선언
	private IMemberService service;
	private Scanner scan;
	
	// 생성자
	public MemberController() {
		scan = new Scanner(System.in);
		// Service객체 생성
		service =  MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	// 시작 메서드
	public void startMember() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
				case 1 : 	// 추가
					insertMember();	break;
				case 2 : 	// 삭제
					deleteMember(); 
					break;
				case 3 : 	// 수정
					updateMember(); 
					break;
				case 4 : 	// 전체 출력
					displayAllMember(); 
					break;
				case 5 : 	// 수정2
					updateMember2(); 
					break;
				case 0 :
					System.out.println("작업을 마칩니다...");
					return;
				default : 
					System.out.println("작업 번호를 잘못 입력했습니다...");
					System.out.println("다시 입력하세요...");
			}
			
		}
	}

	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.println("회원ID>>");
		String memId = scan.next();
		
		
		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId="는(은) 없는 회원입니다.");
			System.out.println("수정 작업을 종료합니다...");
			return;
		}
		
		int sel=0;
		do {
		System.out.println();
		System.out.println("수정 항목을 선택하세요");
		System.out.println("1. 회원 아이디 수정");
		System.out.println("2. 회원 비밀번호 수정");
		System.out.println("3. 회원 이름  수정");
		System.out.println("4. 회원 전화번호 수정");
		System.out.println("5. 회원 주소 수정");
		
		sel = scan.nextInt();
		}while(sel<1 || sel>5);
		System.out.println("수정내용 >>");
		String val = scan.next();
		
		String col="";
		
		if(sel==1) {
			col="mem_id";
		}else if(sel==2) {
			col="mem_pass";
		}else if(sel==3) {
			col="mem_name";
		}else if(sel==4) {
			col="mem_tel";
		}else if(sel==5) {
			col="mem_addr";
		}
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("memId", memId);
		map.put("col", col);
		map.put("val", val);
		
		service.updateOne(map);
		
	}

	private void displayAllMember() {

		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("회원ID   비밀번호   회원이름    전화번호    회원주소");
		System.out.println("---------------------------------------");
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = service.getAllMember();

		if(list.isEmpty()) {
			System.out.println("회원 정보가 하나도 없습니다...");
		}else {
			for(MemberVO memVo : list) {

				System.out.println(memVo.getMem_id() + "\t" + memVo.getMem_pass() + "\t" +
						memVo.getMem_name() + "\t" + memVo.getMem_tel() + "\t" + memVo.getMem_addr());
			}
			System.out.println("---------------------------------------");
		}

	}

	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.println("회원ID>>");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId="는(은) 없는 회원입니다.");
			System.out.println("수정 작업을 종료합니다...");
			return;
		}

		System.out.println("수정할 내용을 입력하세요...");

		System.out.print("새로운 비밀번호>>");
		String newMemPass = scan.next();

		System.out.print("새로운 회원이름>>");
		String newMemName = scan.next();

		System.out.print("새로운 전화번호>>");
		String newMemTel = scan.next();

		scan.nextLine(); // 버퍼 비우기
		System.out.print("새로운 회원주소>>");
		String newMemAddr = scan.nextLine();

		MemberVO memVo = new MemberVO();
		
		memVo.setMem_id(memId);
		memVo.setMem_pass(newMemPass);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);
		memVo.setMem_name(newMemName);
		

		int cnt = service.updateMember(memVo);

		if(cnt>0) {
			System.out.println(memId + "회원 정보 수정 완료!!");
		}else {
			System.out.println(memId + "회원 정보 수정 실패...");
		}	
		
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.println("회원  ID>>");
		String memId = scan.next();

		int cnt = service.deleteMember(memId);

		if(cnt>0) {
			System.out.println("회원 ID가" + memId + "인 회원 정보 삭제 성공");
		}else {
			System.out.println(memId+"회원은 없는 회원이거나 삭제에 실패 했습니다.");
		}


	}

	// insert
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");
		
		int count = 0;
		String memId = null;		// 회원ID가 저장될 변수
		do {
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			count = service.getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId + "은(는) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요...");
			}
		}while(count>0);
		//----------------------
		
		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();
		
		// 입력이 완료되면 입력한 자료들을 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		// service의 insert메서드를 호출해서 처리한다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("insert 작업 성공!!!");
		}else {
			System.out.println("insert 작업 실패~~~");
		}
		
	}
	
	
	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println(" 1. 자료 추가");
		System.out.println(" 2. 자료 삭제");
		System.out.println(" 3. 자료 수정");
		System.out.println(" 4. 전체 자료 출력");
		System.out.println(" 5. 자료 수정2");  // ==> 원하는 항목만 수정하기
		System.out.println(" 0. 작업 끝.");
		System.out.println("-----------------");
		System.out.print("작업 번호 >> ");
		return scan.nextInt();
	}
	
	
	
	
	
}
