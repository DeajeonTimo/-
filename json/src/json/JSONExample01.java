package json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

//JSON표기 생성
public class JSONExample01 {
	public static void main(String[] args) {
		
		//JSON 객체 생성
		JSONObject json = new JSONObject();
		
		
		//속성 추가
		json.put("name", "홍길동");
		json.put("age", 20);
		json.put("adult", true);
		
		//객체 속성 추가
		JSONObject tel = new JSONObject();
		tel.put("phone", "010-0000-0000");
		tel.put("home", "055-000-0000");
		json.put("tel", tel);
		
		//배열 속성 추가
		JSONArray addr = new JSONArray();
		addr.put("서울");
		addr.put("대전");
		addr.put("대구");
		addr.put("부산");
		json.put("addr", addr);
		
		//JSON문자열로 변환
		String jsonstr = json.toString();
		
		//콘솔에 출력
		System.out.println(jsonstr);
		
		//파일로 저장
		try {
			FileWriter fw = new FileWriter(":/d_other/JSONexample.json");
			fw.write(jsonstr);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}