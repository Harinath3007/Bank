package org.com;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Employee {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader = new FileReader("C:\\Users\\HARINATH\\eclipse-workspace\\APIProject\\src\\test\\resources\\Employee.json");
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject)parse;
		
		Object page = jsonObject.get("page");
		System.out.println(page);
		
		Object perpage = jsonObject.get("per_page");
		System.out.println(perpage);
		
		Object total = jsonObject.get("total");
		System.out.println(total);
		
		Object ttalpage = jsonObject.get("total_pages");
		System.out.println(ttalpage);
		
		Object object = jsonObject.get("data");
		JSONArray  jsonArray = (JSONArray)object;
		for (int i = 0; i < jsonArray.size(); i++) {
			Object object2 = jsonArray.get(i);
			JSONObject jsonObject2 = (JSONObject)object2;
			Object object3 = jsonObject2.get("id");
			System.out.println(object3);
			
			Object object4 = jsonObject2.get("flightName");
			System.out.println(object4);
			
			Object object5 = jsonObject2.get("Country");
			System.out.println(object5);
			
			Object object6 = jsonObject2.get("Destinations");
			System.out.println(object6);
			
			Object object7 = jsonObject2.get("URL");
			System.out.println(object7);
			
		}
			
		}
	}
	


