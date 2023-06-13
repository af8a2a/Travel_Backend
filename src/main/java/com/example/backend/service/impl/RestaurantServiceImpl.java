package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.HotelResponse;
import com.example.backend.dto.RestaurantDTO;
import com.example.backend.dto.RestaurantResponse;
import com.example.backend.entity.Hotel;
import com.example.backend.entity.Restaurant;
import com.example.backend.mapper.HotelMapper;
import com.example.backend.mapper.RestaurantMapper;
import com.example.backend.service.RestaurantService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl extends ServiceImpl<RestaurantMapper, Restaurant> implements RestaurantService {
    @Resource
    private RestaurantMapper restaurantMapper;


    @Override
    public RestaurantResponse All(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        List<Restaurant> restaurants=restaurantMapper.selectList(new QueryWrapper<Restaurant>()
                .last("LIMIT "+0+","+restaurantDTO.getPage()));
        response.setData(restaurants);
        response.setMessage("获取成功");
        return response;

    }

    @Override
    public RestaurantResponse Ma_All() {
        RestaurantResponse response=new RestaurantResponse();
        List<Restaurant> restaurants=restaurantMapper.selectList(null);
        response.setData(restaurants);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public RestaurantResponse Search(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        List<Restaurant> restaurants=restaurantMapper.selectList(new QueryWrapper<Restaurant>()
                .lambda().like(Restaurant::getName,restaurantDTO.getName()));
        response.setData(restaurants);
        response.setMessage("搜索成功");
        return response;
    }

    @Override
    public RestaurantResponse Delete(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        QueryWrapper<Restaurant> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().like(Restaurant::getId,restaurantDTO.getId());
        int result=restaurantMapper.delete(queryWrapper);
        if(result>0){
            response.setMessage("餐馆删除成功");
        }else{
            response.setMessage("餐馆删除错误");
        }
        return response;
    }

    @Override
    public RestaurantResponse Update(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        Restaurant restaurant=new Restaurant();
        BeanUtils.copyProperties(restaurantDTO,restaurant);
        restaurantMapper.updateById(restaurant);
        response.setMessage("餐馆添加成功");
        return response;
    }

    @Override
    public RestaurantResponse Add(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        Restaurant restaurant=new Restaurant();
        BeanUtils.copyProperties(restaurantDTO,restaurant);
        save(restaurant);
        response.setMessage("餐馆修改成功");
        return response;
    }

    @Override
    public RestaurantResponse Details(RestaurantDTO restaurantDTO) {
        RestaurantResponse response=new RestaurantResponse();
        QueryWrapper<Restaurant> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Restaurant::getId,restaurantDTO.getId());
        List<Restaurant> restaurants=restaurantMapper.selectList(queryWrapper);
        response.setData(restaurants);
        response.setMessage("餐馆查询成功");
        return response;
    }
}

