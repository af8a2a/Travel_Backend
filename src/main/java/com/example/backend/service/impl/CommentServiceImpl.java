package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.CommentDTO;
import com.example.backend.dto.CommentResponse;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Food;
import com.example.backend.entity.User;
import com.example.backend.mapper.CommentMapper;
import com.example.backend.service.CommentService;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public CommentResponse AddComment(CommentDTO commentDTO) {
        Comment comment=new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        save(comment);
        CommentResponse response = new CommentResponse();
        List<Comment> responseList=new ArrayList<>();
        responseList.add(comment);
        response.setMessage("评论成功");
        response.setData(responseList);
        return response;
    }

    @Override
    public List<Comment> GetComment(Integer id,String type) {
        List<Comment> commentList=new ArrayList<>();
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Comment::getType,type)
                .eq(Comment::getPid,id);
        commentList=commentMapper.selectList(queryWrapper);
        return commentList;
    }
}
