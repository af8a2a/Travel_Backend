package com.example.backend.dto;

import lombok.Data;

@Data
public class Response<T> {
     private String message;
     private T data;
}
