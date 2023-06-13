package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.FoodResponse;
import com.example.backend.dto.HotelDTO;
import com.example.backend.dto.HotelResponse;
import com.example.backend.entity.Food;
import com.example.backend.entity.Hotel;
import com.example.backend.mapper.FoodMapper;
import com.example.backend.mapper.HotelMapper;
import com.example.backend.service.FoodService;
import com.example.backend.service.HotelService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService {
    @Resource
    private HotelMapper hotelMapper;

    @Override
    public HotelResponse All(Integer page) {
        HotelResponse response=new HotelResponse();
        List<Hotel> hotelList=hotelMapper.selectList(new QueryWrapper<Hotel>()
                .last("LIMIT "+0+","+page));
        response.setHotelList(hotelList);
        response.setMessage("获取成功");
        return response;

    }

    @Override
    public HotelResponse Ma_All() {
        HotelResponse response=new HotelResponse();
        List<Hotel> hotelList=hotelMapper.selectList(null);
        response.setHotelList(hotelList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public HotelResponse Search(String name) {
        HotelResponse response=new HotelResponse();
        List<Hotel> hotelList=hotelMapper.selectList(new QueryWrapper<Hotel>()
                .lambda().like(Hotel::getName,name));
        response.setHotelList(hotelList);
        response.setMessage("搜索成功");
        return response;
    }

    @Override
    public HotelResponse Delete(Integer id) {
        HotelResponse response=new HotelResponse();
        QueryWrapper<Hotel> queryWrapper =new QueryWrapper<Hotel>();
        queryWrapper.lambda().like(Hotel::getId,id);
        int result=hotelMapper.delete(queryWrapper);
        if(result>0){
            response.setMessage("酒店删除成功");
        }else{
            response.setMessage("酒店删除错误");
        }
        return response;
    }

    @Override
    public HotelResponse Update(HotelDTO hotelDTO) {
        HotelResponse response = new HotelResponse();
        Hotel hotel=new Hotel();
        BeanUtils.copyProperties(hotelDTO,hotel);
        hotelMapper.updateById(hotel);
        response.setMessage("酒店修改成功");
        return response;

    }

    @Override
    public HotelResponse Add(HotelDTO hotelDTO) {
        HotelResponse response = new HotelResponse();
        Hotel hotel=new Hotel();
        BeanUtils.copyProperties(hotelDTO,hotel);
        save(hotel);
        response.setMessage("酒店添加成功");
        return response;
    }

    @Override
    public HotelResponse Details(Integer id) {
        HotelResponse response = new HotelResponse();
        QueryWrapper<Hotel> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Hotel::getId,id);
        List<Hotel> hotelList=hotelMapper.selectList(queryWrapper);
        response.setHotelList(hotelList);
        response.setMessage("酒店查询成功");
        return response;
    }
}
