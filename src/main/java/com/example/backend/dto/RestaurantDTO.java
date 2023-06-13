package com.example.backend.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Integer id;
    private String name;
    private String link;
    private String image;
    private String address;
    private String price;
    private String score;
    private String comment;
    private Integer page;
}
