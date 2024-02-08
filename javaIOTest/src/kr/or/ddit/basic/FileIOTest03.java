package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 사용자로부터 출력할 단을 입력받아 구구단을 파일로 출력하는 프로그램 작성하기
		//(출력할 파일명 : 'd:/d_other/gugudan.txt')
		
		File file = new File("d:/d_other/gugudan.txt");
		
		FileOutputStream foutstream =  null;
		
		Scanner sc = new Scanner(System.in);
		try {
			foutstream = new FileOutputStream(file);
		
		System.out.println("출력할 단을 입력해주세요");
		int dan = sc.nextInt();
		
		String str = "";
		for(int i=1; i<=9; i++) {
			str += dan + " * " + i + " = " + dan*i + "\n"; 
		}
		
		byte[] arr = str.getBytes("utf-8");
		
		foutstream.write(arr);
		
		
		
		
		}catch(IOException e) {
			
		}finally {
			try {
				foutstream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
