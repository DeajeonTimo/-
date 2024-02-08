package kr.or.ddit.basic;

import java.util.Arrays;

public class ThreadTest13_2 {

	public static void main(String[] args) {
		Horse2[] horseArr = new Horse2[] {
				new Horse2("01번말"),
				new Horse2("02번말"),
				new Horse2("03번말"),
				new Horse2("04번말"),
				new Horse2("05번말"),
				new Horse2("06번말"),
				new Horse2("07번말"),
				new Horse2("08번말"),
				new Horse2("09번말"),
				new Horse2("10번말"),
		};
		
		GameState gs = new GameState(horseArr);
		
		for(Horse2 h : horseArr) {
			h.start();
		}
		gs.start();
		
		for(Horse2 h : horseArr) {
			try {
				h.join();
			}catch(InterruptedException e) {
				
			}
		}
		
		try {
			gs.join();
		}catch(InterruptedException e) {
			
		}
		
		//배열 정렬하기 ==> Arrays.sort() 매서드를 이용한다.
		
		Arrays.sort(horseArr);
		
		for(Horse2 h : horseArr) {
			System.out.println(h);
		}
	}
}

class Horse2 extends Thread implements Comparable<Horse2>{
	public static int currentRank = 0; // 말의 현재 등수를 구하는 변수
	
	private String horseName;
	private int location;
	private int rank;
	
	public Horse2(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		
		return "경주마"+horseName+"은(는)"+ rank+"등 입니다.";
	}
	//등수의 오름차순 정렬 기준 만들기.
	@Override
	public int compareTo(Horse2 horse) {
		
		return Integer.compare(this.rank,horse.getRank());
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			location = i; // 말의 현재 위치
			
			try {
				Thread.sleep((int)(Math.random()*400));
			}catch(InterruptedException e) {
				
			}
		}
		//말 한마리의 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		rank = currentRank;
		
	}
	
}

class GameState extends Thread{
	private Horse2[] horseArr; // 경주에 참가하는 말들이 저장될 배열

	public GameState(Horse2[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while(true) {
			if(Horse2.currentRank==horseArr.length) {
				break;
			}
			// 배열의 갯수만큼 반복
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName() + " : ");
				for(int j=1; j<=50; j++) {
					if(j==horseArr[i].getLocation()) {
						System.out.print(">");
					}else {
					System.out.print("-");
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
}

