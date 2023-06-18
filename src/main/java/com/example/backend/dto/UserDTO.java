package com.example.backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String nickname;
    private String password;
    private String dialogImageUrl;
}
