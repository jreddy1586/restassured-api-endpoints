package com.getprojectapi.restfulservice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HealthCheckTest {
	
	@Test
	public void healthCheckTest() {
		given().
		when().
			get("").
		then().
			assertThat().
			statusCode(200);
	}

}
