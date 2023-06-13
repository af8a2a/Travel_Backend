package com.example.backend.controller;

import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.service.HotelService;
import com.example.backend.service.NotesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel")
public class NotesController {

    @Resource
    private NotesService notesService;
    @PostMapping("/details")
    @ResponseBody
    public NotesResponse Details(@RequestParam("id")Integer id){
        return notesService.Details(id);
    }

    @PostMapping("/search")
    @ResponseBody
    public NotesResponse Search(@RequestParam("name")String name){
        return notesService.Search(name);
    }

    @PostMapping("/delete")
    @ResponseBody
    public NotesResponse Delete(@RequestParam("id") Integer id){
        return notesService.Delete(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public NotesResponse Add(NotesDTO notesDTO){
        return notesService.Add(notesDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public NotesResponse All(@RequestParam("page")Integer page){
        return notesService.All(page);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public NotesResponse All(){
        return notesService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public NotesResponse Update(NotesDTO notesDTO){
        return notesService.Update(notesDTO);
    }

}
