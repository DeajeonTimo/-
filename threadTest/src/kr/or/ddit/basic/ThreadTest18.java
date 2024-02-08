package kr.or.ddit.basic;
/*
 	wait(), notify() 매서드를 이용한 예제
 		(두 쓰레드가 번갈아 한번씩 실행되는 예제)
 		
 	wait(), notify(), notifyAll()은 동기화 영역에서만 사용 가능하다.
 */
public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		Thread thA = new ThreadA(workObj);
		Thread thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}
}

//공통으로 사용할 객체

class WorkObject{
	public synchronized void method01(){
		System.out.println("method01()매서드 실행중...");
		
		notify();
		
		try {
			wait();
		}catch (InterruptedException e) {
			
		}
	}
	public synchronized void method02(){
		System.out.println("method02()매서드 실행중...");
		
		notify();
		
		try {
			wait();
		}catch (InterruptedException e) {
			
		}
	}
}

//WorkObject(공통으로 사용하는 객체)의 method01()매서드만 호출하는 매서드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.method01();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}


//WorkObject의 METHOD02()매서드만 호출하는 쓸[드]

class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.method02();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}