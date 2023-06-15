package com.example.backend.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String nickname;
    private String avatar;
    private String type;
}
