package com.ecommerce.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

// http://localhost:8080/v1/products
// http://localhost:8080/v1/product/1

public class ProductTests {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lckB0ZXN0LmNvbSIsImlhdCI6MTcxNjc1MjE0MiwiZXhwIjoxNzE2ODM4NTQyfQ.dj6WvaM6qH_WfM01uelcgEx7sv22rKN5_aZoPKVdDKg";

    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080")
                .setBasePath("/v1")
                .addHeader("Authorization", "Bearer " + accessToken)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                //.expectStatusCode(200) - some endpoints will return 201 instead of 200
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void shouldGetProductList() {
        given(requestSpecification)
                .when()
                    .get("/products")
                .then()
                    .spec(responseSpecification)
                    .assertThat()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("products.json"));
    }

    @Test
    public void shouldGetSingleProduct() {
        given(requestSpecification)
                .when()
                    .get("/product/1")
                .then()
                    .spec(responseSpecification)
                    .assertThat()
                    .statusCode(200)
                    .body(matchesJsonSchemaInClasspath("product.json"));
    }

    @Test
    public void shouldNotGetProductListWithExpiredToken() {
        given().baseUri("http://localhost:8080")
                .basePath("/v1")
                .header("Authorization", "Bearer " + "12345")
                .contentType(ContentType.JSON)
                .log().all()
       .when()
                .get("/products")
       .then()
                .assertThat()
                .statusCode(403);
    }
}
