package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.NotesDTO;
import com.example.backend.dto.NotesResponse;
import com.example.backend.entity.Notes;
import com.example.backend.mapper.NotesMapper;
import com.example.backend.service.NotesService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl extends ServiceImpl<NotesMapper, Notes> implements NotesService{
    @Resource
    private NotesMapper notesMapper;

    @Override
    public NotesResponse All(NotesDTO notesDTO) {
        NotesResponse response = new NotesResponse();
        List<Notes> notesList=notesMapper.selectList(new QueryWrapper<Notes>()
                .last("LIMIT "+0+","+notesDTO.getPage()));
        response.setData(notesList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public NotesResponse Ma_All() {
        NotesResponse response=new NotesResponse();
        List<Notes> notesList =notesMapper.selectList(null);
        response.setData(notesList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public NotesResponse Search(NotesDTO notesDTO) {
        NotesResponse response=new NotesResponse();
        List<Notes> notesList =notesMapper.selectList(new QueryWrapper<Notes>()
                .lambda().like(Notes::getTitle,notesDTO.getTitle()));
        response.setData(notesList);
        response.setMessage("获取成功");
        return response;
    }

    @Override
    public NotesResponse Delete(NotesDTO notesDTO) {
        NotesResponse response=new NotesResponse();
        QueryWrapper<Notes> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().like(Notes::getId,notesDTO.getId());
        int result=notesMapper.delete(queryWrapper);
        if(result>0){
            response.setMessage("游记删除成功");
        }else{
            response.setMessage("游记删除错误");
        }
        return response;
    }

    @Override
    public NotesResponse Update(NotesDTO notesDTO) {
        NotesResponse response=new NotesResponse();
        Notes notes=new Notes();
        BeanUtils.copyProperties(notesDTO,notes);
        notesMapper.updateById(notes);
        response.setMessage("游记修改成功");
        return response;
    }

    @Override
    public NotesResponse Add(NotesDTO notesDTO) {
        NotesResponse response=new NotesResponse();
        Notes notes=new Notes();
        BeanUtils.copyProperties(notesDTO,notes);
        save(notes);
        response.setMessage("游记添加成功");
        return response;
    }

    @Override
    public NotesResponse Details(NotesDTO notesDTO) {
        NotesResponse response=new NotesResponse();
        QueryWrapper<Notes> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Notes::getId,notesDTO.getId());
        List<Notes> notesList=notesMapper.selectList(queryWrapper);
        response.setData(notesList);
        response.setMessage("游记添加成功");
        return response;
    }
}
