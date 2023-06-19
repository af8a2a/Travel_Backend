package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.CommentDTO;
import com.example.backend.dto.CommentResponse;
import com.example.backend.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    CommentResponse AddComment(CommentDTO commentDTO);
    List<Comment> GetComment(Integer id, String type);
}
