package com.car.admin.aspect;

import com.car.admin.annotation.AccessLimit;
import com.car.admin.enums.ResponseEnum;
import com.car.admin.enums.ResponseServer;
import com.car.admin.util.MD5Util;
import com.car.admin.util.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
    @Value("${appSecret}")
    private String appSecret;

    @Autowired
    private HttpServletRequest request;

    //自定义过期时间
    private Long exp = 5L * 1000 * 60;

    @Pointcut("execution( * com.car.admin.controllerStuDySql.*.*(..))")
    public void pointcutMethod(){}

    @Around("pointcutMethod()")
    public Object run(ProceedingJoinPoint pjp){

        String appKey = request.getHeader("appKey");
        String checkSum = request.getHeader("checkSum");

        Long currentTime = null;
        try {
            currentTime  = Long.valueOf(request.getHeader("currentTime"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String nonce = request.getHeader("nonce");

        if(StringUtils.isEmpty(appKey)||StringUtils.isEmpty(checkSum)||
        StringUtils.isEmpty(nonce)||currentTime==null){
            return ResponseServer.error(ResponseEnum.INTERFACE_HEADERERROR);
        }

        Long serverTime = System.currentTimeMillis();
        if(serverTime - currentTime > exp){
            return ResponseServer.error(ResponseEnum.INTERFACE_OVERTIME);
        }
        //第一次没有这个这返回1我们就设置这个值,第二次已经有这个值了返回false
        //我们通过取反让它返回true进入这个if判断
        if(!RedisUtil.setnx(checkSum,300000)){
            return ResponseServer.error(ResponseEnum.INTERFACE_INTERFACEATTACK);
        }

        String newSign = MD5Util.getStringMD5(appKey + appSecret + currentTime + nonce);
        if(!checkSum.equals(newSign)){
            return ResponseServer.error(ResponseEnum.INTERFACE_SIGNERROR);
        }

        //接口限流
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
            String Key = this.appKey +":"+request.getMethod()+":"+request.getRequestURI();
            //通过expire方法来进行接口限流
            if(RedisUtil.isLimit(Key,seconds,maxCount )){
            //响应前台的报文要和执行核心方法的返回值保存一致，否则报错。
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
