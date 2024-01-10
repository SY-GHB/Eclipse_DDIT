package kr.or.ddit.basic.IO0105;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectIOTest03 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			ObjectOutputStream oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("e:/d_other/memObj.data")));
			while(true) {
				System.out.println("저장할 Member정보를 입력하세요.");
				System.out.println("이름 >> ");
				String name = sc.next();
				System.out.println("나이 >> ");
				int age = sc.nextInt();
				//buffer비우기
				sc.nextLine();
				System.out.println("주소 >> ");
				String adr = sc.nextLine();
				
				Member mem = new Member(name, age, adr);
				
				oout.writeObject(mem);
				
				System.out.println("계속하시겠습니까?(y/n) >> ");
				String ans = sc.next();
				if("n".equals(ans.toLowerCase())) {
					break;
				}
			}
			
			oout.writeObject(null);
			oout.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
