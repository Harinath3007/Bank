package com.omrbranch.baseclass;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqspec;
	Response response;

	
	public void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);
	}
	public void addHeader(String key, String value) {
		reqspec = RestAssured.given().header(key, value);
	}
	public void addBasicAuth(String UserName,String PassWord) {
		reqspec.auth().preemptive().basic(UserName, PassWord);
	}

	public void addReqBody(String payload) {
		reqspec = reqspec.body(payload);

	}
	
	public void addReqBody(Object payload) {
		reqspec = reqspec.body(payload);

	}
	
	

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqspec.get(endpoint);
			break;
		case "PUT":
			response = reqspec.put(endpoint);
			break;
		case "POST":
			response = reqspec.post(endpoint);
			break;
		case "PATCH":
			response = reqspec.patch(endpoint);
			break;
		case "DELETE":
			response = reqspec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;

	}

	public int getstateCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResponseBodyAsPrettyString(Response response ) {
	      String asPrettyString = response.asPrettyString();
	      return asPrettyString;

	}
	public void addMultiPartFormData(String key,File file) {
		reqspec = reqspec.multiPart(key, file);

	}

}
