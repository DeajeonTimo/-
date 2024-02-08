package kr.or.ddit.doc0116;
//javaDoc문서 문서 만들기 예제 ==> 프로그램과 매뉴얼을 같이 만드는 방법

/**
 * 여기가 매뉴얼역할을하는곳.
 * html태그를 쓸 수 있다.
 * @author 홍길동
 * @version 1.0
 * <p>
 * 파일명: JavaDocTest.java<br>
 * 설명: JavaDoc문서작성을 위한 연습용 interface<br>
 * 
 * 변경이력<br>
 * --------------------------------------------<br>
 * 변경 날짜: 2024-01-16
 * 변경인: 홍길동<br>
 * 변경내용: 최초생성<br>
 * =-------------------------------------------<br>
 * </p>
 */

public interface JavaDocTest {
	/**
	 * 메소드명: methodTest<br>
	 * 설명: 반환값이 없는 메서드<br><br>
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번째 매개변수(정수형)
	 */
	public void methodTest(int a, int b);
	
	
	
	/**
	 * 메소드명: methodAdd<br>
	 * 설명: 반환값이 있는 메서드<br><br>
	 * 
	 * @param x 정수형 첫번째 데이터
	 * @param y 정수형 두번째 데이터
	 * @return 정수형 반환값
	 */
	public int methoAdd(int x, int y);
	
	/**
	 * 메소드명: methodInput<br>
	 * 설명: 매개변수가 없는 메소드<br><br>
	 * 
	 * @return 정수형 반환값
	 */
	public int methodInput();
}
