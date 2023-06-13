package com.example.backend.controller;

import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.service.NotesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
@CrossOrigin
public class NotesController {

    @Resource
    private NotesService notesService;
    @PostMapping("/details")
    @ResponseBody
    public NotesResponse Details(@RequestBody NotesDTO notesDTO){
        return notesService.Details(notesDTO);
    }

    @PostMapping("/search")
    @ResponseBody
    public NotesResponse Search(@RequestBody NotesDTO notesDTO){
        return notesService.Search(notesDTO);
    }

    @PostMapping("/delete")
    @ResponseBody
    public NotesResponse Delete(@RequestBody NotesDTO notesDTO){
        return notesService.Delete(notesDTO);
    }

    @PostMapping("/add")
    @ResponseBody
    public NotesResponse Add(@RequestBody NotesDTO notesDTO){
        return notesService.Add(notesDTO);
    }

    @PostMapping("/all")
    @ResponseBody
    public NotesResponse All(@RequestBody NotesDTO notesDTO){
        return notesService.All(notesDTO);
    }

    @GetMapping("/ma_all")
    @ResponseBody
    public NotesResponse All(){
        return notesService.Ma_All();
    }

    @PostMapping("/update")
    @ResponseBody
    public NotesResponse Update(@RequestBody NotesDTO notesDTO){
        return notesService.Update(notesDTO);
    }

}
