package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		//싱글 쓰레드
		// '*'문자 200개 출력, '$'문자 200개 출력
		
		for(int i=1; i<=200; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		
		for(int j=0; j<=200; j++) {
			System.out.print("$");
		}
		
	}
}
