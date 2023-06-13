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
@RequestMapping("/attractions")
public class AttractionsController {
    @Resource
    private AttractionsService attractionsService;

    @PostMapping("/details")
    @ResponseBody
    public AttractionsResponse Details(@RequestParam("id")Integer id){
        return attractionsService.Details(id);
    }

    @PostMapping("/search")
    @ResponseBody
    public AttractionsResponse Search(@RequestParam("title")String title,@RequestParam("page")Integer page){
        return attractionsService.Search(title,page);
    }

    @PostMapping("/delete")
    @ResponseBody
    public AttractionsResponse Delete(@RequestParam("id") Integer id){
        return attractionsService.Delete(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public AttractionsResponse Add(AttractionsDTO attractionsDTO){
        return attractionsService.Add(attractionsDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public AttractionsResponse All(@RequestParam("page")Integer page){
        return attractionsService.All(page);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public AttractionsResponse All(){
        return attractionsService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public AttractionsResponse Update(AttractionsDTO attractionsDTO){
        return attractionsService.Update(attractionsDTO);
    }
}
