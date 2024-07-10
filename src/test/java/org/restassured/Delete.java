package org.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	public static void main(String[] args) {
        RequestSpecification reqspec;
		
	    reqspec = RestAssured.given();
        reqspec = reqspec.header("Content-type", "application/json");
       
        Response delete = reqspec.delete("https://omrbranch.com/api/flight/29198");
        int statusCode = delete.getStatusCode();
        System.out.println(statusCode);
    
}
}
