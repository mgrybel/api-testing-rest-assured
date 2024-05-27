package com.ecommerce.api;

import com.ecommerce.utilities.ConfigLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.ecommerce.api.Route.BASE_PATH;
import static com.ecommerce.api.TokenManager.getToken;

public class SpecBuilder {
    public static RequestSpecification getRequestSpec() throws JsonProcessingException {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getInstance().getBaseUrl())
                .setBasePath(BASE_PATH)
                .addHeader("Authorization", "Bearer " + getToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.getInstance().getBaseUrl())
                .setBasePath(BASE_PATH)
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
