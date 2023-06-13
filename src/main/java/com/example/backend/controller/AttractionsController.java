package com.example.backend.controller;

import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.Response;
import com.example.backend.entity.Attractions;
import com.example.backend.service.AttractionsService;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/attractions")
public class AttractionsController {
    @Resource
    private AttractionsService attractionsService;

    @PostMapping("/details")
    @ResponseBody
    public AttractionsResponse Details(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.Details(attractionsDTO);
    }

    @PostMapping("/search")
    @ResponseBody
    public AttractionsResponse Search(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.Search(attractionsDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public AttractionsResponse Delete(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.Delete(attractionsDTO);
    }

    @PostMapping("/add")
    @ResponseBody
    public AttractionsResponse Add(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.Add(attractionsDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public AttractionsResponse All(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.All(attractionsDTO);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public AttractionsResponse Ma_All(){
        return attractionsService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public AttractionsResponse Update(@RequestBody AttractionsDTO attractionsDTO){
        return attractionsService.Update(attractionsDTO);
    }
}
