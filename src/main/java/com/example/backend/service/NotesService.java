package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.entity.Notes;

public interface NotesService extends IService<Notes> {
    NotesResponse All(Integer page);
    NotesResponse Ma_All();
    NotesResponse Search(String name);
    NotesResponse Delete(Integer id);
    NotesResponse Update(NotesDTO notesDTO);
    NotesResponse Add(NotesDTO notesDTO);
    NotesResponse Details(Integer id);

}
