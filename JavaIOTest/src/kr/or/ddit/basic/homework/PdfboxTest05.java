package kr.or.ddit.basic.homework;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

//문서 분할하기
public class PdfboxTest05 { 
	public static void main(String[] args) throws IOException {
		File file = new File("e:/d_other/pdfExample.pdf");
		PDDocument dc = PDDocument.load(file);
		
		//Splitter클래스 인스턴스화
		Splitter splitter = new Splitter();
		
		//PDF 문서 분할
		List<PDDocument> pages = splitter.split(dc);
		//목록의 iterator 얻기
		Iterator<PDDocument> pit = pages.listIterator();
		int i = 1;
		while(pit.hasNext()) {
			PDDocument pd = pit.next();
			pd.save("e:/d_other/pdfExample"+i+".pdf");
			i++;
		}
		System.out.println("분할된 문서가 생성되었습니다.");
		dc.close();
	}
}
