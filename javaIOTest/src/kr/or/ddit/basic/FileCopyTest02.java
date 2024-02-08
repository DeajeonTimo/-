package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/*

'd: d/_other' 폴더에 있는 '펭귄.jpg' 파일을
'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램을 작성하시오.


*/
public class FileCopyTest02 {
	
	public File chooseFile(String option) {
		//SWING의 파일 열기 , 저장 창 연습
		
				JFileChooser chooser  = new JFileChooser();
				
				//선택할 파일의 확장자 설정하기
				FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일(*.txt)", "txt");
				
				FileNameExtensionFilter img = new FileNameExtensionFilter("이미지파일", new String[] {"png", "jpg", "gif"});
				
				FileNameExtensionFilter doc = new FileNameExtensionFilter("MS워드", "doc", "docx");
				
				chooser.addChoosableFileFilter(txt);
				chooser.addChoosableFileFilter(img);
				chooser.addChoosableFileFilter(doc);
				
				//Dialog 창에 기본으로 보여질 디렉토리 설정
				chooser.setCurrentDirectory(new File("d:/d_other"));
				
				int result;
				if("SAVE".equals(option.toUpperCase())) {
					 result = chooser.showOpenDialog(new Panel()); // 열기용 창
				}else if("OPEN".equals(option.toUpperCase())) {
					 result = chooser.showSaveDialog(new Panel()); // 저장용 창
				}else {
					System.out.println("Option은 'SAVE' 또는 OPEN만 가능합니다.");
					return null;
				}
				
				//Dialog 창의 기본 파일 유형 설정
				chooser.setFileFilter(img);
			
				
				File selectedfile = null;
				// dialog 창에서 '열기' 또는 '저장' 버튼을 눌렀을 경우
				if(result== JFileChooser.APPROVE_OPTION) { 
					//Dialog 창에서 선택한 파일 정보를 가져와 실제 '저장' 또는 '읽기' 작업을 수행한다.
					selectedfile = chooser.getSelectedFile();
				}
				
				return  selectedfile;
					
	}

	public static void main(String[] args) {
		
		FileCopyTest02 test = new FileCopyTest02();
		
//		File file = new File("d:/d_other/펭귄.jpg");
		File file = test.chooseFile("OPEN");
		if(file==null) {
			System.out.println("원본 파일을 선택하세요...");
			return;
		}
		
		if(file.exists()) {
			System.out.println(file.getName() + " 파일이 없습니다.");
			System.out.println("복사작업을 중지합니다.");
		}
		
		
		try {
			//원본 파일을 읽어올 스트림 객체 생성
			FileInputStream fis = new FileInputStream(file);
			
			File targetFile = test.chooseFile("SAVE");
			
			if(targetFile==null) {
				System.out.println("대상 파일을 지정하지 않았습니다.");
				System.out.println("복사작업을 중지합니다.");
			}
			
			//대상 파일에 저장할 스트림 객체 생성
//			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			FileOutputStream fos = new FileOutputStream("targetFile");
			
			System.out.println("복사작업 시작");
			
			int data;
			
			while((data=fis.read()) !=-1) {
			
				fos.write(data);
			}
			
			fis.close();
			
			fos.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
