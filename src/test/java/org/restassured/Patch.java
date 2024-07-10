package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Patch {
	public static void main(String[] args) {
        RequestSpecification reqspec;
		
	    reqspec = RestAssured.given();
        reqspec = reqspec.header("Content-type", "application/json");
        reqspec = reqspec.body("{\r\n"
        		+ "    \"Destinations\": 64\r\n"
        		+ "}");
        Response put = reqspec.patch("https://omrbranch.com/api/flight/29231");
        String asPrettyString = put.asPrettyString();
        System.out.println(asPrettyString);
        
		
	}


}
