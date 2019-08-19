package com.car.admin.test14;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-09 08:24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionDemo {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Test
    public void test1(){
        request.getSession().setAttribute("name","张三");

        String name = (String) request.getSession().getAttribute("name");

        System.out.println(name);
    }

    @Test
    public void test2(String key,String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setDomain("www.baidu.com");
        cookie.setPath("/");
        cookie.setMaxAge(-1);


        response.addCookie(cookie);
    }
}
