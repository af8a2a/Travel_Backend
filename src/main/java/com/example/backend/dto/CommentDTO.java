package com.example.backend.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String content;
    private Integer pid;
    private String type;
    private String uid;

}
