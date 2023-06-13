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
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    @Override
    public FoodResponse All(Integer page) {
        FoodResponse response=new FoodResponse();
        List<Food> foodList=foodMapper.selectList(new QueryWrapper<Food>()
                .last("LIMIT "+0+","+page));
        response.setFoodList(foodList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public FoodResponse Ma_All() {
        FoodResponse response=new FoodResponse();
        List<Food> attractionsList=foodMapper.selectList(null);
        response.setFoodList(attractionsList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public FoodResponse Search(String name) {
        FoodResponse response=new FoodResponse();
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Food::getName, name);
        List<Food> foodList=foodMapper.selectList(queryWrapper);
        response.setFoodList(foodList);
        response.setMessage("搜索成功");
        return response;
    }

    @Override
    public FoodResponse Delete(Integer id) {
        FoodResponse response=new FoodResponse();
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Food::getId, id);
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
        return null;
    }

    @Override
    public FoodResponse Add(FoodDTO foodDTO) {
        return null;
    }

    @Override
    public FoodResponse Details(Integer id) {
        return null;
    }
}
