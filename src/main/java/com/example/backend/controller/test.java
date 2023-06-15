package com.example.backend.controller;

import com.example.backend.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Api(tags = "测试")
public class test {

    @ResponseBody
    @GetMapping("/get")
    @ApiOperation("测试接口1")
    public Response Get(){
        Response response=new Response();
        response.setMessage("Hello");
        return response;
    }
}
