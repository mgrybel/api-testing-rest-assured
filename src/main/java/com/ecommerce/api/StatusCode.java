package com.ecommerce.api;

public enum StatusCode {
    CODE_200(200, "OK"),
    CODE_201(201, "Created"),
    CODE_400(400, "Bad Request"),
    CODE_401(401, "Unauthorized"),
    CODE_403(403, "Forbidden"),
    CODE_404(404, "Not Found"),
    CODE_405(405, "Method Not Allowed"),
    CODE_500(500, "Internal Server Error");

    private final int code;
    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
