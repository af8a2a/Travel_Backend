package com.example.backend.dto;

import com.example.backend.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class Response {
     private String message;
     private List<User> data;
}
