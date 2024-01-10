package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

import print.Print;

public class ArrayListTest04 extends Print{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문제2) 5명의 별명dmf 입력받아 ArrayList에 저장하고 이들 중에서 길이가 가장 긴 별명을 출력하시오.
		// 단, 입력하는 각 별명의 길이는 모두 다르게 입력한다.

		// 문제3) 문제2에서 입력하는 별명의 길이가 같은 것이 있을 수 있을 때 결과를 출력하시오.

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < 6; i++) {
			System.out.println(i + "번째 별명을 입력해주세요.");
			String name = sc.nextLine();
			list.add(name);
		}

		int length = 0;

		String temp = "";

		for (int i = 0; i < list.size(); i++) {
			if (length < list.get(i).length()) {
				length = list.get(i).length();
				temp = list.get(i);
			}
		}

//		System.out.println("가장 긴 닉네임은 " + temp + "이고, 그 길이는 " + length + "입니다.");
		
		System.out.print("가장 긴 닉네임은 ");
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).length() == length) {
				System.out.print(list.get(i)+", ");
			}
		}
		System.out.print("그 길이는 "+length+"입니다.");
	}
}
