package com.example.backend.controller;

import com.example.backend.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class test {

    @ResponseBody
    @GetMapping("/get")
    public Response Get(){
        Response response=new Response();
        response.setMessage("Hello");
        return response;
    }
}
