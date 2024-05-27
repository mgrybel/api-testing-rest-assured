package com.ecommerce.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

import static com.ecommerce.api.Route.PRODUCT_PATH;

public class ProductApi {
    public static Response get(String productId) throws JsonProcessingException {
        return BaseApi.get(PRODUCT_PATH + productId);
    }
}
