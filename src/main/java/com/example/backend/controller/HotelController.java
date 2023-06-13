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
@CrossOrigin
@RequestMapping("/hotel")
public class HotelController {
    @Resource
    private HotelService hotelService;

    @PostMapping("/details")
    @ResponseBody
    public HotelResponse Details(@RequestBody HotelDTO hotelDTO){
        return hotelService.Details(hotelDTO);
    }

    @PostMapping("/search")
    @ResponseBody
    public HotelResponse Search(@RequestBody HotelDTO hotelDTO){
        return hotelService.Search(hotelDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public HotelResponse Delete(@RequestBody HotelDTO hotelDTO){
        return hotelService.Delete(hotelDTO);
    }

    @PostMapping("/add")
    @ResponseBody
    public HotelResponse Add(@RequestBody HotelDTO hotelDTO){
        return hotelService.Add(hotelDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public HotelResponse All(@RequestBody HotelDTO hotelDTO){
        return hotelService.All(hotelDTO);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public HotelResponse All(){
        return hotelService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public HotelResponse Update(@RequestBody HotelDTO hotelDTO){
        return hotelService.Update(hotelDTO);
    }

}
