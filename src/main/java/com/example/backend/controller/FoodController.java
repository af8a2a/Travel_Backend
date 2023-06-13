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
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @PostMapping("/details")
    @ResponseBody
    public FoodResponse Details(@RequestParam("id")Integer id){
        return foodService.Details(id);
    }

    @PostMapping("/search")
    @ResponseBody
    public FoodResponse Search(@RequestParam("name")String name){
        return foodService.Search(name);
    }

    @PostMapping("/delete")
    @ResponseBody
    public FoodResponse Delete(@RequestParam("id") Integer id){
        return foodService.Delete(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public FoodResponse Add(FoodDTO foodDTO){
        return foodService.Add(foodDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public FoodResponse All(@RequestParam("page")Integer page){
        return foodService.All(page);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public FoodResponse All(){
        return foodService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public FoodResponse Update(FoodDTO foodDTO){
        return foodService.Update(foodDTO);
    }

}
