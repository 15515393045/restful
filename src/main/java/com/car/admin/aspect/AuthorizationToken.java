package com.car.admin.aspect;

import com.car.admin.ServerEnums.ResponseResult;
import com.car.admin.annotation.TokenJwt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-06 12:14
 **/
@Aspect
@Component
public class AuthorizationToken {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* com.car.admin.controller.*.*(..))")
    public void pointcutMethod(){

    }

    @Around("pointcutMethod() && @annotation(tokenJwt)")
    public Object around(ProceedingJoinPoint pjp, TokenJwt tokenJwt){
        Object proceed = null;
        boolean value = tokenJwt.value();
        if(value){
            System.out.println("返回true");
        }else{
            System.out.println("返回false");
        }
        try {
            //核心方法
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResponseResult.fail(-1,"系统异常");
        }

        return proceed;
    }

}
