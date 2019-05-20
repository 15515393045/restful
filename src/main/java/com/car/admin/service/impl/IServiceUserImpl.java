package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ServerResponse;
import com.car.admin.mapper.IMapperUser;
import com.car.admin.request.UserRequest;
import com.car.admin.service.IServiceUser;
import com.car.admin.util.CacheManager;
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

        //1. 获取缓存中的方法，
        CacheManager instance = CacheManager.getInstance();

        //2. 获取指定的对象存入缓存
        Object userList = instance.getObj("userList");

        //判断第一次缓存对象为空,将查询的数据放入缓存
        if(userList == null){
            List<UserBean> user = mapperUser.findUser();
            //Po转换Vo
            List<UserRequest> userRequest = getUserRequests(user);
            //将数据放入缓存
            instance.putObj("userList",userRequest);

            return ServerResponse.success(userRequest);
        }

        //第二次缓存不为空,则直接返回缓存中的数据
        return ServerResponse.success(userList);

    }
    private List<UserRequest> getUserRequests(List<UserBean> user) {
        List<UserRequest> userRequest = new ArrayList<>();
        //循环Po->(UserBean)
        for (UserBean userBean : user) {
            //在循环里面初始化VO->(UserRequest)
            UserRequest userInfo = new UserRequest();
            userInfo.setId(userBean.getId());
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
        CacheManager.getInstance().remove("userList");
        return ResponseResult.success();
        }


    @Override
    public ResponseResult updateUser(UserBean user) {

        mapperUser.updateUser(user);
        CacheManager.getInstance().remove("userList");
        return ResponseResult.success();
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseResult queryUserId(Integer userId) {

        CacheManager instance = CacheManager.getInstance();

        Object idUser = instance.getObj("userId");

        if(idUser == null){
            UserBean userBean = mapperUser.queryUserId(userId);
            instance.putObj("userId",userBean);
            return ResponseResult.success(userBean);
            }

        return ResponseResult.success(idUser);
    }


    @Override
    public ResponseResult deleteUser(Integer id) {
        mapperUser.deleteUser(id);
        CacheManager.getInstance().remove("userList");
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
        CacheManager.getInstance().remove("userList");
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

        CacheManager.getInstance().remove("userList");
        return ResponseResult.success();
    }

    //分页查询
    @Override
    public ResponseResult queryUserPage(UserBean userBean, Integer start, Integer length) {

        CacheManager instance = CacheManager.getInstance();

        Object pageUser = instance.getObj("pageUser");

        if(pageUser == null){
            //获取总条数
            Long listCount = mapperUser.queryCountList(userBean);
            //设置总条数
            userBean.setTotalCount(listCount);
            //调用计算方法
            userBean.calculatePage();
            //获取分页列表
            List<UserBean> userBeans = mapperUser.queryUserPage(userBean, start, length);
            //Po转Vo
            List<UserRequest> userRequests = getUserRequests(userBeans);
            //将数据存入缓存
            instance.putObj("pageUser",userRequests);

            return ResponseResult.success(userRequests);
        }

        return ResponseResult.success(pageUser);
    }


}
