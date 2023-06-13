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
public class RestaurantController {
    @Resource
    private RestaurantService restaurantService;
    @PostMapping("/details")
    @ResponseBody
    public RestaurantResponse Details(@RequestParam("id")Integer id){
        return restaurantService.Details(id);
    }

    @PostMapping("/search")
    @ResponseBody
    public RestaurantResponse Search(@RequestParam("name")String name,@RequestParam("page")Integer page){
        return restaurantService.Search(name,page);
    }

    @PostMapping("/delete")
    @ResponseBody
    public RestaurantResponse Delete(@RequestParam("id") Integer id){
        return restaurantService.Delete(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public RestaurantResponse Add(RestaurantDTO restaurantDTO){
        return restaurantService.Add(restaurantDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public RestaurantResponse All(@RequestParam("page")Integer page){
        return restaurantService.All(page);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public RestaurantResponse All(){
        return restaurantService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public RestaurantResponse Update(RestaurantDTO restaurantDTO){
        return restaurantService.Update(restaurantDTO);
    }

}
