package com.getprojectapi.restfulservice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HealthCheckTest {
	
	 
    @Test
    public void getPullsAndAssertListSize() {
        String url = "https://api.github.com/repos/octocat/hello-world/pulls";
        ArrayList list = given().when()
                .get(url)
                .then()
                .statusCode(201)
                .extract()
                .as(ArrayList.class);
        assertEquals(list.size(),30);
    }

 

   @Test
    public void getStatusCodeFromRepoAssignees() {
        String url = "https://api.github.com/repos/octocat/hello-world/assignees";
        given().when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
    }


    @Test
    public void deleteRequiresAuth(){
        String url = "https://api.github.com/repos/octocat/hello-world/issues/42/assignees";
        given().when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(404)
                .body("message", containsString("Not"));
    }

    @Test
    public void postMarkdownStatusSuccess(){
        String body = "{\"text\":\"text\"}";
        String url = "https://api.github.com/markdown";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();
        assertEquals(response.statusCode(),200);

    }

}
