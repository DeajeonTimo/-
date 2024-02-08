package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.vo.LprodVO;

//MyBatis를 이용하여 DB자료를 처리하는 순서 및 방법
public class LprodMybatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//1. MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서 처리하여 sqlSessionFactory객체를 생성한다.
		InputStream in = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			// 1-1. 환경설정 파일을 읽어올 스트림 객체 생성
			
			in = Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			// 1-2. 환경설정 파일을 읽어와 환경 설정 작업을 진행하고 환경 설정 작업을 진행한다.
			//		(환경 설정이 완료 되면 SqlSessionFactory 객체가 생성된다.)
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		}catch(Exception e) {
			System.out.println("MyBatis 초기화 실패!!");
			e.printStackTrace();
		}finally {
			if(in!=null) try { in.close();}catch(IOException e) {}
		}
		
	//===============================================================================================
		
		// 2. mapper에 등록된 SQL문 중 실행할 SQL문을 호출해서 원하는 작업을 수행한다.
		
		//2-1 insert 연습
		/*
		 * System.out.println("insert 작업 시작...");
		 * 
		 * System.out.print("Lprod_ID 입력>>"); int lprodId = scan.nextInt();
		 * 
		 * System.out.print("Lprod_GU 입력>>"); String lprodGu = scan.next();
		 * 
		 * System.out.print("Lprod_NM 입력>>"); String lprodNm = scan.next();
		 * 
		 * // 입력받은 데이터를 VO에 저장한다. LprodVO lvo = new LprodVO(); lvo.setLprod_id(lprodId);
		 * lvo.setLprod_gu(lprodGu); lvo.setLprod_nm(lprodNm);
		 * 
		 * //원하는 sql문을 호출해서 실행하는 객체는 sqlSession갹체이다. //sqlSession객체는
		 * sqlSessionFactory객체의 openSession() 매서드를 이용하여 생성한다. //형식)
		 * SqlSessionFactory객체.openSession(논리값) // =>'논리값'이 true이면 AutoCommit이 활성화 된
		 * 상태이고, false이면 AutoCommit이 비활성화 된 상태이다.
		 * 
		 * SqlSession session = null; try { session = sqlSessionFactory.openSession();
		 * 
		 * //생성된 SqlSession을 이용하여 처리할 SQL문을 호출하여 실행한다. //insert 처리하기 - 형식 :
		 * SqlSession객체.insert("namespace속성값.id속성값",파라미터클래스) // 반환값 : 작업에 성공한 레코드 수 int
		 * insertCnt = session.insert("lprod.insertLprod", lvo); if(insertCnt>0) { //
		 * SqlSession 객체를 생성할 때 AutoCommut이 비활성화된 상태일때는 commit을 직접 실행해야한다.
		 * session.commit(); System.out.println("insert 작업 성공!!!"); }else {
		 * System.out.println("insert 작업 실패"); } }catch(Exception e) {
		 * e.printStackTrace(); }finally { // 작업이 끝나면 SqlSession 객체를 닫아준다.
		 * if(session!=null) session.close(); }
		 */
		
		/*
		 * //2-2 update 연습 System.out.println("update 작업 시작...");
		 * 
		 * System.out.println("수정할 Lprod_GU입력>>"); String lprodGu2 = scan.next();
		 * 
		 * System.out.println("새로운 Lprod_ID 입력"); int lprodId2 = scan.nextInt();
		 * 
		 * System.out.println("새로운 Lprod_NM 입력"); String lprodNm2 = scan.next();
		 * 
		 * //입력한 자료를 VO객체에 저장한다. LprodVO lvo2 = new LprodVO();
		 * lvo2.setLprod_gu(lprodGu2); lvo2.setLprod_nm(lprodNm2);
		 * lvo2.setLprod_id(lprodId2);
		 * 
		 * SqlSession session = null;
		 * 
		 * try { session = sqlSessionFactory.openSession();
		 * 
		 * //생성된 SqlSession 객체를 이용하여 update작업 진행하기 //형식 )
		 * SqlSession객체.update("namespace속성값.id속성값",파라미터클래스) //반환값 : 작업에 성공한 레코드 수 int
		 * updateCnt = session.update("lprod.updateLprod",lvo2); if(updateCnt>0) {
		 * session.commit(); System.out.println("update 작업 성공!!!"); }else {
		 * System.out.println("update 작업 실패"); } }catch(Exception e) {
		 * e.printStackTrace(); }finally { if(session !=null) session.close(); }
		 */
		
		
		/*
		 * //delete 연습 System.out.println("delete 작업 시작...");
		 * 
		 * System.out.print("삭제할 Lprod_GU입력>>");
		 * 
		 * String lprodGu3 = scan.next(); SqlSession session = null;
		 * 
		 * try { session = sqlSessionFactory.openSession();
		 * 
		 * //생성된 SqlSession 객체를 이용하여 update작업 진행하기 //형식 ) //
		 * SqlSession객체.delete("namespace속성값.id속성값",파라미터클래스) //반환값 : 작업에 성공한 레코드 수 int
		 * int deleteCnt = session.delete("lprod.deleteLprod" ,lprodGu3 );
		 * if(deleteCnt>0) { session.commit(); System.out.println("delete 작업 성공"); }else
		 * { System.out.println("delete 작업 실패"); } }catch(Exception e) {
		 * e.printStackTrace(); }finally { if(session!=null) session.close(); }
		 */
		
		//2-4 select 연습
		
		//1) select문의 처리 결과가 여러개의 레코드일 경우
		/*
		 * System.out.println("select 작업 시작-- 결과가 여러개의 레코드일 경우...");
		 * 
		 * SqlSession session = null;
		 * 
		 * try { session = sqlSessionFactory.openSession();
		 * 
		 * //원하는 select문을 호출하여 실행한다. // 형식)
		 * SqlSession객체.selectList("namespace속성값.id속성값",파라미터클래스); // selectList() 메서드는
		 * 검색된 각각의 레코드를 VO객체에 저장한 후 // 이 VO객체를 List에 추가해 주는 작업을 자동으로 수행한다. List<LprodVO>
		 * lprodList = session.selectList("lprod.getAllLprod");
		 * 
		 * for(LprodVO lvo3 : lprodList) { System.out.println("ID : "+
		 * lvo3.getLprod_id()); System.out.println("GU : "+ lvo3.getLprod_gu());
		 * System.out.println("NM : "+ lvo3.getLprod_nm()); }
		 * System.out.println("출력 끝..."); }catch(Exception e) { e.printStackTrace();
		 * }finally { if(session!=null) session.close(); }
		 */
		
		// 2) select문을 실행한 결과가 1개의 레코드인 경우
		System.out.println("select 작업 시작 -- 결과가 1개일 경우");
		
		System.out.print("검색할 Lprod_GU 입력>>");
		String lprodGu4 = scan.next();
		
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			
			//원하는 select문을 호출하여 실행한다.
			//	==> select문을 실행한 결과가 1개의 레코드인 경우에는 selectOne() 메서드를 사용한다.
			//			selectOne()매서드는 검색한 자료가 없으면 null을 반환한다.
			// 형식) SqlSession객체.selectOne("namespace속성값.id속성값",파라미터클래스)
			
			LprodVO lvo4 = session.selectOne("lprod.getLprod",lprodGu4);
			if(lvo4==null) {
				System.out.println("검색한 데이터가 하나도 없습니다...");
				return;
			}

			System.out.println("ID : "+ lvo4.getLprod_id()); 
			System.out.println("GU : "+ lvo4.getLprod_gu());
			System.out.println("NM : "+ lvo4.getLprod_nm()); 
			System.out.println("출력 끝...");
		}catch(Exception e) {
			
		}finally {
			if(session!=null) session.close();
		}
		
		
	}
}

























