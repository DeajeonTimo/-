package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest07 {

	public static void main(String[] args) {
		//사용자로부터 출력할 단을 입력 받아 구구단을 파일로 출력하는 프로그램 작성하기
		//출력할 파일명 : 'd:/d_other/gugudan2.txt'
		//문자 기반 스트림을 이용해서 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			FileWriter fw = new FileWriter("d:/d_other/gugudan.txt");
			
			System.out.println("출력할 단을 입력해 주세요");
			int dan = sc.nextInt();
			
			String str = "";
			
			for(int i=1; i<=9; i++) {
				str += dan + " * " + i + " = " + dan*i + "\n";
			}
			
			fw.write(str);
			
			fw.close();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
