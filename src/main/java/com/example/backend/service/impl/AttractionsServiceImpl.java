package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.AttractionsDTO;
import com.example.backend.dto.AttractionsResponse;
import com.example.backend.entity.Attractions;
import com.example.backend.mapper.AttractionsMapper;
import com.example.backend.service.AttractionsService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttractionsServiceImpl extends ServiceImpl<AttractionsMapper, Attractions> implements AttractionsService {
    @Resource
    private AttractionsMapper attractionsMapper;
    @Override
    public AttractionsResponse All(AttractionsDTO attractionsDTO) {
        AttractionsResponse response=new AttractionsResponse();
        List<Attractions> attractionsList=attractionsMapper.selectList(new QueryWrapper<Attractions>()
                .last("LIMIT "+0+","+attractionsDTO.getPage()));
        response.setData(attractionsList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public AttractionsResponse Ma_All() {
        AttractionsResponse response=new AttractionsResponse();
        List<Attractions> attractionsList=attractionsMapper.selectList(null);
        response.setData(attractionsList);
        response.setMessage("获取成功");
        return response;

    }

    @Override
    public AttractionsResponse Search(AttractionsDTO attractionsDTO) {
        AttractionsResponse response=new AttractionsResponse();
        QueryWrapper<Attractions> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Attractions::getTitle, attractionsDTO.getTitle()).last("LIMIT "+0+","+attractionsDTO.getPage());
        List<Attractions> attractionsList=attractionsMapper.selectList(queryWrapper);
        response.setData(attractionsList);
        response.setMessage("搜索成功");
        return response;
    }

    @Override
    public AttractionsResponse Delete(AttractionsDTO attractionsDTO) {
        AttractionsResponse response=new AttractionsResponse();
        QueryWrapper<Attractions> wrapper = new QueryWrapper<>();
        wrapper.eq("id", attractionsDTO.getId());
        int result = attractionsMapper.delete(wrapper);
        if(result>0){
            response.setMessage("景点删除成功");
        }else{
            response.setMessage("景点删除错误");
        }
        return response;
    }

    @Override
    public AttractionsResponse Add(AttractionsDTO attractionsDTO) {
        AttractionsResponse response = new AttractionsResponse();
        Attractions attractions=new Attractions();
        BeanUtils.copyProperties(attractionsDTO,attractions);
        save(attractions);
        response.setMessage("景点添加成功");
        return response;
    }

    @Override
    public AttractionsResponse Details(AttractionsDTO attractionsDTO) {
        AttractionsResponse response=new AttractionsResponse();
        QueryWrapper<Attractions> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Attractions::getId, attractionsDTO.getId());
        List<Attractions> attractionsList=attractionsMapper.selectList(queryWrapper);
        response.setData(attractionsList);
        response.setMessage("搜索成功");
        return response;

    }

    @Override
    public AttractionsResponse Update(AttractionsDTO attractionsDTO) {
        AttractionsResponse response = new AttractionsResponse();
        Attractions attractions=new Attractions();
        BeanUtils.copyProperties(attractionsDTO,attractions);
        response.setMessage("景点修改成功");
        return response;

    }
}
