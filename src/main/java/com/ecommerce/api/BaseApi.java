package com.ecommerce.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.ecommerce.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class BaseApi {
    public static Response get(String path) {
        return given(getRequestSpec())
                .when()
                .get(path)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response postAccount(String payload) {
        return given(getAccountRequestSpec())
                .body(payload)
                .when()
                .post("/auth/login")
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}