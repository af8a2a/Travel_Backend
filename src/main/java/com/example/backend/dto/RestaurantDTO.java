package com.example.backend.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Integer id;
    private String name;
    private String image;
    private String address;
    private String price;
    private String score;
    private Integer page;
}
