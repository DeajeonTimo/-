package kr.or.ddit.basic;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool.SynchronizedGrammarPool;

public class ThreadTest16 {
	
	private int balance; // 잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금을 처리하는 매서드
	public void deposit(int money) {
		balance += money;
	}
	
	//출금을 처리하는 매서드 (출금 성공 : true,  출금 실패 : false)
	public synchronized boolean withdraw(int money) {
		if(balance>=money) { //출금 여부 검사
			for(int i=1; i<100000000;i++) {
				int k=i;
				//시간 지연용 반복문
			}
			balance-=money;
			System.out.println("매서드 안에서 balanace =" + getBalance() );
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();
		account.setBalance(10000); // 잔액을 10000원으로 설정
		
		//익명 구현체로 쓰레드 구현
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("쓰레드에서 result " + result + ", balance = " + account.getBalance());
				
			}
		};
		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
	}
}
