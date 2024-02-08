package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest01 {
	/*
	 
	 'd: d/_other' 폴더에 있는 '펭귄.jpg' 파일을
	 'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램을 작성하시오.
	 
	 
	 */
	public static void main(String[] args) {
		File file = new File("d:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getName() + " 파일이 없습니다.");
			return;
		}
		
		
		try {
			//원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fis = new FileInputStream("d:/d_other/펭귄.jpg");
			BufferedInputStream bin = new BufferedInputStream(fis);
			
			//대상 파일에 저장할 스트림 객체 생성
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fos);
			
			System.out.println("복사작업 시작");
			
			int data;
			
//			while((data=fis.read()) !=-1) {
//			
//				fos.write(data);
//			}
			
			while((data=bin.read()) !=-1) {
				
				bout.write(data);
			}
			
//			fis.close();
//			
//			fos.close();
			
			bin.close();
			bout.close();
			
			System.out.println("복사작업완료");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
