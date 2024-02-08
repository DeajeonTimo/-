package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// '*'문자 200개 출력,  '$'문자 200개 출력
		
		// 멀티 쓰레드 프로그램
		
		// 방법1
		//	==> Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를
		//		생성한다. 
		//		이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		
		// 방법2
		// 	==> Runnable인터페이스를 구현한 class를 작성한 후 이 class의
		//		인스턴스를 생성한다.
		//		이 인스턴스를 Thread클래스의 인스턴스를 생성할 때 생성자의 인자값으로
		//		넣어 생성한다.
		//		이 때 생성된 Thread클래스의 인스턴스의 start()메서드를 호출해서 실행한다.
		MyRunner1 r = new MyRunner1();
		Thread th2 = new Thread(r);
		th2.start();
		
		// 방법2-1
		//		==> Runnable인터페이스의 익명 구현체를 이용하는 방법
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				// '@'문자 200개 출력
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		Thread th3 = new Thread(r2);
		th3.start();
		
		
		
		System.out.println("main메서드 끝...");
	}

}

// 방법1) Thread클래스를 상속한 class 작성
class MyThread1 extends Thread{
	
	@Override
	public void run() {
		// 이 run()메서드에는 이 쓰레드가 처리할 내용을 작성하면 된다.
		// 예시) '*'문자 200개 출력
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간); ==> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//	'시간'은 밀리세컨드 단위를 사용한다. 즉, 1초는 1000으로 나타낸다.
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}  // MyThread1클래스 끝...


// 방법2) Runnable인터페이스를 구현한 class작성
class MyRunner1 implements Runnable{
	
	@Override
	public void run() {
		// 이 run()메서드에는 이 쓰레드가 처리할 내용을 작성하면 된다.
		// 예시) '$'문자 200개 출력
		for(int i=1; i<=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}




