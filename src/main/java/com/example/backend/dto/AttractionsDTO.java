package com.example.backend.dto;

import lombok.Data;

@Data
public class AttractionsDTO {
    private Integer id;
    private Integer page;
    private String type;
    private String address;
    private String title;
    private String hot;
    private String image;
    private String score;
}
