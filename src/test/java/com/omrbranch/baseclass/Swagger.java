package com.omrbranch.baseclass;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Swagger extends BaseClass{
  
	@Test
	public void login() {
		addHeader("accept", "application/json");
		
		addBasicAuth("harin6083@gmail.com", "Harin6083@");
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int getstateCode = getstateCode(response);
		System.out.println(getstateCode);
		
		String resBodyAsString = getResponseBodyAsPrettyString(response);
	    System.out.println(resBodyAsString);

	}
}
