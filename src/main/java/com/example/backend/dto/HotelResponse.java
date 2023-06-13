package com.example.backend.dto;

import com.example.backend.entity.Food;
import com.example.backend.entity.Hotel;
import lombok.Data;

import java.util.List;
@Data
public class HotelResponse {
    private String message;
    List<Hotel> hotelList;
}
