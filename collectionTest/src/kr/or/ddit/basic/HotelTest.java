package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	HashMap<Integer, Room> map = new HashMap<Integer, Room>();
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	// hoteltest 클래스의 생성자에서는 방번호와 방종류를 초기화한다.
	// Map에 방 정보를 미리 등록하는 작업
	
	public static void main(String[] args) {
		
		System.out.println("───────────────────────────────────────────────");
		System.out.println(".*。ː˚※。호텔 문을 열었습니다. 어서오십시오.。※˚ː。*.");
		System.out.println("───────────────────────────────────────────────");
		System.out.println("");
		
		HotelTest ht = new HotelTest();
		ht.openHotel();
		ht.useHotel();
	}
	
	//메뉴를 출력하는 메소드
	private int printMenu() {
		System.out.println("───────────────────────────────────────────────");
		System.out.println("\t  어떤 업무를 하시겠습니까?");
		System.out.println("───────────────────────────────────────────────");
		System.out.println("1. 체크인   2. 체크아웃   3. 객실상태    4. 업무종료");
		System.out.println("───────────────────────────────────────────────");
		
		System.out.println("메뉴 선택 >> ");
		return sc.nextInt();
	}
	
	public void useHotel() {
		while (true) {
			int sel = printMenu();
			switch (sel) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomList();
				break;
			case 4:
				System.out.println("───────────────────────────────────────────────");
				System.out.println(".*。ː˚※。호텔 업무를 종료합니다. 안녕히 가십시오.。※˚ː。*.");
				System.out.println("───────────────────────────────────────────────");
				System.out.println("");
				return;
			default:
				System.out.println("잘못 선택하였습니다. 다시 선택해주세요.");
				break;
			}
		}
	}
	
	//호텔문을 열자마자 201호부터 409호까지의 객실을 만들어주는 메소드♥
	public void openHotel() {
		for (int i = 201; i <= 209; i++) {
			Room cabin = new Room(i, "싱글룸", "-");
			map.put(i, cabin);
		}
		
		for (int i = 301; i <= 309; i++) {
			Room cabin = new Room(i, "더블룸", "-");
			map.put(i, cabin);
		}
		
		for (int i = 401; i <= 409; i++) {
			Room cabin = new Room(i, "스위트룸", "-");
			map.put(i, cabin);
		}
		
//		//이렇게 쓸 수도 있다.
//		for (int i = 2; i <=4; i++) {
//			String type = "";
//			switch(i) {
//			case 2: type = "싱글룸"; break;
//			case 3: type = "싱글룸"; break;
//			case 4: type = "싱글룸"; break;
//			}
//			
//			for (int j =1; j <=9; j++) {
//				int num=i*100+j;
//				map.put(num, new Room(num, type));
//			}
//		}
	}
	
	//실제 그 방이 우리 호텔에 있는지 검사하는 메소드
	private int notInHotel(int room) {
		while(!map.containsKey(room)) {
			System.out.println( room + "호 객실은 존재하지 않는 객실입니다.");
			System.out.println( "원하는 객실을 다시 입력해 주세요.");
			System.out.println( "객실 선택>> ");
			room = sc.nextInt();
		}
		return room;
	}
	
	//이미 예약된 방인지 검사하는 메소드
	private int checkReserv(int room) {
		while(!map.get(room).getName().equals("-")) {
			System.out.println( room + "호 객실은 이미 예약되었습니다.");
			System.out.println( "원하는 객실을 다시 입력해 주세요.");
			System.out.println( "객실 선택>> ");
			room = sc.nextInt();
		}
		return room;
	}
	
	//체크아웃 시 체크인한 사람이 있는지 확인하는 메소드
	private int checkNotReserv(int room) {
		while(map.get(room).getName().equals("-")) {
			System.out.println( room + "호 객실은 체크인한 사람이 없습니다.");
			System.out.println( "원하는 객실을 다시 입력해 주세요.");
			System.out.println( "객실 선택>> ");
			room = sc.nextInt();
		}
		return room;
	}
	
	//체크인 메소드
	private void checkIn() {
		System.out.println("체크인하실 방 번호를 입력해주세요.");
		System.out.println( "객실 선택>> ");
		int room = sc.nextInt();
		room = notInHotel(room);
		room = checkReserv(room);
		
		System.out.println("체크인하실 분의 성함을 입력해주세요.");
		System.out.println("이름 입력>> ");
		
		sc.nextLine(); // 버퍼 비워주기
		String name = sc.nextLine();
		
		map.get(room).setName(name);
		System.out.println(name + "님의 " + room + "호 체크인이 완료되었습니다.");
	}
	
	//체크아웃 메소드
	private void checkOut() {
		System.out.println("체크아웃하실 방 번호를 입력해주세요.");
		System.out.println( "객실 선택>> ");
		int room = sc.nextInt();
		room = notInHotel(room);
		room = checkNotReserv(room);
		
		map.get(room).setName("-");
		System.out.println(room + "호 체크아웃이 완료되었습니다.");
	}
	
	//객실리스트를 보여주는 메소드, 투숙객 이름도 보여줄것이다!!
	private void roomList() {
		System.out.println("───────────────────────────────────────────────");
		System.out.println("\t현재 객실 상태");
		System.out.println("───────────────────────────────────────────────");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("───────────────────────────────────────────────");
		/*이 안에 출력반복문이 들어가겟쥬~*/
		
		//키(룸 번호)들을 뽑아와서 set형으로 만들어줬다.
		// 그리고 이걸 이터레이터로 바꿔서 출력하면 순서가 엉망되지용♥
		// key값을 뽑아와서 리스트로 만들고 정렬 후 출력해보자.
		Set<Integer> keySet = map.keySet();
//		Iterator<Integer> it = keySet.iterator();
		ArrayList<Integer> list = new ArrayList<Integer>(keySet);
		Collections.sort(list);
		for (Integer i : list) {
			Room r = map.get(i);
			//만약 투숙객 이름을 "-"로 넣어놓지 않은 채로 객실생성을 했다면 출력할 때 이런식으로 해줘도 된다. 오랜만에 보쥬 삼항연상자?
			System.out.println(r.getRoom()+"\t"+r.getType()+"\t"+(r.getName()==null ? "-" : r.getName()));
		}
		
		
//		for (Integer i : keySet) {
//			Room r = map.get(i);
//			System.out.println(r.getRoom()+"\t"+r.getType()+"\t"+r.getName());
//		}
		
		
		
		System.out.println("───────────────────────────────────────────────");		
	}

}


class Room {
	
	int room;
	// 각 층 1~9호, 2층 싱글룸 3층 더블룸 4층 스위트룸
	String type;
	String name;
	
	
	public Room() {
		
	}
	
	public Room(int room, String type, String name) {
		super();
		this.room = room;
		this.type = type;
		this.name = name;
	}
	
	public Room(int num, String type2) {
	}

	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
