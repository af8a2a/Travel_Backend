package com.example.backend.dto;

import com.example.backend.entity.Attractions;
import lombok.Data;

import java.util.List;

@Data
public class AttractionsResponse {
    private String message;
    List<Attractions> data;
}
