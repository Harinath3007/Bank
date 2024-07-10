package com.omrbranch.baseclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Sample extends BaseClass {
	String flightID;
	@Test(priority = 1)
	
	public void createFlight() {
		 //1.Header
		addHeader("Content-Type", "application/json");
		
		//2.payload
		addReqBody("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		//3.3req type adn response
		Response response = addReqType("POST","https://omrbranch.com/api/flights");
	        //4.Status Code
		int stateCode = getstateCode(response);
		System.out.println(stateCode);
		Assert.assertEquals(201, stateCode, "Verify statecode");
		
		JsonPath jsonPath = response.jsonPath();
		Object obj = jsonPath.get("data.id");
		Integer in=(Integer)obj;
		String string= in.toString();
	flightID = string;
	Object obj1 = jsonPath.get("data.Destinations");
	System.out.println(obj1);
	
		Assert.assertEquals(89, obj1, "verify destination");
		
		//5.getResponses
		String responseBodyAsPrettyString = getResponseBodyAsPrettyString(response);
		System.out.println(responseBodyAsPrettyString);
		
	}
	    @Test(priority = 2)
		public void updateFlightput() {
			
			addReqBody("{\r\n"
					+ "    \"flightName\": \"AirIndia\",\r\n"
					+ "    \"Country\": \"India\",\r\n"
			
					
					+ "    \"Destinations\": 89,\r\n"
					+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
					+ "}");
			Response response2 = addReqType("PUT", "https://www.omrbranch.com/api/flight/"+flightID);
			int getstateCode = getstateCode(response2);
			System.out.println(getstateCode);
			
			String res = getResponseBodyAsPrettyString(response2);
			System.out.println(res);
		}
	    @Test(priority = 3)
	    public void updateFlightPatch() {
	    	
	    	
	    	addReqBody("{\r\n"
	    			+ "    \"Destinations\": 74\r\n"
	    			+ "}");
	    	Response response3 = addReqType("PATCH", "https://omrbranch.com/api/flight/"+flightID);
	    	int getstateCode = getstateCode(response3);
	    	System.out.println(getstateCode);
	    	
	    	String res = getResponseBodyAsPrettyString(response3);
	    	System.out.println(res);
	    	
	    }
	    @Test(priority = 4)
	   public void getListFlight() {
		
		 Response response4 = addReqType("GET", "https://omrbranch.com/api/flights?page=1");
		 int getstateCode = getstateCode(response4);
		 System.out.println(getstateCode);
//		 Assert.assertEquals(200, getstateCode, "Verify status code");
		 
		 
		 String res = getResponseBodyAsPrettyString(response4);
		 System.out.println(res);
		 
		}
	    @Test(priority = 5)
	   
	  public void deleteFlight() {
		 Response response5 = addReqType("DELETE", "https://omrbranch.com/api/flight/"+flightID);
		 int deleteflight = getstateCode(response5);
		 System.out.println(deleteflight);
        }
	
	    
	    
	
	
	}
	


