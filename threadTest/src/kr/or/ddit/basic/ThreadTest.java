package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest {
	public static boolean inputCheck = false;
	
	
	public static void main(String[] args) {
		GameCountDown gcd = new GameCountDown();
		
		//난수를 이용해서 컴퓨터의 가위 바위 보를 정하기
		String [] data = {"가위","바위","보"};
		int index = (int)(Math.random()*3); // 0~2범위의 난수 만들기
		String com = data[index]; // 컴퓨터의 가위 바위 보 정하기
		
		//사용자의 가위 바위 보 입력받기
		gcd.start(); // 카운트 다운 시작
		
		String man = null;
		do {
			man = JOptionPane.showInputDialog("가위바위보를 입력하세요");
		}while(!("가위".equals(man)||"바위".equals(man)||"보".equals(man)));
		inputCheck = true;
		
		// 결과 판정하기
		
		String result = null;
		if(com.equals(man)) {
			result = "비겼습니다.";
		}else if((com.equals("가위") && man.equals("보")) ||
				 (com.equals("바위") && man.equals("가위"))||
				 (com.equals("보") && man.equals("바위"))) {
			result = "당신이 졌습니다.";
		}else {
			result = "당신이 이겼습니다";
		}
		
		//결과 출력하기
		System.out.println(" -- 결 과 - - ");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : "+ man);
		System.out.println("결 과 : " + result);
	}
}

class GameCountDown extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운 시작...");
		for(int i=5; i>=1; i--) {
			//입력 완료 여부 검사
			if(ThreadTest.inputCheck) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println(" -- 결 과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
	}
}