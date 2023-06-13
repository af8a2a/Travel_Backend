package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.dto.FoodDTO;
import com.example.backend.dto.FoodResponse;
import com.example.backend.entity.Attractions;
import com.example.backend.entity.Food;
import com.example.backend.mapper.AttractionsMapper;
import com.example.backend.mapper.FoodMapper;
import com.example.backend.service.FoodService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    @Override
    public FoodResponse All(FoodDTO foodDTO) {
        FoodResponse response=new FoodResponse();
        List<Food> foodList=foodMapper.selectList(new QueryWrapper<Food>()
                .last("LIMIT "+0+","+foodDTO.getPage()));
        response.setData(foodList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public FoodResponse Ma_All() {
        FoodResponse response=new FoodResponse();
        List<Food> attractionsList=foodMapper.selectList(null);
        response.setData(attractionsList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public FoodResponse Search(FoodDTO foodDTO) {
        FoodResponse response=new FoodResponse();
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Food::getName, foodDTO.getName());
        List<Food> foodList=foodMapper.selectList(queryWrapper);
        response.setData(foodList);
        response.setMessage("搜索成功");
        return response;
    }

    @Override
    public FoodResponse Delete(FoodDTO foodDTO) {
        FoodResponse response=new FoodResponse();
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Food::getId, foodDTO.getId());
        int result=foodMapper.delete(queryWrapper);
        if(result>0){
            response.setMessage("食物删除成功");
        }else{
            response.setMessage("食物删除错误");
        }
        return response;
    }

    @Override
    public FoodResponse Update(FoodDTO foodDTO) {
        FoodResponse response = new FoodResponse();
        Food food=new Food();
        BeanUtils.copyProperties(foodDTO,food);
        foodMapper.updateById(food);
        response.setMessage("食物修改成功");
        return response;
    }

    @Override
    public FoodResponse Add(FoodDTO foodDTO) {
        FoodResponse response = new FoodResponse();
        Food food=new Food();
        BeanUtils.copyProperties(foodDTO,food);
        save(food);
        response.setMessage("食物添加成功");
        return response;
    }

    @Override
    public FoodResponse Details(FoodDTO foodDTO) {
        FoodResponse response = new FoodResponse();
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Food::getId,foodDTO.getId());
        List<Food> foodList=foodMapper.selectList(queryWrapper);
        response.setData(foodList);
        response.setMessage("食物查询成功");
        return response;
    }
}
