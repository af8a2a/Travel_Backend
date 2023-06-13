package com.example.backend.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Integer id;
    private String name;
    private String link;
    private String image;
    private Double address;
    private String price;
    private Double score;
    private Integer comment;
}
