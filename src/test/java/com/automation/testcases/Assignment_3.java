package com.automation.testcases;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testng.AssertJUnit;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class Assignment_3 {
	
	@SuppressWarnings("unchecked")
	@Title("Validate that post request is successful and status code is 201 & success code is operation_success")
	@Test
	public void testCase1() {	
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification request = SerenityRest.given();
		request.header("Content-Type", "application/json");
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("FirstName", "Debasis1");
		requestParam.put("LastName", "Rath1");
		requestParam.put("UserName", "Debasis1");
		requestParam.put("Password", "testing1");
		requestParam.put("Email", "debasisr1@gmail.com");
	
		request.body(requestParam.toJSONString());
		
		Response response = request.when().post("/customer/register");
		response.then().log().all();
		
		int statusCode = response.getStatusCode();
		System.out.println("Here is the status code " + statusCode);

		AssertJUnit.assertEquals(201, statusCode);
		AssertJUnit.assertEquals("Success code is correct", response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
	}	
	
	@SuppressWarnings("unchecked")
	@Title("Validate that post request is successful and status code is 201 & success code is operation_success")
	@Test
	public void testCase2() {	
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification request = SerenityRest.given();
		request.header("Content-Type", "application/json");
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("FirstName", "Francis1");
		requestParam.put("LastName", "Martin1");
		requestParam.put("UserName", "fmartin1");
		requestParam.put("Password", "francTest1");
		requestParam.put("Email", "fr1@gmail.com");
	
		request.body(requestParam.toJSONString());
		
		Response response = request.when().post("/customer/register");
		response.then().log().all();
		
		int statusCode = response.getStatusCode();
		System.out.println("Here is the status code " + statusCode);

		AssertJUnit.assertEquals(200, statusCode);
		AssertJUnit.assertEquals("Success code is correct", response.jsonPath().get("fault"), "FAULT_USER_ALREADY_EXISTS");
	}
}

