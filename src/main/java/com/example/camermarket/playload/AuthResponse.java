package com.example.camermarket.playload;

import lombok.Data;

@Data
public class AuthResponse {
    private String email;
    private String accessToken;
}
