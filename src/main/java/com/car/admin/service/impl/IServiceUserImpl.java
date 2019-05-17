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
import java.util.Map;

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

    @Override
    public ResponseResult batchDeleteUser(String ids) {

        if(ids != null){
            String[] idsArr = ids.split(",");
            List<Integer> idsList = new ArrayList<>();

            for (String s : idsArr) {
                idsList.add(Integer.parseInt(s));
            }

            mapperUser.batchDeleteUser(idsList);
        }

        return ResponseResult.success();
    }

    //批量插入
    @Override
    public ResponseResult batchInsertUser(Map userDate) {

        //根据键获取该键所对应的值,为一个list集合
        List<Map<String,String>> list = (List<Map<String, String>>) userDate.get("data");

        //定义一个集合用于批量插入
        List<UserBean> userList = new ArrayList<>();

        //对获取到的list集合进行验证
        if(list.size() > 0 && list != null){
            //循环拿到的list集合
            for (Map<String, String> map : list) {
                //初始化对象并进行赋值
                UserBean userBean = new UserBean();
                userBean.setName(map.get("name"));
                userBean.setAge(map.get("age"));

                //将赋过值的对象放入自定义的list集合传到xml文件中去
                userList.add(userBean);
            }
        }

        mapperUser.batchInsertUser(userList);

        return ResponseResult.success();
    }


}
