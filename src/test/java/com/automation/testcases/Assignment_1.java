package com.automation.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.automation.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
public class Assignment_1 extends TestBase {
	
	@Title("verify the total number of records as 36 when country code is IND")
	@Test
	public void testCase1() {	
		String result = SerenityRest.rest().given()
		.when()
		.get("/state/get/IND/all")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("RestResponse.messages.get(0)");
		
		System.out.println("Here is the message "+ result );
		assertThat(result, is("Total [36] records found."));
	}
	
	@Title("verify the total number of records to be 0 when country code is ind")
	@Test
	public void testCase2() {
		String result = SerenityRest.rest().given()
		.when()
		.get("/state/get/ind/all")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("RestResponse.messages.get(0)");
		
		System.out.println("Here is the message "+ result );
		assertThat(result, is("Total [0] records found."));
	}
	
	@Title("verify the total number of records to be 0 when country code is Aus")
	@Test
	public void testCase3() {
		String result = SerenityRest.rest().given()
		.when()
		.get("/state/get/Aus/all")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("RestResponse.messages.get(0)");
		
		System.out.println("Here is the message "+ result );
		assertThat(result, is("Total [0] records found."));
	}
}
