package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTable.PrintMode;

public class PhoneBookTest {
	 Scanner sc = new Scanner(System.in);
	 HashMap<String, Phone> map = new HashMap<String, Phone>();
     
//     String name;
//     String tel;
//     String addr;
     
	public static void main(String[] args) {
		PhoneBookTest pb = new PhoneBookTest();
		
		pb.useBook();
		
		//여기서는 실행만 하자.
	}
	
	
	public void useBook() {
		while (true) {
			printMenu();
			System.out.println("메뉴 선택 >> ");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				insertNum();
				break;
			case 2:
				updateNum();
				break;
			case 3:
				deleteNum();
				break;
			case 4:
				searchNum();
				break;
			case 5:
				printListNum();
				break;
			case 0:
				System.out.println("전화번호부를 종료합니다.");
				return;
			default:
				break;
			}
		}
	}
	
	
	//메뉴 출력
	public void printMenu() {
		System.out.println("───────────────────────────────────────────────");
		System.out.println("\t\t메뉴");
		System.out.println("───────────────────────────────────────────────");
		System.out.println("\t\t1. 전화번호 등록");
		System.out.println("\t\t2. 전화번호 수정");
		System.out.println("\t\t3. 전화번호 삭제");
		System.out.println("\t\t4. 전화번호 검색");
		System.out.println("\t\t5. 전화번호 전체 출력");
		System.out.println("\t\t0. 프로그램 종료");
		System.out.println("───────────────────────────────────────────────");
	}
	
	// 이미 등록된 사람인지 확인하는 메소드
	public String checkNumOk(String name) {
		boolean check = map.containsKey(name);
		
		if(check==true) {
			System.out.println("이미 전화번호부에 등록된 사람입니다.");
			System.out.println("이름을 다시 입력해주세요.");
			name = sc.next();
		}
		return name;
	}
	
	// 아직 전화번호부에 없는 사람인지 확인하는 메소드
	public String checkNumNot(String name) {
		boolean check = map.containsKey(name);
		
		if(check==false) {
			System.out.println("전화번호부에 등록되지 않은 사람입니다.");
			System.out.println("이름을 다시 입력해주세요.");
			name = sc.next();
		}
		return name;
	}
	
	// 전화번호를 등록하는 메소드
	public void insertNum() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.println("이름 >> ");
		String name = sc.next();
		name = checkNumOk(name);
		
		System.out.println("전화번호 >> ");
		String tel = sc.next();
		
		sc.nextLine(); //입력 버퍼 비우기
		System.out.println("주소 >> ");
		String addr = sc.nextLine();
		
		Phone phone = new Phone();
		phone.setName(name);
		phone.setTel(tel);
		phone.setAddr(addr);
		
		map.put(name, phone);
		System.out.println(name + "정보가 입력되었습니다.");
		
		//이런 방법도 있다: 다만, 이 방법은 Phone에 String, String, String을 매개변수로 받는 생성자가 있을 때 사용가능하다.
//		map.put(name, new Phone(name, tel, addr));
	}
	
	
	//전화번호를 수정하는 메소드
	public void updateNum() {
		System.out.println("검색할 이름을 입력하세요 >> ");
		String name = sc.next();
		name = checkNumNot(name);

		System.out.println("새로운 번호 >> ");
		String tel = sc.next();
		map.get(name).setTel(tel);
		
		
		sc.nextLine(); // 입력 버퍼 비우기
		System.out.println("새로운 주소 >> ");
		String addr = sc.nextLine();
		map.get(name).setAddr(addr);
		
		System.out.println(name+"씨의 수정이 완료되었습니다.");
	}
	
	//전화번호를 삭제하는 메소드
	public void deleteNum() {
		System.out.println("삭제할 이름을 입력하세요 >> ");
		String name = sc.next();
		name = checkNumNot(name);
		
		map.remove(name);
		System.out.println(name+"씨의 삭제가 완료되었습니다.");
	}
	
	// 전화번호를 검색하는 메소드
	public void searchNum() {
		System.out.println("검색할 이름을 입력하세요 >> ");
		String name = sc.next();
		name = checkNumNot(name);
		
		System.out.println("───────────────────────────────────────────────");
		System.out.println("이름\t전화번호\t\t주소");
		System.out.println("───────────────────────────────────────────────");
		System.out.println(name +"\t"+ map.get(name).getTel() +"\t"+ map.get(name).getAddr());
		System.out.println("───────────────────────────────────────────────");
	}
	
	
	public void printListNum() {
		System.out.println("───────────────────────────────────────────────");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("───────────────────────────────────────────────");
		// 여기에.출력문이.들어가야겟죠?
		
		
		Set<String> keySet = map.keySet();
		
		if(keySet.size()==0) {
			System.out.println("\t등록된 번호가 없습니다.");
		}
			
		Iterator<String> it = keySet.iterator();
		int i = 1;
//		while(it.hasNext()) {
//			String key= it.next();
//			Phone value = map.get(key);
//			String name = value.getName();
//			String tel = value.getTel();
//			String addr = value.getAddr();
//			System.out.println(i+"\t"+name+"\t"+tel+"\t"+addr);
//			i++;
//		}
		
		for (String name : keySet) {
			Phone p = map.get(name);
			System.out.println(i+"\t"+p.getName()+"\t"+p.getTel()+"\t"+p.getAddr());
			i++;
		}
		System.out.println("───────────────────────────────────────────────");
	}
}


class Phone {
	String name;
	String addr;
	String tel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	/*
	 Scanner가 가진 메서드들의 특징
	 - next(), nextInt(), nextDouble() ....
	  ==> 사이띄기(space), Tap, Enter키를 구분문자로 분리해서 분리된 자료만 읽어간다.
	  
	 - nextLine()
	  ==> 한 줄 단위로 읽어간다. 즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 Enter키를 뺀 나머지 데이터를 반환한다.
	 
	 
	 */
	
}