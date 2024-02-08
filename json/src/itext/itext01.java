package itext;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

// PDF 에 한글을 작성하는 예제입니다. iTextAsian.jar 파일이 꼭 필요합니다.
// 앞의 예제에서 한글이 입력이 되지 않은 것을 확인 할 수 있었습니다.

public class itext01 {    

    public static void main(String[] args) {

        // com.lowagie.text.Document 클래스 인스턴스를 생성합니다.
        Document document = new Document();    
        File file = new File("d:/d_other/ItextExample2.PDF");

        try {
        	// Writer와 Document 사이의 연관을 맺어줍니다.
            PdfWriter.getInstance(document, new FileOutputStream(file));    

            // 문서를 오픈합니다.
            document.open();

            // 한글을 사용하기 위해 폰트를 설정해줍니다.
            // 글자 방향을 결정하는 CMap은 두가지가 있습니다. 
            // UniKS-UCS2-H : 가로, UniKS-UCS2-V : 세로
            
            
           
            Font font = new Font(BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED), 20);
            Font font2 = new Font(BaseFont.createFont("HYSMyeongJo-Medium", "UniKS-UCS2-V", BaseFont.NOT_EMBEDDED), 20);
            

            // 문서에 2개의 paragraph를 각기 다른 본트로 첨부해 보겠습니다.
            document.add(new Paragraph("안녕하세요", font));    
            document.add(new Paragraph("반갑습니다", font2));

            // 테이블을 생성해줍니다.
            // com.lowagie.text.Table 에는 세가지 생성자가 있습니다.
            // Table (int columns), Table(int columns, int rows), Table(Properties attributes)
            Table table = new Table(3, 3);    // 가로 세로 1개짜리 테이블 생성
            table.setBorderWidth(2);    // 테이블 테두리 두께 설정 : 2
            table.setBorderColor(new Color(0,0,255));    // 테두리 색상 파랑색으로 설정
            table.setPadding(5); // padding 설정
            table.setSpacing(5); // spacing 설정
            table.setBackgroundColor(new Color(222,222,222));    // 테이블 배경색 설정
 
            // 테이블에 cell을 추가해 문장도 작성할 수 있습니다.
            Cell cell = new Cell(new Paragraph("테이블 생성 예제입니다.", font));
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
            table.addCell(cell);
 
            // 문서에 작성해둔 테이블 객체를 추가해줍니다.
            document.add(table);
            
            // 문서에 줄바꿈을 추가해줍니다.
            
            document.add(new Paragraph("줄바꿈",font));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("줄바꿈",font));
            
            // 사용할 이미지 객체를 생성해줍니다. 
            Image jpeg = Image.getInstance("d:/d_other/펭귄.jpg");
                        
            // 사이즈를 50% 조정
            jpeg.scalePercent(50);
            
            
            // 문서에 이미지를 추가해줍니다.
            document.add(jpeg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();    
        }

        // Chrome 으로 방금 작성한 파일을 바로 열어서 확인해봅니다.
        String chrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";
        try {
            new ProcessBuilder(chrome,file.getAbsolutePath()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
