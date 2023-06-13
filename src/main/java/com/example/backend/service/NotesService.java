package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.entity.Notes;

public interface NotesService extends IService<Notes> {
    NotesResponse All(NotesDTO notesDTO);
    NotesResponse Ma_All();
    NotesResponse Search(NotesDTO notesDTO);
    NotesResponse Delete(NotesDTO notesDTO);
    NotesResponse Update(NotesDTO notesDTO);
    NotesResponse Add(NotesDTO notesDTO);
    NotesResponse Details(NotesDTO notesDTO);

}
