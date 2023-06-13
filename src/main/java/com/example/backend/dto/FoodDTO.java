package com.example.backend.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private Integer id;
    private String name;
    private String image;
    private String link;
    private String number;
    private String area;
    private String address;
    private Integer page;
}
