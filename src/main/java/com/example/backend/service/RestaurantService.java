package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.*;
import com.example.backend.entity.Restaurant;

public interface RestaurantService extends IService<Restaurant> {
    RestaurantResponse All(RestaurantDTO restaurantDTO);
    RestaurantResponse Ma_All();
    RestaurantResponse Search(RestaurantDTO restaurantDTO);
    RestaurantResponse Delete(RestaurantDTO restaurantDTO);
    RestaurantResponse Update(RestaurantDTO restaurantDTO);
    RestaurantResponse Add(RestaurantDTO restaurantDTO);
    RestaurantResponse Details(RestaurantDTO restaurantDTO);

}
