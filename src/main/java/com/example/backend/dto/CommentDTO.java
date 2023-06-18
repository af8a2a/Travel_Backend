package com.example.backend.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Integer userId;
    private String type;
    private Integer entityId;
    private String content;
}
