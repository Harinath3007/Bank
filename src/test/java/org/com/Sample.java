package org.com;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader = new FileReader("C:\\Users\\HARINATH\\eclipse-workspace\\APIProject\\src\\test\\resources\\Employee.json");
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject)parse;
		Object object = jsonObject.get("data");
	    JSONObject jsonObject2 = (JSONObject)object;
	    System.out.println(jsonObject2);
	    
	    Object object2 = jsonObject2.get("id");
	    System.out.println(object2);
	    
	    Object object3 = jsonObject2.get("flightName");
	    System.out.println(object3);
	    
	    Object object4 = jsonObject2.get("Country");
	    System.out.println(object4);
	    
	    Object object5 = jsonObject2.get("Destinations");
	    System.out.println(object5);
	    
	    Object object6 = jsonObject2.get("URL");
	    System.out.println(object6);
	    
	    Object object7 = jsonObject2.get("Created_Date");
	    System.out.println(object7);
	    
	    Object object8 = jsonObject2.get("Updated_Date");
	    System.out.println(object8);
	    
	    
	    Object object1 = jsonObject.get("support");
	    JSONObject jsonObject3 = (JSONObject)object1;
	    System.out.println(jsonObject3);
	    Object object9 = jsonObject3.get("url");
	    System.out.println(object9);
	    
	    Object object10 = jsonObject3.get("text");
	    System.out.println(object10);
	}

}
