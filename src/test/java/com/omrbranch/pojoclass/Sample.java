package com.omrbranch.pojoclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Sample extends BaseClass {
	String logtoken;
	String address_id;
	String id1;

	
	@Test(priority = 9)
	public void profilePic() {
		List<Header> Header1 = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		Header1.add(h1);
		Header1.add(h2);
		Header1.add(h3);
		Headers header = new Headers(Header1);
		addHeaders(header);
		
		addMultiPartFormData("profile_picture", new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot (4).png"));
		Response response = addReqType("POST", "https://omrbranch.com/api/changeProfilePic");
		
		int statusCode = getstateCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");
		
		Profilepic_Output_Pojo as = response.as(Profilepic_Output_Pojo.class);
		String message = as.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Profile updated Successfully", "get profile success message");
		
		

	}
	@Test(priority = 8)
	public void cityList() {

		List<Header> lstheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		lstheader.add(h1);
		lstheader.add(h2);

		Headers headers = new Headers(lstheader);
		addHeaders(headers);

		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo("35");
		addReqBody(cityList_Input_Pojo);

		Response response = addReqType("POST", "https://omrbranch.com/api/cityList");

		int statusCode = getstateCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		CityList cityList = cityList_Output_Pojo.getData().get(632);
		String name = cityList.getName();
		Assert.assertEquals(name, "Salem", "Verify city Salem");

	}

	@Test
	public void stateList() {

		List<Header> lstheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");

		lstheader.add(h1);

		Headers headers = new Headers(lstheader);
		addHeaders(headers);

		Response reqType = addReqType("GET", "https://omrbranch.com/api/stateList");

		int statusCode = getstateCode(reqType);

		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify status code");

		StateList_Output_Pojo stateList_output_Pojo = reqType.as(StateList_Output_Pojo.class);
		Datum datumStateList = stateList_output_Pojo.getData().get(34);
		String name = datumStateList.getName();
		Assert.assertEquals(name, "Tamil Nadu", "Verify state TamilNadu");

	}

	@Test(priority = 6)
	public void searchProduct() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		header.add(h2);
		header.add(h1);

		Headers headers = new Headers(header);
		addHeaders(headers);

		Search_Product_Input product_Input = new Search_Product_Input("nuts");
		addReqBody(product_Input);
		Response reqType = addReqType("POST", "https://omrbranch.com/api/searchProduct");
		int getstateCode = getstateCode(reqType);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify state code");

		Search_Product_Output as = reqType.as(Search_Product_Output.class);
		Search_Productin search_Productin = as.getData().get(0);

		String type = search_Productin.getType();
		Assert.assertEquals(type, "product", "verify the search product");

	}

	@Test(priority = 5)
	public void deleteaddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer ");
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Delete_Input_Pojo delete = new Delete_Input_Pojo(id1);
		addReqBody(delete);
		Response reqType = addReqType("DELETE", "https://omrbranch.com/api/deleteAddress");
		int getstateCode = getstateCode(reqType);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify state code");
		Delete_Output_Pojo as = reqType.as(Delete_Output_Pojo.class);
		String message = as.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify delete message");
	}

	@Test(priority = 4)
	public void getUseraddress() {
		List<Header> theader = new ArrayList<>();
		Header h1 = new Header("Authorization", "Bearer " + logtoken);
		Header h2 = new Header("accept", "application/json");

		theader.add(h1);
		theader.add(h2);
		Response reqType = addReqType("GET", "https://omrbranch.com/api/getUserAddress");
		int getstateCode = getstateCode(reqType);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify state code");

		GetAdress_Output_pojo as = reqType.as(GetAdress_Output_pojo.class);
		Getclass getclass = as.getData().get(1);
		int id = getclass.getId();
		id1 = Integer.toString(id);

	}

	@Test(priority = 3)
	public void UpdateAddress() {
		List<Header> lstheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);

		Headers headers = new Headers(lstheader);
		addHeaders(headers);

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id,
				"Harinath", "k", "57845123455", "BSRMall", 34, 44, 45, "621002", "Trichy", "Thuraiyur");
		addReqBody(updateUserAddress_Input_Pojo);
		Response reqType = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");
		int getstateCode = getstateCode(reqType);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify status code");

		UpdateUserAddress_Output_Pojo as = reqType.as(UpdateUserAddress_Output_Pojo.class);

		String message = as.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify address added");

	}

	@Test(priority = 2)
	public void addAddress() {

		List<Header> lstheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		lstheader.add(h1);
		lstheader.add(h2);
		lstheader.add(h3);

		Headers headers = new Headers(lstheader);

		addHeaders(headers);
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo("Harinath", "Kumar", "7867072266",
				"reliencemall", 22, 87, 876, "600002", "Chennai", "BesantNagar");
		addReqBody(address_Input_Pojo);

		Response reqType = addReqType("POST", "https://omrbranch.com/api/addUserAddress");
		int getstateCode = getstateCode(reqType);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify status code");

		AddUserAddress_Output_Pojo as = reqType.as(AddUserAddress_Output_Pojo.class);
		int address_id2 = as.getAddress_id();
		address_id = Integer.toString(address_id2);

		String message = as.getMessage();

		Assert.assertEquals(message, "Address added successfully", "Verify address added");

	}

	@Test(priority = 1)
	public void login() {

		addHeader("accept", "application/json");
		addBasicAuth("harin6083@gmail.com", "Harin6083@");
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int getstateCode = getstateCode(response);
		System.out.println(getstateCode);
		Assert.assertEquals(getstateCode, 200, "Verify ststus code");

		Login_Output_Pojo as = response.as(Login_Output_Pojo.class);
		String first_name = as.getData().getFirst_name();
		Assert.assertEquals(first_name, "Harinath", "Verify first name");

		logtoken = as.getData().getLogtoken();
	}

}
