package com.automation.testcases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.automation.testbase.TestBase;

import static org.hamcrest.Matchers.is;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class Assignment_2 extends TestBase {
	
	@Title("Validate that there are 5 records found")
	@Test
	public void testCase1() {	
	String result =	SerenityRest.rest().given()
		.queryParam("text", "pradesh")
		.when()
		.get("/state/search/IND")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("RestResponse.messages.get(0)");
		
		System.out.println("Here is the message "+ result );
		assertThat(result, is("Total [5] records found."));
	}	
	
	@Title("Validate that largest city is Hyderabad Amaravati")
	@Test
	public void testCase2() {	
	String result =	SerenityRest.rest().given()
		.queryParam("text", "Andhra pradesh")
		.when()
		.get("/state/search/IND")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path("RestResponse.result.largest_city.get(0)");
		
		System.out.println("Here is the message "+ result );
		assertThat(result, is("Hyderabad Amaravati"));
	}	
	
	@Title("Print the details of Madhya Pradesh on command line")
	@Test
	public void testCase3() {	
		SerenityRest.rest().given()
		.queryParam("text", "Madhya Pradesh")
		.when()
		.get("/state/search/IND")
		.then()
		.log()
		.all()
		.statusCode(200);
		//.extract()
		//.path("RestResponse.messages.get(0)");
		
		//System.out.println("Here is the message "+ result );
		//assertThat(result, is("Total [36] records found."));
	}	
}