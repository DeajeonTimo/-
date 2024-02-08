package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

//JSON객체 파싱
public class JSONExample02 {
	public static void main(String[] args) {
		//파일로부터 JSON 읽기
		String jsonstr = "";
		try {
			//한 행을 읽어오는 메소드 .readLine() 을 사용하기 위해 버퍼기반 스트림 사용
			BufferedReader br = new BufferedReader(new FileReader("d:/d_other/JSONexample.json"));
		
			try {
				jsonstr = br.readLine();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			//JSON 파싱
			JSONObject json = new JSONObject(jsonstr);
			
			//속성 정보 읽기
			System.out.println("name: " + json.getString("name"));
			System.out.println("age: " + json.getInt("age"));
			System.out.println("adult: " + json.getBoolean("adult"));
			
			//객체 속성 정보 읽기
			JSONObject tel = json.getJSONObject("tel");
			System.out.println("tel: " + tel.getString("phone"));
			System.out.println("tel: " + tel.getString("home"));
			
			//배열 속성 정보 읽기
			JSONArray addr = json.getJSONArray("addr");
			for (int i = 0; i < addr.length(); i++) {
				System.out.println(addr.get(i));
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}