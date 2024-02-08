package kr.or.ddit.singleton;

/*
 	Singleton 패턴 ==> 객체가 1개만 만들어지게 하는 방법
 	
 	-사용 이유
 	
 	1) 메모리 낭비 방지
 	2) 데이터의 공유가 쉽다.
 	
 	
 	-SingleTon 클래스 만드는 방법 (필수 구성 요소)
 	
 	1. 자기 자신 class의 참조값이 저장될 변수를 private static으로 선언한다.
 	
 	2. 모든 생성자의 접근 제한자를 private으로 한다.
 	
 	3. 자신 class의 인스턴스를 생성하고 반환하는 메소드를 public static으로 작성한다.
 		(이 메서드의 이름은 보통 getInstance로 한다.)
 	
 */



public class MySingleton {

	//1번
	private static MySingleton instance = null;
	
	//2번
	private MySingleton() {

	}
	
	public static MySingleton getInstance() {
		// 1번의 변수가 null이면 객체를 생성해서 1번의 변수에 저장한다.
		// 1번의 변수가 null이 아니면  1번의 변수값을 반환한다.
		
		if(instance == null) {
			 instance = new MySingleton();
		}
		
		return instance;
	}
	
	//기타 이 클래스가 처리할 내용을 작성한다.
	
	public void diplayTest() {
		System.out.println("싱글톤 클래스의 메서드 호출입니다.");
		System.out.println("...................................");
	}
}
