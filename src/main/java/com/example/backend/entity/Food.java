package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("food")
public class Food {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String image;
    private Integer recommend;
    private String information;
}
