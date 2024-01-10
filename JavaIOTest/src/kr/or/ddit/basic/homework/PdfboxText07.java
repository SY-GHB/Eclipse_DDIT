package kr.or.ddit.basic.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

//문서 병합하기
public class PdfboxText07 {
	public static void main(String[] args) throws IOException {
		//PDFMergerUtility 클래스 인스턴스화
		PDFMergerUtility merg = new PDFMergerUtility();
		
		//대상 파일 지정
		merg.setDestinationFileName("e:/d_other/pdfExample00.pdf");
		
		//원본 파일 지정
		File file2 = new File("e:/d_other/pdfExample2.pdf");
		File file3 = new File("e:/d_other/pdfExample3.pdf");
		
		merg.addSource(file2);
		merg.addSource(file2);
		merg.addSource(file3);
		merg.addSource(file3);
		
		//병합하기
		merg.mergeDocuments();
;	}
}
