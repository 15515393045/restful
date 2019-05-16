package com.car.admin.service.impl;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.dto.User;
import com.car.admin.mapper.IMapperLogin;
import com.car.admin.service.ILoginService;
import com.car.admin.util.ServerBase;
import com.car.admin.util.SystemCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
        if(!account.equals(UserDB.getAccount())){
            return ResponseResult.fail(SystemCount.ACCOUNT_ERROR);
        }

        //验证密码是否正确
        if(!password.equals(UserDB.getPassword())){
            return ResponseResult.fail(SystemCount.PASSWORD_ERROR);
        }

        return ResponseResult.success();
    }


}
