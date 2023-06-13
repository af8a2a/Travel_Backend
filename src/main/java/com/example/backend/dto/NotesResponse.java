package com.example.backend.dto;

import com.example.backend.entity.Food;
import com.example.backend.entity.Notes;
import lombok.Data;

import java.util.List;

@Data
public class NotesResponse {
    private String message;
    List<Notes> notesList;
}
