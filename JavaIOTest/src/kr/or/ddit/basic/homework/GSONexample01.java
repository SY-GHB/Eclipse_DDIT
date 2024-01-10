package kr.or.ddit.basic.homework;

import java.io.FileWriter;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GSONexample01 {
	public static void main(String[] args) {
		
		//Gson 객체 생성하기
		// new
		Gson gson1 = new Gson();
		
		
		// GsonBuilder
		Gson gson2 = new GsonBuilder().create();
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		
		
		//JSON생성하기
		//1. JSON Key, value 추가
		JsonObject job = new JsonObject();
		job.addProperty("name", "anna");
		job.addProperty("id", 1);
		job.addProperty("adult", true);

		//2. JSONObject를 JSON문자열로 변환
		String jsStr = gson1.toJson(job);
		
		
		//객체를 value값으로 JSON문자열 변환하기
		JsonObject job2 = new JsonObject();
		
		//1. 객체 생성
		Cookie ck1 = new Cookie("초콜릿", 1500);
		Cookie ck2 = new Cookie("바닐라", 1400);
		
		// 2. 객체>JSon 문자열로 변환
		String cook1 = gson1.toJson(ck1);
		String cook2 = gson1.toJson(ck2);
		
		// 3. 2번의 문자열을 value값으로 Json 객체에 담기
		
		job2.addProperty("쿠키1",cook1);
		job2.addProperty("쿠키2",cook2);
		
		// 4. json객체를 문자열로 변환
		String jsStr2 = gson1.toJson(job2);
		
		
		//생성된 json문자열 출력
		System.out.println(cook1);
		System.out.println(cook2);
		System.out.println(jsStr);
		System.out.println(jsStr2);
		
		//파일로 저장
		try {
			FileWriter fw = new FileWriter("e:/d_other/GSONexample.gson");
//			fw.write(jsStr);
			fw.write(jsStr2);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}

class Cookie{
	private String taste;
	private int price;
	
	public Cookie(String taste, int price) {
		this.taste = taste;
		this.price = price;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cookie [taste=" + taste + ", price=" + price + "]";
	}
	
	
	
}
