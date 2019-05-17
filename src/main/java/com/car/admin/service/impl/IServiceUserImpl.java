package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ServerResponse;
import com.car.admin.mapper.IMapperUser;
import com.car.admin.request.UserRequest;
import com.car.admin.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
//事务
@Transactional(rollbackFor = Exception.class)
public class IServiceUserImpl implements IServiceUser {

    @Autowired
    private IMapperUser mapperUser;

    //只读事务
    @Transactional(readOnly = true)
    @Override
    public ServerResponse findUser() {
        List<UserBean> user = mapperUser.findUser();

        //Po转换Vo
        List<UserRequest> userRequest = getUserRequests(user);

        return ServerResponse.success(userRequest);
    }
    private List<UserRequest> getUserRequests(List<UserBean> user) {
        List<UserRequest> userRequest = new ArrayList<>();
        //循环Po->(UserBean)
        for (UserBean userBean : user) {
            //在循环里面初始化VO->(UserRequest)
            UserRequest userInfo = new UserRequest();
            userInfo.setAge(userBean.getAge());
            userInfo.setName(userBean.getName());
            //放入集合
            userRequest.add(userInfo);
        }
        return userRequest;
    }


    //企业枚举-》ResponseResult
    @Override
    public ResponseResult addUser(UserBean user) {

            mapperUser.addUser(user);

        return ResponseResult.success();
        }


    @Override
    public ResponseResult updateUser(UserBean user) {

        mapperUser.updateUser(user);

        return ResponseResult.success();
    }


    @Override
    public ResponseResult queryUserId(Integer userId) {

        UserBean userBean = mapperUser.queryUserId(userId);

        return ResponseResult.success(userBean);
    }


    @Override
    public ResponseResult deleteUser(Integer id) {
        mapperUser.deleteUser(id);
        return ResponseResult.success();
    }


}
