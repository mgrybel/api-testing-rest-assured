package com.ecommerce.api;

import com.ecommerce.pojo.User;
import com.ecommerce.utilities.ConfigLoader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class TokenManager {
    private static String accessToken;
    public static String getToken() throws JsonProcessingException {
        User user = new User();
        user.setEmail(ConfigLoader.getInstance().getEmail());
        user.setPassword(ConfigLoader.getInstance().getPassword());

        ObjectMapper objectMapper = new ObjectMapper();
        // Serialize this User object into JSON
        String loginBody = objectMapper.writeValueAsString(user);

        Response response = BaseApi.postAccount(loginBody);

        if (response.statusCode() != StatusCode.CODE_200.getCode()) {
            throw new RuntimeException("Login failed");
        }
        return response.path("token");
    }
}
