package com.ecommerce.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.ecommerce.api.Route.LOGIN_PATH;
import static com.ecommerce.api.SpecBuilder.getRequestSpec;
import static com.ecommerce.api.SpecBuilder.getAccountRequestSpec;
import static com.ecommerce.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class BaseApi {
    public static Response get(String path) throws JsonProcessingException {
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
                .post(LOGIN_PATH)
                .then()
                .spec(getResponseSpec())
                .extract()
                .response();
    }
}