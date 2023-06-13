package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notes")
public class Notes {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String link;
    private String image;
    private String user;
    private String time;
    private String days;
    private String quantity;
    private String look;
    private String like;
    private Double comment;
    private String address;
    private String imageo;
    private String imaget;
    private String images;
    private String imagef;
}
