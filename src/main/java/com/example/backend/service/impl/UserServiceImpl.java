package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.dto.LoginDTO;
import com.example.backend.dto.LoginResponse;
import com.example.backend.dto.Response;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import com.example.backend.service.UserService;
import jakarta.annotation.Resource;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Resource
    private UserMapper userMapper;
    @Override
    public Response Update(UserDTO userDTO) {
        Response response=new Response();
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        if(!userDTO.getAvatar().isEmpty()){
            updateWrapper.lambda().eq(User::getUsername,userDTO.getUsername())
                    .set(User::getPassword,userDTO.getPassword())
                    .set(User::getNickname,userDTO.getNickname());
        }
        else{
            updateWrapper.lambda().eq(User::getUsername,userDTO.getUsername())
                    .set(User::getPassword,userDTO.getPassword())
                    .set(User::getNickname,userDTO.getNickname())
                    .set(User::getAvatar,userDTO.getAvatar());
        }
        int rows = userMapper.update(null, updateWrapper);
        if(rows>0){
            response.setMessage("success");
        }
        else {
            response.setMessage("fail");
        }

        return response;
    }
    @Override
    public Response Register(LoginDTO loginDTO) {
        Response userResponse=new Response();
        User user=new User();
        user.setPassword(loginDTO.getPassword());
        user.setUsername(loginDTO.getUsername());
        user.setNickname(loginDTO.getNickname());
        user.setType("1");
        user.setAvatar("https://s3.bmp.ovh/imgs/2023/06/12/23987ff34b67b1e5.png");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, loginDTO.getUsername());
        if(userMapper.selectCount(queryWrapper)>0){
            userResponse.setMessage("此账号已存在，请重新注册");
        }else{

            save(user);
            userResponse.setMessage("注册成功");
        }
        return userResponse;
    }

    @Override
    public Response Login(LoginDTO loginDTO) {
        Response response=new Response();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, loginDTO.getUsername());

        List<User> userList=userMapper.selectList(queryWrapper);
        System.out.println(loginDTO.getUsername());
        System.out.println(loginDTO.getPassword());
        User user=userList.get(0);

        if(userList.isEmpty()){
            response.setMessage("登录失败,账号或密码错误");
            return response;
        }
        if(user.getUsername().equals(loginDTO.getUsername())&&user.getPassword().equals(loginDTO.getPassword())){
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUsername(user.getUsername());
            loginResponse.setAvatar(user.getAvatar());
            loginResponse.setType(user.getType());
            loginResponse.setNickname(user.getNickname());
            response.setData(loginResponse);
            response.setMessage("登录成功");
            return response;
        }else{
            response.setMessage("登录失败,账号或密码错误");
            return response;
        }
    }
}
