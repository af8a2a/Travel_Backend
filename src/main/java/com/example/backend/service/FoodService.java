package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.entity.Food;

public interface FoodService extends IService<Food> {
    FoodResponse All(Integer page);
    FoodResponse Ma_All();
    FoodResponse Search(String name);
    FoodResponse Delete(Integer id);
    FoodResponse Update(FoodDTO foodDTO);
    FoodResponse Add(FoodDTO foodDTO);
    FoodResponse Details(Integer id);
}
