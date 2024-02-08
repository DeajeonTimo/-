package gson;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GSONexample01 {
	public static void main(String[] args) {
		
		//Gson 객체 생성하기
		// new
		Gson gson1 = new Gson();
		
		// GsonBuilder
		Gson gson2 = new GsonBuilder().create();
		
		//setPrettyPrinting() - 들여쓰기 및 자동 줄바꿈
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		
		
		//JSON생성하기
		
		
		
		//JSON생성하기
		JsonObject json = new JsonObject();
		
		//JSON 기본 속성 추가
		json.addProperty("String", "문자열");
		json.addProperty("number", 1);
		json.addProperty("boolean", true);
		
		//JSON 배열속성 만들기
		JsonArray jsonarr = new JsonArray();
		jsonarr.add("하나");
		jsonarr.add("둘");
		jsonarr.add("셋");
		
		//JSON 배열속성 추가하기
		json.add("제이슨배열", jsonarr);
		
		//JSON 객체속성 만들기
		JsonObject json2 = new JsonObject();
		json2.addProperty("String", "문자열");
		json2.addProperty("number", 1);
		json2.addProperty("boolean", true);
		
		//JSON 객체에 객체속성 추가하기
		
		json.add("객체", json2);
		
		
		//JSONObject를 JSON문자열로 변환
		String jsStr = gson1.toJson(json);
		
		
		System.out.println("JSONObject json을 JSON문자열로 변환한 값");
		System.out.println(jsStr);
		
		
		//객체를 JSON문자열로 변환하기
		
		// 1. 객체 생성
		Cookie cookie = new Cookie("초코", 1500);
		
		// 2. 객체>JSon 문자열로 변환
		String cookiestr = gson1.toJson(cookie);
		
		// 3. 문자열을 제이슨 객체로 변환
		JsonObject job2 = gson1.fromJson(cookiestr, JsonObject.class);
		
		System.out.println("객체를 JSON으로 변환한 값.");
		System.out.println(cookiestr);
		
		//파일로 저장
		try {
			FileWriter fw = new FileWriter("d:/d_other/GSONexample.gson");
			fw.write(jsStr);
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


	