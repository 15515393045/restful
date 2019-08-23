package com.car.admin.aspect;

import com.car.admin.annotation.AccessLimit;
import com.car.admin.enums.ResponseEnum;
import com.car.admin.enums.ResponseServer;
import com.car.admin.util.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-23 09:09
 **/
@Aspect
@Component
public class InterfaceSafetyAspect {

    @Value("${appKey}")
    private String appKey;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution( * com.car.admin.controllerStuDySql.*.*(..))")
    public void pointcutMethod(){}

    @Around("pointcutMethod()")
    @ResponseBody
    public Object run(ProceedingJoinPoint pjp){
        //通过pjp方法来获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //通过方法签名来获取方法
        Method method = signature.getMethod();
        //通过判断方法上面有没有自定义限流的主键
        if(method.isAnnotationPresent(AccessLimit.class)){
            //如果有通过方法获取该注解
            AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
            //获取该注解的值
            int maxCount = accessLimit.maxCount();
            int seconds = accessLimit.seconds();
            //通过appKey+请求的类型+请求的路径来作为Redis中的key,及针对不同的用户实现不同的限流策略。
            String Key = appKey+":"+request.getMethod()+":"+request.getRequestURI();
            //通过expire方法来进行接口限流
            if(RedisUtil.isLimit(Key,seconds,maxCount )){
            return ResponseServer.error(ResponseEnum.INTERFACE_ACCESSLIMIT);
            }
        }
        Object proceed = null;
        try {
            proceed  = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
