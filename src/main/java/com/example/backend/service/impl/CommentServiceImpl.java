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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    private CommentMapper commentMapper;
    @Override
    public CommentResponse AddComment(CommentDTO commentDTO) {
        Comment comment=new Comment();
        BeanUtils.copyProperties(commentDTO,comment);
        save(comment);
        CommentResponse response = new CommentResponse();
        response.setMessage("评论成功");
        return response;
    }

    @Override
    public CommentResponse GetComment(CommentDTO commentDTO) {
        CommentResponse response=new CommentResponse();
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Comment::getType,commentDTO.getType())
                .eq(Comment::getEntityid,commentDTO.getEntityId());
        response.setData(commentMapper.selectList(queryWrapper));
        response.setMessage("获取评论成功");
        return response;
    }
}
