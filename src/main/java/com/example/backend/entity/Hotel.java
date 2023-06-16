package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hotel")
public class Hotel {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String image;
    private String name;
    private String address;
    private String score;
    private String price;
}
