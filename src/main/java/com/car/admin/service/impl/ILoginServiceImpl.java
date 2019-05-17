package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.Flow;
import com.car.admin.dto.User;
import com.car.admin.mapper.IMapperLogin;
import com.car.admin.service.ILoginService;
import com.car.admin.util.ServerBase;
import com.car.admin.util.SystemCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service("loginService")
public class ILoginServiceImpl extends ServerBase implements ILoginService {

    @Autowired
    private IMapperLogin mapperLogin;

    //登录
    @Override
    public ResponseResult UserLogin(User user){

        //进行为空验证
        BuildAnnotation buildAnnotation = new BuildAnnotation(user).invoke();
        String account = buildAnnotation.getAccount();
        String password = buildAnnotation.getPassword();
        if(account == null || password == null){
            return ResponseResult.fail(SystemCount.LOGIN_NULL);
        }

            //验证账号是否存在
            User UserDB = mapperLogin.loginUser(user);
            if (UserDB == null) {
                return ResponseResult.fail(SystemCount.ACCOUNT_ERROR);
            }


        //验证密码是否正确
        if(!password.equals(UserDB.getPassword())){
            return ResponseResult.fail(SystemCount.PASSWORD_ERROR);
        }

        return ResponseResult.success();
    }

    //注册
    @Override
    public ResponseResult addUser(User user) {

            User userDB = mapperLogin.loginUser(user);

            if(userDB == null){

                if(user.getAccount().length() < 4){
                    return ResponseResult.fail("账号的长度不能低于四位");
                }

                //增加
                mapperLogin.addUser(user);

            }else {

                if (user.getAccount().equals(userDB.getAccount())) {
                    return ResponseResult.fail("账号已存在请重新输入");
                }

            }

        return ResponseResult.success();
    }

    //开户
    @Override
    public ResponseResult openUser(User user) {

        try {

            User userDb = mapperLogin.loginUser(user);

            if(userDb == null){

                Random random = new Random();

                String result = "N" + "";

                for (int i=0;i<6;i++)
                {
                    result+=random.nextInt(10);
                }

                mapperLogin.addAccount(result);
            }else{

                return ResponseResult.fail("W000000");

            }

            //存入流程表
            Flow flow = new Flow();

            flow.setFlowInfo("存入流程表");

            mapperLogin.addFlow(flow);

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseResult.fail(e.getMessage());

        }

        return ResponseResult.success();
    }

    //申请
    @Override
    public ResponseResult applyUser(User user) {


        User userb = mapperLogin.loginUser(user);

        if(userb == null){

            return ResponseResult.fail("该账户不存在,无法进行开户");

        }else{

            mapperLogin.updateApplyUser(user);

            return ResponseResult.success("该账户已经开户!");
        }

    }

}
