package com.example.backend.controller;

import com.example.backend.dto.CommentDTO;
import com.example.backend.dto.CommentResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.service.CommentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/comments")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/{id}/{type}")
    @ResponseBody
    public CommentResponse Get(@PathVariable("id")Integer id,@PathVariable("type")String type){
        return commentService.GetComment(id,type);
    }
    @PostMapping("/add")
    @ResponseBody
    public CommentResponse Add(@RequestBody CommentDTO commentDTO){
        return commentService.AddComment(commentDTO);
    }
}
