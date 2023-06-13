package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.Response;
import com.example.backend.entity.Attractions;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttractionsService extends IService<Attractions> {
    AttractionsResponse All(AttractionsDTO attractionsDTO);
    AttractionsResponse Ma_All();
    AttractionsResponse Search(AttractionsDTO attractionsDTO);
    AttractionsResponse Delete(AttractionsDTO attractionsDTO);
    AttractionsResponse Update(AttractionsDTO attractionsDTO);
    AttractionsResponse Add(AttractionsDTO attractionsDTO);
    AttractionsResponse Details(AttractionsDTO attractionsDTO);
}
