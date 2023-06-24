package com.example.backend.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private String username;
    private String type;
    private Integer pid;

}
