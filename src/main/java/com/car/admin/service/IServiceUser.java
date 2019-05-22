package com.car.admin.service;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ServerResponse;

import java.util.List;
import java.util.Map;

public interface IServiceUser {

    ServerResponse findUser();

    ResponseResult addUser(UserBean user);

    ResponseResult updateUser(UserBean user);

    ResponseResult queryUserId(Integer userId);

    ResponseResult deleteUser(Integer id);

    ResponseResult batchDeleteUser(String ids);

    ResponseResult batchInsertUser(Map userDate);

    ResponseResult queryUserPage(UserBean userBean);
}
