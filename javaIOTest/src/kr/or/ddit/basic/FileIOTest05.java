package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {

	public static void main(String[] args) {
		// 사용자가 키보드로 입력한 내용을 그대로 파일로 저장하기
		
		try {
			//System.in ==> 콘솔(표준입출력장치)의 입력장치와 연결된 스트림 객체
			// 					(바이트 기반 스트림)
		
//		System.out.println("아무거나 입력하세요");	
//		System.out.println((char)System.in.read());
			
//		입력용 바이트 기반 스트림을 문자기반의 스트림으로 변환해야한다.
//		InputStreamReader클래스를 이용한다.
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = new FileWriter("d:/d_other/testchar.txt");
		
		System.out.println("아무내용이나 입력하세요");
		System.out.println("입력의 끝은 Ctrl + z키입니다.");
		
		int c ;
		// 콘솔에서 입력할때 입력의 끝은 Ctrl + z 키를 누르면 된다.
		while( (c=isr.read()) != -1) {
			fw.write(c); // 콘솔로 입력 받은 데이터를 파일로 출력하기;
		}
		
		isr.close();
		fw.close();
		
		}catch(IOException e){
			
		}
	}
}
