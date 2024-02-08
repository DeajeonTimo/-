package kr.or.ddit.basic;

/*
 	3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데
 	출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성하시오.
 */

public class ThreadTest12 {

	public static void main(String[] args) {
		DisplayCharator[] arr = new DisplayCharator[] {
				new DisplayCharator("홍길동"),
				new DisplayCharator("이순신"),
				new DisplayCharator("강감찬")
				
		};
		
		for(DisplayCharator dc : arr) {
			dc.start();
		}
		
		for(DisplayCharator dc : arr) {
			try {
				dc.join();
			}catch(InterruptedException e) {
				
			}
		}
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + DisplayCharator.strRank);
	}
}

//A~Z까지 출력하는 쓰레드
class DisplayCharator extends Thread{
	
	//출력하는 순서대로 쓰레드 이름이 저장될 변수
	public static String strRank = "";
	private String name;
	
	//생성자
	public DisplayCharator(String name) {
		this.name = name;
	}
	
	
	@Override
	public void run() {
		for(char c = 'A'; c<='Z'; c++) {
			try {
				Thread.sleep((int)(Math.random()*100+1));
			}catch(InterruptedException e) {
			}
			System.out.println(name+"의 출력문자 :" + c);
		}
		System.out.println(name+"출력 끝...");
		
		//출력이 끝낸 순서대로 이름을 추가한다.
		strRank += name + " ";
	}
}
