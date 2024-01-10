package homework;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SellLotto {
	static Scanner sc = new Scanner(System.in);
	public static void printLotto() {
		System.out.println("==========================\r\n" + 
				"    Lotto 프로그램\r\n" + 
				"--------------------------\r\n" + 
				"    1. Lotto 구입\r\n" + 
				"    2. 프로그램 종료\r\n" + 
				"==========================");
	}

	public static void main(String[] args) {
		startLotto();
		
	}
	
	public static void startLotto() {
		while(true) {
			printLotto();
			
			System.out.println("선택: ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1: 
				System.out.println("구매금액을 입력해주세요.");
				int price = sc.nextInt();
				int checkPrice = checkPrice(price);
				int left = checkPrice%1000;
				sellLotto(checkPrice);
				
				System.out.println("받은 금액은 " + checkPrice +"원, 거스름돈은 "+ left+"원 입니다." );
				continue;
			case 2:
				System.out.println("로또프로그램을 종료합니다. 감사합니다.");
				return;
			default: 
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
	}
	
	
	public static void sellLotto(int price) {
		System.out.println("로또 구입 시작\r\n1000원에 로또번호 하나입니다.");
		System.out.println();
		int amt = (price/1000);
		
		for (int i = 1; i < amt+1; i++) {
			//반복 돌 때마다 한 줄 발급, 가격만큼 반복.
			HashSet<Integer> lotto = new HashSet<Integer>();
			while(lotto.size()<6) {
				//로또숫자는 1부터 45까지라고 치고
				//6개를 뽑은 걸 로또 한 줄이라고 하자.
				lotto.add((int)(Math.random()*45 +1));
			}
			
			
			ArrayList<Integer> lottoList = new ArrayList<Integer>(lotto);
			Collections.sort(lottoList);
			System.out.println(i+"번 로또번호 "+lottoList);
		}
		System.out.println();
	}
	
	public static int checkPrice(int price) {
		while(true) {
			if(price>100000) {
				System.out.println("구매금액이 너무 많습니다."
						+ "\r\n한번에 100장(10만원)이 최대입니다.\r\n다시 구매금액을 입력해주세요.");
				price = sc.nextInt();
				if(price>10000||price<1000) continue;
				else return price;
				
			}else if(price<1000) {
				
				System.out.println("구매금액이 너무 적습니다."
						+ "\r\n한번에 1장(1000원)이 최소입니다.\r\n다시 구매금액을 입력해주세요.");
				price = sc.nextInt();
				if(price>10000||price<1000) continue;
				else return price;
			}else {
				return price;
			}
		}
	}
}
