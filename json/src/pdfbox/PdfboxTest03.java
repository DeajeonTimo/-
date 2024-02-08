package pdfbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

//텍스트 삽입하기
public class PdfboxTest03 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/d_other/pdfExample.pdf");
		//문서열고
		PDDocument dc = PDDocument.load(file);
		//작업할 페이지 가져오기
		PDPage page = dc.getPage(0);
		
		//컨텐츠스트림 준비, 작업문서, 현 작업페이지, 모드, 압축설정
		//PDPageContentStream.AppendMode.APPEND이 없으면 페이지를 덮어씌운다.
		PDPageContentStream cs = 
//				new PDPageContentStream(dc, page, PDPageContentStream.AppendMode.APPEND, true);
				new PDPageContentStream(dc, page);
		
		float pageW = page.getCropBox().getWidth();
		float pageH = page.getCropBox().getHeight();
		System.out.println("가로: "+pageW +"\n세로: " +pageH);
		
		// --텍스트 시작
		
		cs.beginText();
		
		//폰트 설정
//		cs.setFont(PDType1Font.TIMES_ROMAN, 35);
		PDType0Font font = PDType0Font.load(dc,new FileInputStream("d:/d_other/TAEBAEKfont.ttf"));
		cs.setFont(font, 12);
		
		//행간 설정
		cs.setLeading(35f);
		
		// 텍스트 위치 설정
		cs.newLineAtOffset(25, 700);
		
		//텍스트 삽입
		String text1 = "3rd - we'll start to write long text";
		String text2 = "Jackson JSON Gson";
		String text3 = "She wants to dance like Uma Thurman Bury me till I confess";
		cs.showText(text1);
		
		//새 줄을 사용하여 다중 문자열 삽입
		cs.newLine();
		cs.showText(text2);
		cs.newLine();
		cs.showText(text3);
		
		String text = "입력한 텍스트";
		cs.showText(text);
		
		// --텍스트 끝
		cs.endText();
		
		//컨텐츠스트림을 닫고
		cs.close();
		
		dc.save(file);
		//문서를 닫아준다.
		dc.close();
	}
}
