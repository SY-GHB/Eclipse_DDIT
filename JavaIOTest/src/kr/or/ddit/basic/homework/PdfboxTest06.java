package kr.or.ddit.basic.homework;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

//이미지 삽입하기
public class PdfboxTest06 {
	public static void main(String[] args) throws IOException {
		File file = new File("e:/d_other/pdfExample.pdf");
		PDDocument dc = PDDocument.load(file);
		
		//파일 불러오고 페이지 지정
		PDPage page = dc.getPage(0);
		
		//PDImageXObject 객체 생성
		PDImageXObject img = PDImageXObject.createFromFile("C:\\Users\\PC-03\\Desktop\\images\\카푸치노.jpg", dc);
		
		PDPageContentStream cs = new PDPageContentStream(dc, page);
		
		//이미지 위치 지정
		cs.drawImage(img, 0,0);
		cs.close();
		dc.save(file);
		dc.close();
	}
}
