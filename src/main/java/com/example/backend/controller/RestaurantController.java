package com.example.backend.controller;

import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.dto.RestaurantDTO;
import com.example.backend.dto.RestaurantResponse;
import com.example.backend.service.RestaurantService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    @Resource
    private RestaurantService restaurantService;
    @PostMapping("/details")
    @ResponseBody
    public RestaurantResponse Details(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.Details(restaurantDTO);
    }

    @PostMapping("/search")
    @ResponseBody
    public RestaurantResponse Search(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.Search(restaurantDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public RestaurantResponse Delete(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.Delete(restaurantDTO);
    }

    @PostMapping("/add")
    @ResponseBody
    public RestaurantResponse Add(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.Add(restaurantDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public RestaurantResponse All(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.All(restaurantDTO);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public RestaurantResponse All(){
        return restaurantService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public RestaurantResponse Update(@RequestBody RestaurantDTO restaurantDTO){
        return restaurantService.Update(restaurantDTO);
    }

}
