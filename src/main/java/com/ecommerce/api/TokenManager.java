package com.ecommerce.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.ecommerce.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class TokenManager {
    private static String accessToken;
    public static String getToken() {
        String payload = "{\n" +
                "    \"email\": \"customer@test.com\",\n" +
                "    \"password\": \"test123\"\n" +
                "}";

        Response response = BaseApi.postAccount(payload);

        if (response.statusCode() != 200) {
            throw new RuntimeException("Login failed");
        }
        return response.path("token");
    }
}
