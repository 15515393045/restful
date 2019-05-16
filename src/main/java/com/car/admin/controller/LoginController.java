package com.car.admin.controller;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.User;
import com.car.admin.service.ILoginService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("login/")
public class LoginController{

    @Resource
    private ILoginService loginService;

    //登录
    @PostMapping("user")
    public ResponseResult UserLogin(@Valid User user, BindingResult result){

        if(result.hasErrors()){
            return ResponseResult.fail(1,result.getFieldError().getDefaultMessage());
        }

        return loginService.UserLogin(user);
    }

    //注册
    @PostMapping("add")
    public ResponseResult addUser(@Valid User user, BindingResult result){

        if(result.hasErrors()){
            return ResponseResult.fail(1,result.getFieldError().getDefaultMessage());
        }

        return loginService.addUser(user);
    }

}
