package com.example.pintech.dto;

import lombok.Getter;

@Getter
public class AuthResponse {

    private final String username;
    private final String password;

    public AuthResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
