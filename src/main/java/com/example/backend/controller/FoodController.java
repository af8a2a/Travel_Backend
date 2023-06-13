package com.example.backend.controller;

import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.service.AttractionsService;
import com.example.backend.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @PostMapping("/details")
    @ResponseBody
    public FoodResponse Details(@RequestBody FoodDTO foodDTO){
        return foodService.Details(foodDTO);
    }

    @PostMapping("/search")
    @ResponseBody
    public FoodResponse Search(@RequestBody FoodDTO foodDTO){
        return foodService.Search(foodDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public FoodResponse Delete(@RequestBody FoodDTO foodDTO){
        return foodService.Delete(foodDTO);
    }

    @PostMapping("/add")
    @ResponseBody
    public FoodResponse Add(@RequestBody FoodDTO foodDTO){
        return foodService.Add(foodDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public FoodResponse All(@RequestBody FoodDTO foodDTO){
        return foodService.All(foodDTO);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public FoodResponse All(){
        return foodService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public FoodResponse Update(@RequestBody FoodDTO foodDTO){
        return foodService.Update(foodDTO);
    }

}
