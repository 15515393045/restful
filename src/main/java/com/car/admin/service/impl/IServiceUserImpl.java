package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.bean.ClientLoginBean;
import com.car.admin.bean.GoodsPo;
import com.car.admin.dto.UserBean;
import com.car.admin.enums.ResponseServer;
import com.car.admin.mapper.IMapperUser;
import com.car.admin.request.UserRequest;
import com.car.admin.service.IServiceUser;
import com.car.admin.util.CacheManager;
import com.car.admin.util.JwtTokenUtils;
import com.car.admin.util.MD5Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)//事务
@Slf4j
@Service
public class IServiceUserImpl implements IServiceUser {


    @Autowired
    private IMapperUser mapperUser;

    //只读事务
    @Transactional(readOnly = true)
    @Override
    public ResponseServer findUser() {

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

            return ResponseServer.success(userRequest);
        }

        //第二次缓存不为空,则直接返回缓存中的数据
        return ResponseServer.success(userList);

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
            //循环拿到的list集合获取里面的值
            for (Map<String, String> map : list) {
                //初始化对象并进行赋值
                UserBean userBean = new UserBean();
                userBean.setName(map.get("name"));
                //转换类型
                userBean.setAge(Integer.parseInt(map.get("age")));

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
    public ResponseResult queryUserPage(UserBean userBean) {

            //获取总条数
            Long listCount = mapperUser.queryCountList(userBean);
            //设置总条数
            userBean.setTotalCount(listCount);
            //调用计算方法
            userBean.calculatePage();
            //获取分页列表
            List<UserBean> userBeans = mapperUser.queryUserPage(userBean);
            //Po转Vo
            List<UserRequest> userRequests = getUserRequests(userBeans);

            return ResponseResult.success(userRequests);
    }

    @Override
    public ResponseResult findJson() {

        List<UserBean> json = mapperUser.findJson();

        //Po转换Vo
        List<UserRequest> list = getUserRequests(json);

        Map<String, Object> map = new HashMap();
        map.put("test",list);

        List list1 = new ArrayList();
        list1.add(map);

        //用 Gson 的tojson方法会把 null 值忽略，从而序列化之后输出不包含这个属性值的 Json
        //展示null值
        GsonBuilder builder = new GsonBuilder();
        String toJson = builder.serializeNulls().create().toJson(list1);

        //将Json格式的字符串转换为对象
        //Json对象套Json对象会报解析异常
        Gson gson = new Gson();
        List bean = gson.fromJson(toJson, List.class);

        return ResponseResult.success(bean);
    }

    @Override
    public ResponseResult queryGoods() {
        List<GoodsPo> goodsPos = mapperUser.queryGoods();
        return ResponseResult.success(goodsPos);
    }

    //JWTToken用户登录
    @Override
    public ResponseResult clientLogin(ClientLoginBean user) {
        try {

            ClientLoginBean userDB = mapperUser.queryClientInfo(user.getClientName());

            if(userDB == null){
                return ResponseResult.fail(201,"账户输入有误");
            }

            if(!MD5Util.getStringMD5(user.getPassword()).equals(userDB.getPassword())){
                return ResponseResult.fail(202,"输入的密码不正确");
            }

            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }

        String zhanyiheng = JwtTokenUtils.ToKenUtil(user, "ZHANYIHENG", 120000l);

        return ResponseResult.success(zhanyiheng);
    }


}
