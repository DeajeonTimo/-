package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제1) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.
public class jdbcTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "NSJ", "java");
			stmt = conn.createStatement();
			System.out.println("숫자를 입력하세요");
			int sel = sc.nextInt();
			String sql="SELECT LPROD_ID,\r\n" + 
					"        LPROD_GU,\r\n" + 
					"        LPROD_NM\r\n" + 
					"    FROM LPROD\r\n" + 
					"WHERE LPROD_ID>"+sel;
			rs = stmt.executeQuery(sql);
			boolean chk = true;
			while(rs.next()) {
				chk =false;
				System.out.println("LPROD_ID : " +rs.getInt(1));
				System.out.println("LPROD_GU : " +rs.getString(2));
				System.out.println("LPROD_NM : " +rs.getString(3)); // 숫자 인자는 SQL문에 기재한 컬럼 순서를 의미한다.
				System.out.println();
			}
			if(chk) {
				System.out.println("검색 결과가 하나도 없습니다.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {};
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {};
			if(conn!=null)try {conn.close();}catch(SQLException e) {};
;		}
	}
}
