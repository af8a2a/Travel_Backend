package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.RestaurantDTO;
import com.example.backend.dto.RestaurantResponse;
import com.example.backend.entity.Restaurant;

public interface RestaurantService extends IService<Restaurant> {
    RestaurantResponse All(Integer page);
    RestaurantResponse Ma_All();
    RestaurantResponse Search(String name,Integer page);
    RestaurantResponse Delete(Integer id);
    RestaurantResponse Update(RestaurantDTO restaurantDTO);
    RestaurantResponse Add(RestaurantDTO restaurantDTO);
    RestaurantResponse Details(Integer id);

}
