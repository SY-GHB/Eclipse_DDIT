package kr.or.ddit.basic.IO0104;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {
	public static void main(String[] args) {
		// SWING의 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		// 선택할 파일의 유형과 확장자 설정하기
//		new FileNameExtensionFilter(description, extensions) description: 화면에 보이는 글씨, extensions확장자
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일(*.txt)", "txt");
		
		//확장자가 여러개일 경우 1. String 배열로 쓸 수 있다.
		FileNameExtensionFilter img = new FileNameExtensionFilter("이미지파일", new String[]{"jpg", "png", "gif"});
		
		//확장자가 여러개일 경우 2. 그냥 나열하기
		FileNameExtensionFilter doc = new FileNameExtensionFilter("MS워드", "doc", "docx");
		
		chooser.addChoosableFileFilter(txt);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(doc);
		
		
		//확장자 목록 중 기본적으로 선택될 확장자 지정하기
		chooser.setFileFilter(img);
		
		//setCurrentDirectory(): Dialog창에 보여줄 기본디렉토리를 설정할 수 있다.
		chooser.setCurrentDirectory(new File("e:/d_other"));
		
		
		//showOpenDialog 열기용 창
//		int result = chooser.showOpenDialog(new Panel());
		//showSaveDialog 저장용 창
		int result = chooser.showSaveDialog(new Panel());
		
		
		// dialog 창에서 '열기' 또는 '저장'버튼을 눌렀을 경우.
		if(result == JFileChooser.APPROVE_OPTION) {
			// Dialog 창에서 선택한 파일 정보를 가져와
			// 실제 '저장'또는 '읽기'작업을 수행한다.
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일: " + selectedFile.getAbsolutePath());
		}
	}
}
