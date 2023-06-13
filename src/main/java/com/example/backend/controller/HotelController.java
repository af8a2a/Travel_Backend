package com.example.backend.controller;

import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.service.FoodService;
import com.example.backend.service.HotelService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Resource
    private HotelService hotelService;

    @PostMapping("/details")
    @ResponseBody
    public HotelResponse Details(@RequestParam("id")Integer id){
        return hotelService.Details(id);
    }

    @PostMapping("/search")
    @ResponseBody
    public HotelResponse Search(@RequestParam("name")String name){
        return hotelService.Search(name);
    }

    @PostMapping("/delete")
    @ResponseBody
    public HotelResponse Delete(@RequestParam("id") Integer id){
        return hotelService.Delete(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public HotelResponse Add(HotelDTO hotelDTO){
        return hotelService.Add(hotelDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public HotelResponse All(@RequestParam("page")Integer page){
        return hotelService.All(page);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public HotelResponse All(){
        return hotelService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public HotelResponse Update(HotelDTO hotelDTO){
        return hotelService.Update(hotelDTO);
    }

}
