package com.ecommerce.tests;

import com.ecommerce.api.ProductApi;
import com.ecommerce.api.StatusCode;
import com.ecommerce.pojo.Product;
import com.ecommerce.utilities.DataLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// http://localhost:8080/v1/product/1

public class ProductTests {
    @Test(description = "A logged in customer should get a product")
    public void getProduct() throws JsonProcessingException {
        Response response = ProductApi.get(DataLoader.getInstance().getProductId());
        assertThat(response.statusCode(), equalTo(StatusCode.CODE_200.getCode()));

        Product productResponse = response.as(Product.class);
        assertThat(productResponse.getName(), equalTo(DataLoader.getInstance().getProductName()));
    }
}
