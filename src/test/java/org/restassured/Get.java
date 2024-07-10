package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {
	public static void main(String[] args) {
		RequestSpecification reqspec;
		
	    reqspec = RestAssured.given();
        reqspec = reqspec.header("Content-type", "application/json");
        Response response = reqspec.get("https://omrbranch.com/api/flights?page=1");
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        
        String asString = response.asString();
        System.out.println(asString);
        String asPrettyString = response.asPrettyString();
        System.out.println(asPrettyString);
	    
	
	
	}
	
	
	

}