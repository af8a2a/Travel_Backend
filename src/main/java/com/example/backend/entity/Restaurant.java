package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("restaurant")
public class Restaurant {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String link;
    private String image;
    private String address;
    private String price;
    private String score;
    private String comment;
}
