package com.example.backend.dto;

import lombok.Data;

@Data
public class NotesDTO {
    private Integer id;
    private String title;
    private String image;
    private String time;
    private String score;
    private String address;
    private String content;
    private Integer page;
}
