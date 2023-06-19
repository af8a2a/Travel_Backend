package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@TableName("comment")
@Data
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String uid;
    private Integer pid;
    private String type;
    private String content;
}
