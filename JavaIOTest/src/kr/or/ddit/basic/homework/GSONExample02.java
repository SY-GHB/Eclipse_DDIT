package kr.or.ddit.basic.homework;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;

import com.google.gson.Gson;

public class GSONExample02 {
	//이거왜안돼♡
	public static void main(String[] args) {
		String json = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("e:/d_other/GSONExample.gson"));
			
			try {
				json = br.readLine();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//GSON 파싱
			
			//GSON객체 생성
			Gson gson1 = new Gson();
			
			//Json문자열>쿠키 객체
			Cookie ck1 = gson1.fromJson(json, Cookie.class);
			String name = ck1.getTaste();
			int price = ck1.getPrice();
			System.out.println(name+" "+price);
			//쿠키 객체 toString() 출력
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
