package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

//페이지 삭제하기
public class PdfboxTest02 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/d_other/pdfExample.pdf");
		//불러오기
		PDDocument dc = PDDocument.load(file);
		
		//페이지 수 확인
		int noOfPages = dc.getNumberOfPages();
		System.out.println(noOfPages);
		
		//특정 페이지 삭제, index는 0부터 시작, 뒷페이지부터 삭제해야 한다.
		dc.removePage(2);
		dc.removePage(1);
		dc.save(file);
		dc.close();
		
	}
}
