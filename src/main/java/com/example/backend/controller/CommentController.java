package com.example.backend.controller;

import com.example.backend.dto.CommentDTO;
import com.example.backend.dto.CommentResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.service.CommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/comments")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/get")
    @ResponseBody
    public CommentResponse Get(@RequestBody CommentDTO commentDTO){
        return commentService.GetComment(commentDTO);
    }
    @PostMapping("/add")
    @ResponseBody
    public CommentResponse Add(@RequestBody CommentDTO commentDTO){
        return commentService.AddComment(commentDTO);
    }
}
