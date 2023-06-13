package com.example.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.backend.dto.LoginDTO;
import com.example.backend.dto.Response;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;

public interface UserService extends IService<User> {
    Response Register(LoginDTO loginDTO);
    Response Login(LoginDTO loginDTO);
    Response Update(UserDTO userDTO);
}
