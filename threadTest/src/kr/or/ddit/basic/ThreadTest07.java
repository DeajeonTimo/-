package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위바위보는 난수를 이용해서 구하고
 	
 	사용자의 입력은 showInputDialog()매서드를 이용해서 입력받는다.
 	
 	입력 시간은 5초로 제한하고 카운트 다운을 한다.
 	
 	5초안에 입력이 없으면 게임에 진것으로 처리한다.
 	
 	5초안에 입력이 완료되면 승패를 구해서 출력한다.
 	
 	결과 예시
 		1) 5초안에 입력을 못했을때
 			-- 결 과 --
 		시간초과로 당신이 졌습니다.
 		
 		2) 5초안에 입력을 완료했을때 
 			-- 결 과 --
 			컴퓨터 : 가위
 			사용자 : 바위
 			결 과 : 당신이 이겼습니다.
 		
 */

public class ThreadTest07 {

	public static void main(String[] args) {
		
		Thread th1 = new CountDown();
		Thread th2 = new DataInput1();
		
		th1.start();
		th2.start();
	}
}

class CountDown extends Thread{
	
	
	@Override
	public void run() {
		
		for(int i=5; i>=1; i--) {
			if(DataInput1.checker) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
		System.out.println("입력시간을 초과하였습니다.");
		System.out.println("게임에서 졌습니다.");
		System.exit(0);
	}
}


class DataInput1 extends Thread{
	
	public static boolean checker = false;
	@Override
	public void run() {
		//컴퓨터의 가위바위보 정하기
		String str="";
		int sel = (int)(Math.random()*3);
		switch(sel){
			case 0: str="가위";
				break;
			case 1: str="바위";
				break;
			case 2: str="보";
				break;
		}
		//사용자에게 가위, 바위, 보 입력받기.
		String user = "";
		while(true) {
			user = JOptionPane.showInputDialog("가위, 바위, 보 중 하나를 입력해주세요. ");
			if(user.equals("가위") || user.equals("바위") || user.equals("보")) {
				break;
			}
		}
		
		String result = "";
		if(str.equals(user)) {
			result = "비겼습니다.";
		}else if((str.equals("가위") && user.equals("바위")) || (str.equals("바위") && user.equals("보")) || (str.equals("보") && user.equals("가위"))) {
			result = "당신이 이겼습니다.";
		}else {
			result = "당신이 졌습니다.";
		}
//		}else if((str.equals("바위") && user.equals("보"))) {
//			result = "당신이 이겼습니다.";
//		}else if(str.equals("바위") && user.equals("가위")) {
//			result = "당신이 졌습니다.";
//		}else if(str.equals("보") && user.equals("가위")) {
//			result = "당신이 이겼습니다.";
//		}else if(str.equals("보") && user.equals("바위")) {
//			result = "당신이 졌습니다.";
//		}
		
		//사용자와 컴퓨터의 값을 비교하기.
		System.out.println("컴퓨터 : " + str);
		System.out.println("사용자 : " + user );
		System.out.println("결 과 : " + result);
		
		checker = true;
	}
}






