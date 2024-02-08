package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;

//jdbcTest프로젝트의 JdbcTest05.java의 기능을 MyBatis용으로 변환하시오( mapper 파일명 : jdbc-mapper.xml) (namespace속성값 : jdbc)
public class JdbcToMybatis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * 
		 * //1. MyBatis의 환경 설정 파일(mybatis-config.xml)을 읽어와서 처리하여 sqlSessionFactory객체를
		 * 생성한다. InputStream in = null; SqlSessionFactory sqlSessionFactory = null;
		 * 
		 * try { // 1-1. 환경설정 파일을 읽어올 스트림 객체 생성
		 * 
		 * in =
		 * Resources.getResourceAsStream("kr/or/ddit/mybatis/config/mybatis-config.xml")
		 * ;
		 * 
		 * // 1-2. 환경설정 파일을 읽어와 환경 설정 작업을 진행하고 환경 설정 작업을 진행한다. // (환경 설정이 완료 되면
		 * SqlSessionFactory 객체가 생성된다.) sqlSessionFactory = new
		 * SqlSessionFactoryBuilder().build(in); }catch(Exception e) {
		 * System.out.println("MyBatis 초기화 실패!!"); e.printStackTrace(); }finally {
		 * if(in!=null) try { in.close();}catch(IOException e) {} }
		 */
		
		SqlSession session = null;
		try {
//			session = sqlSessionFactory.openSession();
			session = MybatisUtil.getSqlSession();
			
			//원하는 select문을 호출하여 실행한다.
			//	==> select문을 실행한 결과가 1개의 레코드인 경우에는 selectOne() 메서드를 사용한다.
			//			selectOne()매서드는 검색한 자료가 없으면 null을 반환한다.
			// 형식) SqlSession객체.selectOne("namespace속성값.id속성값",파라미터클래스)
			
			int maxNum = session.selectOne("jdbc.MaxLprod");
			maxNum++;
			String gu;
			int count;
			do {
				System.out.println("상품 분류코드 입력 >>");
				gu=scan.next();
				count =session.selectOne("jdbc.CntLpord",gu);

				if(count>0) {
					System.out.println(gu+"는 이미 등록된 상품 분류 코드 입니다.");
					System.out.println("다시 입력하세요");
					System.out.println();
				}
			}while(count>0);
			
			System.out.println("상품 분류명 입력>>");
			String nm = scan.next();
			
			LprodVO lvo = new LprodVO();
			lvo.setLprod_nm(nm);
			lvo.setLprod_gu(gu);
			lvo.setLprod_id(maxNum);
			int insertCnt = session.update("jdbc.insertLpord",lvo); 
			if(insertCnt>0) {
				 session.commit(); 
				 System.out.println("등록 성공!!");
			}else {
				System.out.println("등록 실패~~");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	}
}
