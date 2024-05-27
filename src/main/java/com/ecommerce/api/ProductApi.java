package com.ecommerce.api;

import io.restassured.response.Response;

public class ProductApi {
    public static Response get(String productId) {
        return BaseApi.get("/product/" + productId);
    }
}
