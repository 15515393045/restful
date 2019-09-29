package com.car.admin.service;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.User;

public interface ILoginService {

    public static final int NUM = 3;// NUM的值不能改变

    ResponseResult UserLogin(User user);

    ResponseResult addUser(User user);

    ResponseResult openUser(User user);

    ResponseResult applyUser(User user);
}
