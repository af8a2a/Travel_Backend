package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("attractions")

@Data
public class Attractions {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String image;
    private String level;
    private String area;
    private String product;
    private String address;
    private String information;
    private String price;
    private String amount;

}
