package pdfbox;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


//pdf 만들고 문서 생성하기
public class PdfboxTest01 {
	public static void main(String[] args) throws IOException {
		PDDocument dc = new PDDocument();
		
		//다 다른 페이지 객체를 사용해줘야 나중에 텍스트 삽입에서 따로 작동한다.
		PDPage myPage = new PDPage();
		PDPage myPage1 = new PDPage();
		PDPage myPage2 = new PDPage();
		dc.addPage(myPage);
		dc.addPage(myPage1);
		dc.addPage(myPage2);
		
		dc.save("d:/d_other/pdfExample.pdf");
		dc.close();
	}
}
