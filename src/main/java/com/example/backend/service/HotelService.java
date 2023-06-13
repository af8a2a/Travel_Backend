package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.entity.Hotel;

public interface HotelService extends IService<Hotel> {
    HotelResponse All(Integer page);
    HotelResponse Ma_All();
    HotelResponse Search(String name);
    HotelResponse Delete(Integer id);
    HotelResponse Update(HotelDTO hotelDTO);
    HotelResponse Add(HotelDTO hotelDTO);
    HotelResponse Details(Integer id);

}
