package com.example.backend.dto;

import lombok.Data;

@Data
public class HotelDTO {
    private Integer id;
    private String image;
    private String name;
    private String address;
    private String score;
    private String price;
    private Integer page;
}
