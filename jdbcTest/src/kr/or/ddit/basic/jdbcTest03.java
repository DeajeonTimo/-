package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제 lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰 값사이의 자료들을 출력하시오.

public class jdbcTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 값을 입력하세요");
		int sel1 = sc.nextInt();
		System.out.println("두번째 값을 입력하세요");
		int sel2 = sc.nextInt();
		int temp;
		if(sel2<sel1) {
			temp =sel2;
			sel2 = sel1;
			sel1=temp;
		}
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","NSJ","java");
			stmt = conn.createStatement();
			String sql = "SELECT *\r\n" + 
					"FROM LPROD\r\n" + 
					"WHERE LPROD_ID>"+sel1+"and LPROD_ID<"+sel2;
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("LPROD_ID : " +rs.getInt(1));
				System.out.println("LPROD_GU : " +rs.getString(2));
				System.out.println("LPROD_NM : " +rs.getString(3)); // 숫자 인자는 SQL문에 기재한 컬럼 순서를 의미한다.
				System.out.println();
				
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
		}
	}
}
