package com.ecommerce.tests;

import com.ecommerce.api.ProductApi;
import com.ecommerce.pojo.Product;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// http://localhost:8080/v1/product/1

public class ProductTests {
    @Test
    public void getProduct() {
        Response response = ProductApi.get("1");
        assertThat(response.statusCode(), equalTo(200));

        Product productResponse = response.as(Product.class);
        assertThat(productResponse.getName(), equalTo("Laptop"));
    }
}
