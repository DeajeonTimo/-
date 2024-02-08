package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	lprod 테이블에 새로운 데이터 추가하기
 	
 	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고
 	lprod_id는 현재의 lprod_id들 중에서 제일 큰 값보다 1 크게한다.
 	
 	입력받은 lprod_gu가 이미 등록되어 있다면 다시 입력 받아서 처리한다.
 */
public class jdbcTest05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","NSJ","java");
			
			conn= DBUtil.getConnection();
			
			//lprod_id는 현재의 lprod_id들 중에서 제일 큰 값보다 1 크게한다.
			String sql = "SELECT MAX(LPROD_ID) MAXNUMBER FROM LPROD";
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxNum =0;
			if(rs.next()) {
				//maxNum = rs.getInt("MAXNUMBER");
				maxNum = rs.getInt(1);
			}
			maxNum++;
			//------------------------------------------------------------
			
			//입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			String gu; // 입력한 Lprod_gu값이 저장될 변수
			int count = 0; // 입력한 Lprod_gu의 갯수가 저장될 변쉬
			
			String sql2 = "SELECT COUNT(*) CNT FROM LPROD WHERE LPROD_GU=?";
			pstmt=conn.prepareStatement(sql2);
			
			do {
				System.out.println("상품 분류코드 입력 >>");
				gu=scan.next();
				pstmt.setNString(1, gu); // 물음표에 들어갈 데이터 설정
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println(gu+"는 이미 등록된 상품 분류 코드 입니다.");
					System.out.println("다시 입력하세요");
					System.out.println();
				}
			}while(count>0);
			
			System.out.println("상품 분류명 입력>>");
			String nm = scan.next();
			
			String sql3 = "insert into lprod(lprod_id, lprod_gu, lprod_nm) values (?,?,?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxNum);
			pstmt.setNString(2, gu);
			pstmt.setNString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록 성공!!");
			}else {
				System.out.println("등록 실패~~");
			}
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
}
