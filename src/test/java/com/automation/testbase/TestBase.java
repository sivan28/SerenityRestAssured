package com.automation.testbase;

import org.junit.BeforeClass;
import io.restassured.RestAssured;

public class TestBase {
	
	@BeforeClass
	public static void initialize() {
		RestAssured.baseURI = "http://services.groupkt.com";	
	}

}
