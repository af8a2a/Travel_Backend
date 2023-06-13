package com.example.backend.controller;


import com.example.backend.dto.LoginDTO;
import com.example.backend.dto.Response;
import com.example.backend.dto.UserDTO;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @PostMapping("/register")
    public Response Register(LoginDTO loginDTO){
        Response response=userService.Register(loginDTO);
        return response;
    }
    @ResponseBody
    @PostMapping("/login")
    public Response Login(LoginDTO loginDTO){
        Response response=userService.Login(loginDTO);
        return response;
    }
    @ResponseBody
    @PostMapping("/update")
    public Response Update(UserDTO userDTO){
        Response response=userService.Update(userDTO);
        return response;
    }
}
