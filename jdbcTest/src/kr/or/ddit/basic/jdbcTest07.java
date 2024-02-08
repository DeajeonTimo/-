package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 	회원을 관리하는 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
 	
 	아래 메뉴의 기능을 모두 구현하시오. (CRUD 기능 구현 연습)
 	
 	메뉴 예시)
 		1. 자료 추가 		==> INSERT : C
 		2. 자료 삭제 		==> DELETE : D
 		3. 자료 수정		==> UPDATE : U
 		4. 전체 자료 출력	==> SELECT : R
 		0. 작업 끝
 		----------------------
 		
 		조건)
 		1)자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력받는다)
 		2)자료 삭제는 회원 ID를 입력 받아서 처리한다.
 		3)자료 수정에서 '회원ID'는 변경되지 않는다.
 		
 */
public class jdbcTest07 {
	private Scanner sc = new Scanner(System.in);
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public jdbcTest07(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","NSJ","java");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		jdbcTest07 jt = new jdbcTest07();
		jt.start();
		if(jt.rs!=null) try {jt.rs.close();} catch(SQLException e) {}
		if(jt.pstmt!=null) try {jt.pstmt.close();} catch(SQLException e) {}
		if(jt.conn!=null) try {jt.conn.close();} catch(SQLException e) {}
		

		
	}

	private void start() {
		
		while(true) {
			int sel = display();
			switch(sel) {
				case 1 : 
					insert(); break;
				case 2 : 
					update(); break;
				case 3 :
					delete(); break;
				case 4 :
					select(); break;
				case 0 : 
					System.out.println("작업을 종료합니다.");
					return;
				default : 
					System.out.println("잘못 입력 하셨습니다.");
					System.out.println("다시 입력하세요");
			}
		}
		
	}




	private void select() {
		String sql = "SELECT * FROM MYMEMBER";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("아이디\t비밀번호\t이름\t전화번호\t주소");
			while(rs.next()) {
				System.out.println(rs.getString("MEM_ID")+"\t"+rs.getString("MEM_PASS")+"\t"+
			rs.getString("MEM_NAME")+"\t"+rs.getString("MEM_TEL")+"\t"+rs.getString("MEM_ADDR"));
			}
			System.out.println("출력 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}




	private void update() {
		String id = check2();
		System.out.println("비밀번호를 입력하세요");
		String pass = sc.next();
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("전화번호를 입력하세요");
		String tel = sc.next();
		System.out.println("주소를 입력하세요");
		String addr = sc.next();
		
		String sql = "UPDATE MYMEMBER SET MEM_PASS = ?,MEM_NAME=?,MEM_TEL=?,MEM_ADDR=? WHERE MEM_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, id);
			pstmt.execute();
			
			System.out.println("성공적을 업데이트 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}




	private void delete() {
		String sql = "DELETE FROM MYMEMBER WHERE MEM_ID=?";
		try {
			String id = check2();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.execute();
			System.out.println("성공적으로 삭제 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




	private void insert() {
		String id = check();
		System.out.println("비밀번호를 입력하세요");
		String pass = sc.next();
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		System.out.println("전화번호를 입력하세요");
		String tel = sc.next();
		System.out.println("주소를 입력하세요");
		String addr = sc.next();
		String sql = "INSERT INTO MYMEMBER (MEM_ID,MEM_PASS,MEM_NAME,MEM_TEL,MEM_ADDR) VALUES(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
			pstmt.setString(4,tel);
			pstmt.setString(5,addr);
			pstmt.execute();
			System.out.println("성공적으로 등록 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private String check() {
		String id;
		while(true) {
			System.out.println("아이디를 입력하세요");
			id= sc.next();
			String sql = "SELECT COUNT(*) AS CNT FROM MYMEMBER WHERE MEM_ID=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("cnt")>0) {
						System.out.println("중복된 아이디 입니다.");
						System.out.println("다시 입력해 주세요");
					}else {
						break;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	private String check2() {
		String id;
		while(true) {
			System.out.println("아이디를 입력하세요");
			id= sc.next();
			String sql = "SELECT COUNT(*) AS CNT FROM MYMEMBER WHERE MEM_ID=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("cnt")>0) {
						break;
					}else {
						System.out.println("등록되지 않은 아이디 입니다.");
						System.out.println("다시 입력해 주세요");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}




	private int display() {
		System.out.println();
		System.out.println("1. 자료추가");
		System.out.println("2. 자료수정");
		System.out.println("3. 자료삭제");
		System.out.println("4. 전체자료출력");
		System.out.println("0. 작업종료");
		return sc.nextInt();
	}
}
