package com.rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class LoginTest {
    @Test
    public void performLogin() {
        String payload = "{\n" +
                "    \"email\": \"customer@test.com\",\n" +
                "    \"password\": \"test123\"\n" +
                "}";
        given()
                .log().all()
                .baseUri("http://localhost:8080/v1")
                .contentType(ContentType.JSON)
                .body(payload)
        .when()
                .post("/auth/login")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("$", hasKey("token"))
                .body("$", hasKey("role"));
    }

    @Test
    public void performLogin2() {
        RestAssured.baseURI = "http://localhost:8080/v1";

        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        String payload = "{\n" +
                "    \"email\": \"customer@test.com\",\n" +
                "    \"password\": \"test123\"\n" +
                "}";

        Response responseFromLogin = request.body(payload).post("/auth/login");

        String jsonString = responseFromLogin.getBody().asString();

        String accessToken = JsonPath.from(jsonString).get("token");

        request.header("Authorization", "Bearer " + accessToken).header("Content-Type", "application/json");

        Response getProductsResponse = request.get("/products");

        Assert.assertEquals(200, getProductsResponse.getStatusCode());

        System.out.println(getProductsResponse.getBody().asString());
    }
}
