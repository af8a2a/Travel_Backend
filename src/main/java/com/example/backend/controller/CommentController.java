package com.example.backend.controller;

import com.example.backend.dto.CommentDTO;
import com.example.backend.dto.CommentResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.entity.Comment;
import com.example.backend.service.CommentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/comments")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("/{pid}/{type}")
    @ResponseBody
    public List<Comment> Get(@PathVariable("pid")Integer id, @PathVariable("type")String type){
        return commentService.GetComment(id,type);
    }
    @PostMapping("/add")
    @ResponseBody
    public CommentResponse Add(@RequestBody CommentDTO commentDTO){
        return commentService.AddComment(commentDTO);
    }
}
