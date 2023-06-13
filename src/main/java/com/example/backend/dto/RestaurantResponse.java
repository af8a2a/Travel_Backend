package com.example.backend.dto;

import com.example.backend.entity.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantResponse {
    private String message;
    private List<Restaurant> data;
}
