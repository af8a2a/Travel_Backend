package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notes")
public class Notes {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String image;
    private String time;
    private String score;
    private String address;
    private String content;
}
