package com.automation.testcases;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Assignment_4 {
	
	@Title("Validate that user is successfully able to login")
	@Test
	public void testCase1() {
		RestAssured.baseURI = "http://restapi.demoqa.com";

		String result = SerenityRest.rest().given().auth().basic("ToolsQA", "TestPassword").when().get("/authentication/CheckForAuthentication")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("Fault");
	
		assertThat(result,is("Operation completed successfully"));		
	}
	
	@Title("Validate the response in case of invalid credentials")
	@Test
	public void testCase2() {
		RestAssured.baseURI = "http://restapi.demoqa.com";

		String result = SerenityRest.rest().given().auth().basic("ToolsQAInvalid", "TestPasswordInvalid").when().get("/authentication/CheckForAuthentication")
		.then()
		.log()
		.all()
		.extract()
		.path("fault");
	
		assertThat(result,is("Invalid username or password"));	
	}
}
	