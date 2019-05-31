package com.car.admin.interception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo-restful
 * @description: 拦截器
 * @author: zhanyh
 * @create: 2019-05-31 09:42
 **/
//定义拦截器适配器，使用Configuration注解修饰
@Configuration
public class Interception implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {

        System.out.println("请求被拦截"+request.getServletPath());

        //true为放行  false为拦截。
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
