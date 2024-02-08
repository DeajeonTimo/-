package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
		
	 문제3) '문제2'에서 입력하는 별명의 길이가 같은 것이 있을 수 있을 때
	 	결과를 출력하시오.

*/
public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("별명을 5번 입력하세요...");
		for(int i=1; i<=5; i++) {
			System.out.print(i + "번째 별명 : ");
			String alias = scan.nextLine();
			aliasList.add(alias);
		}
		
		// 제일 긴 별명의 길이가 저장될 변수를 선언하고, 첫번째 데이터의 길이로 초기화 한다.
		int maxLength = aliasList.get(0).length();
		
		for(int i=1; i<aliasList.size(); i++) {
			if(maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for(String alias : aliasList) {
			if(alias.length() == maxLength) {
				System.out.println(alias);
			}
		}
		

	}

}
