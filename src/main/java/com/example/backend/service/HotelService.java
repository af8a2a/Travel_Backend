package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.entity.Hotel;

public interface HotelService extends IService<Hotel> {
    HotelResponse All(HotelDTO hotelDTO);
    HotelResponse Ma_All();
    HotelResponse Search(HotelDTO hotelDTO);
    HotelResponse Delete(HotelDTO hotelDTO);
    HotelResponse Update(HotelDTO hotelDTO);
    HotelResponse Add(HotelDTO hotelDTO);
    HotelResponse Details(HotelDTO hotelDTO);

}
