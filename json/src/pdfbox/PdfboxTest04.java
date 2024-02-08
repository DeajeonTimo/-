package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

//텍스트 불러오기
public class PdfboxTest04 {
	public static void main(String[] args) throws IOException {
		
		//파일 불러오기
		File file = new File("d:/d_other/pdfExample.pdf");
		PDDocument dc = PDDocument.load(file);
		PDPage page = dc.getPage(0);
		
		//PDFTextStripper클래스 인스턴스화
		PDFTextStripper pstr = new PDFTextStripper();
		
		//텍스트 검색
		String text1 = pstr.getText(dc);
		System.out.println(text1);
		
		//문서 닫기
		dc.close();
		
	}
}
