package kr.or.ddit.basic;

// yield() 매서드 연습

public class ThreadTest10 {

	public static void main(String[] args) {
		YieldTest th1 = new YieldTest("1번 쓰레드");
		YieldTest th2 = new YieldTest("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(1);
		}catch (InterruptedException e) {
		}
		
		System.out.println("11111111111---------------------------------------");
		th1.work = false;
		
		try {
			Thread.sleep(1);
		}catch (InterruptedException e) {
			
		}
		System.out.println("222222222*************************************");
		th1.work = true;
		
		try {
			Thread.sleep(1);
		}catch (InterruptedException e) {
			
		}
		System.out.println("333333333333333!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		th1.stop = true;
		th2.stop = true;
	}
	
}

// yield()매서드 연습용 쓰레드

class YieldTest extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	//생성자
	public YieldTest(String name) {
		//this => 자기 자신이 참조값이 저장된 변수
		//this() => 생성자에서 다른 생성자를 호출할때 사용
		
		//super ==> 부모의 참조값이 저장된 변수
		//super ==> 부모의 생성자를 호출할때 사용한다.
		super(name); // 쓰레드의 이름을 설정하는 생성자 호출
	}
	@Override
	public void run() {
		//stop이 true가 되면 반복문이 종료된다.
		while(!stop) {
			if(work) {
				//getName()매서드 : 현재 쓰레드의 name값을 반환한다.
				System.out.println(getName()+"작업중..");
			}else {
				System.out.println(getName()+"양보..");
				Thread.yield();
			}
		}
	}
}