package com.example.backend.dto;

import com.example.backend.entity.Food;
import lombok.Data;

import java.util.List;

@Data
public class FoodResponse {
    private String message;
    List<Food> data;
}
