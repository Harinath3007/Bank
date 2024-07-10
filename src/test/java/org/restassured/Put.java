package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put {
	public static void main(String[] args) {
        RequestSpecification reqspec;
		
	    reqspec = RestAssured.given();
        reqspec = reqspec.header("Content-type", "application/json");
        reqspec = reqspec.body("{\r\n"
        		+ "    \"flightName\": \"AirIndia\",\r\n"
        		+ "    \"Country\": \"India\",\r\n"
        		+ "    \"Destinations\": 50,\r\n"
        		+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
        		+ "}");
        Response put = reqspec.put("https://omrbranch.com/api/flight/29231");
        String asPrettyString = put.asPrettyString();
        System.out.println(asPrettyString);
        
		
	}

}
