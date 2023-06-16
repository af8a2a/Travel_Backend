package com.example.backend.dto;
import com.example.backend.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentResponse {
    private String message;
    private List<Comment> data;
}
