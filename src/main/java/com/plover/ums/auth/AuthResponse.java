package com.plover.ums.auth;

public class AuthResponse {

    private String token;
    private String type;

    public AuthResponse(String token, String type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }
}

