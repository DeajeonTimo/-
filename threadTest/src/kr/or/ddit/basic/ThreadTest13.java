package kr.or.ddit.basic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String),말의 위치(int) 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간 중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수 순으로 출력한다.

 */

public class ThreadTest13 {

	public static void main(String[] args) {
		
		ArrayList<Horse> arr = new ArrayList<Horse>();
		arr.add(new Horse("01번마"));
		arr.add(new Horse("02번마"));
		arr.add(new Horse("03번마"));
		arr.add(new Horse("04번마"));
		arr.add(new Horse("05번마"));
		arr.add(new Horse("06번마"));
		arr.add(new Horse("07번마"));
		arr.add(new Horse("08번마"));
		arr.add(new Horse("09번마"));
		arr.add(new Horse("10번마"));
		
		
		PrintHorse ph = new PrintHorse(arr);
		
		for(Horse h : arr) {
			h.start();
		}
			ph.start();
		for(Horse h : arr) {
			try {
				h.join();
			}catch(InterruptedException e) {
				
			}
		}
		try {
			ph.join();
		}catch(InterruptedException e) {
			
		}
		Collections.sort(arr);
	
		for(Horse h : arr) {
			System.out.println( h.rank+"등"+"  "+h.name);
		}	
		
	}
}

class Horse extends Thread implements Comparable<Horse>{
	public static int totalRank = 1;
	String name;
	int position;
	int rank =0;
	
	
	public Horse(String name) {
		this.name = name;
	}

	@Override
		public void run() {
			for(int i=1; i<=50; i++) {
				try {
					Thread.sleep((int)(Math.random()*500));
				}catch(InterruptedException e) {
				
				}
				position = i;
				}
			this.rank = totalRank;
			totalRank++;
			}
	@Override
	public int compareTo(Horse h) {
		
		return this.rank-h.rank;
	}
}

class PrintHorse extends Thread{
	ArrayList<Horse> arr;
	
	PrintHorse(ArrayList<Horse> arr){
		this.arr= arr;
	}
	
	
	@Override
	public void run() {
		System.out.println("경주를 시작합니다.");
		
		while(true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {	
			}
			int finish = 0;
			for(int j=0; j<arr.size(); j++) {
				System.out.print(arr.get(j).name + " ");
				int position = arr.get(j).position;
				for(int k=1; k<position;k++) {
					System.out.print("-");
				}System.out.print(">");
				for(int x=position;x<50; x++) {
					System.out.print("-");
				}
				System.out.println();
				if(position == 50) {
					finish++;
				}
			}
			if(finish==arr.size()) {
				break;
			}
		}
		System.out.println("경기가 종료 되었습니다.");
	}
}
