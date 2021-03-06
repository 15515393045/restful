package com.car.admin.service;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.bean.ClientLoginBean;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ResponseServer;

import java.util.Map;

public interface IServiceUser {

    ResponseServer findUser();

    ResponseResult addUser(UserBean user);

    ResponseResult updateUser(UserBean user);

    ResponseResult queryUserId(Integer userId);

    ResponseResult deleteUser(Integer id);

    ResponseResult batchDeleteUser(String ids);

    ResponseResult batchInsertUser(Map userDate);

    ResponseResult queryUserPage(UserBean userBean);

    ResponseResult findJson();

    ResponseResult queryGoods();

    ResponseResult clientLogin(ClientLoginBean user);
}
