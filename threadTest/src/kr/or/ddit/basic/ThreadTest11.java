package kr.or.ddit.basic;

/*
 	Thread의 stop()매서드를 호충하면 쓰레드가 즉시 멈춘다.
 	이 때 사용하던 자원을 정리하지 못하고 쓰레드가 종료되어 다른 프로그램이나 
 	쓰레드에 영향을 줄 수 있다.
 	그래서 stop() 매서드는 비추천으로 되어있다.
 	
 	 */


public class ThreadTest11 {

	public static void main(String[] args) {
//		ThreadStopTest01 th1 = new ThreadStopTest01();
//		th1.start();
		
//		try {
//			Thread.sleep(1000);
//		}catch(InterruptedException e) {
//			
//		}
//
//		th1.stop();
		
//		th1.setStop(true);
		
		//interrupted()매서드를 이용한 쓰레드 멈추기.
		ThreadStopTest02 th2 = new ThreadStopTest02();
		th2.start();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		th2.interrupt();
		
	}
}

// interrupt()매서드를 이용하여 쓰레드를 멈추게 하는 연습용 쓰레드
class ThreadStopTest02 extends Thread{
	
	@Override
	public void run() {
//		// 방법1. interrupt()매서드와 sleep()매서드를 이용하는 방법
//		try {
//			while(true) {
//				System.out.println("실행 중...");
//				Thread.sleep(1); // 일시정지상태에서 interrupt()매서드가 호출되면 InterruptedException이 발생한다.
//			}
//		}catch(InterruptedException e) {
//			
//		}
		
		//방법2. 
		while(true) {
			System.out.println("쓰레드 실행중");
			
			//interrupted()매서드가 호출되었는지 검사한다.
			
			//검사 방법 1 : Thread의 인스턴스 매서드인 isInterrupted()매서드를 이용한다.
			//				isInterrupted()매서드는 interrupt()매서드가 호출되면 true를 반환한다.
			
//			if(this.isInterrupted()) {
//				break;
//			}
			
			//검사방법 2 : Thread의 정적매서드인 interrupted()매서드를 이용한다.
			//				interrupted()매서드도 interrupted매서드가 호출되면 true를 반환한다.
			if(Thread.interrupted()) {
				break;
			}
		}
		
		System.out.println("자원 정리...");
		System.out.println("쓰레드 종료...");
	}
}


//쓰레드를 멈추게하는 연습용 쓰레드
class ThreadStopTest01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;		
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("쓰레드 실행중...");
		}
		
		System.out.println("자원 정리...");
		System.out.println("쓰레드 종료...");
	}
}
