package com.car.admin.service;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.User;

public interface ILoginService {


    ResponseResult UserLogin(User user);

    ResponseResult addUser(User user);

    ResponseResult openUser(User user);

    ResponseResult applyUser(User user);
}
