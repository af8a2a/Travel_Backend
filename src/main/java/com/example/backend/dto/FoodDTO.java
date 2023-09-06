package com.example.backend.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private Integer id;
    private String name;
    private String image;
    private Integer recommend;
    private String information;
    private Integer page;
}
