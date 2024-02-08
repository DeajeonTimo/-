package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		//쓰레드가 수행되는 시간을 체크해보자.
		Thread th = new Thread(new MyRunner());
		
		//1970년 1월 1일 0시 0분 0초(GMT 0)부터 경과한 시간을 밀리세컨트단위로 표현.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		
		try {
			th.join(); // 현재 위치에서 대상이되는 쓰레드(변수 th)가 실행이 끝날때까지 기다린다. 
		}catch (InterruptedException e) {
			
		}
		
		long endTime = System.currentTimeMillis();
		
		
		System.out.println("경과시간 : " + (endTime-startTime));
		
	}
}

class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}
