package com.ecommerce.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.ecommerce.api.TokenManager.getToken;

public class SpecBuilder {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080")
                .setBasePath("/v1")
                .addHeader("Authorization", "Bearer " + getToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080")
                .setBasePath("/v1")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                //.expectStatusCode(200) - some endpoints will return 201 instead of 200
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }
}
