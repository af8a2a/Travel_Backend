package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.Response;
import com.example.backend.entity.Attractions;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttractionsService extends IService<Attractions> {
    AttractionsResponse All(Integer page);
    AttractionsResponse Ma_All();
    AttractionsResponse Search(String title,Integer page);
    AttractionsResponse Delete(Integer id);
    AttractionsResponse Update(AttractionsDTO attractionsDTO);
    AttractionsResponse Add(AttractionsDTO attractionsDTO);
    AttractionsResponse Details(Integer id);
}
