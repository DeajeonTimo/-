package gson;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class GSONExample02 {
	public static void main(String[] args) {
		String json = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:/d_other/GSONExample.gson"));
			
			try {
				json = br.readLine();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
			//GSON 파싱
			JsonObject object = (JsonObject)JsonParser.parseString(json);
			
			String s = object.get("String").getAsString();
			int i = object.get("number").getAsInt();
			boolean b = object.get("boolean").getAsBoolean();
			
			JsonArray jsonArray = object.get("제이슨배열").getAsJsonArray();
	
			String firstarr = jsonArray.get(0).getAsString();
	
			JsonObject jsonObject = object.get("객체").getAsJsonObject();
			
			String firstValue = jsonObject.get("String").getAsString();
						
			System.out.println(json);
			System.out.println(s);
			System.out.println(i);
			System.out.println(b);
			System.out.println(firstarr);
			System.out.println(firstValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
