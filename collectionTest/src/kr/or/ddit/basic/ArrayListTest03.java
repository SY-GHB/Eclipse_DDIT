package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

// 문제2) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중에서 길이가 가장 긴 별명을 출력하시오.
//단, 입력하는 각 별명의 길이는 모두 다르게 입력한다.
public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("서로 다른 길이의 별명을 입력해주세요.");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < 6; i++) {
			System.out.println(i + "번째 별명을 입력해주세요.");
			String nick = sc.nextLine();
			list.add(nick);
		}
		
		//제일 긴 별명이 저장될 변수. ""이 아니라 .get(0)라고 해두면 첫번째 데이터를 바로 넣는거니 반복을 한번 적게 할 수도 잇겟다
		String temp = "";
		int length = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if(length<list.get(i).length()) {
				length = list.get(i).length();
				temp = list.get(i);
			}
		}
		
		
		System.out.println("가장 긴 닉네임은 "+temp+"이고, 그 길이는 "+length+"입니다.");
	}
}