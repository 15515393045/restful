package com.car.admin.test13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-07 21:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo {

    @Autowired
    StringRedisTemplate redisTemplate;

    //设置key和value
    @Test
    public void test(){
            redisTemplate.opsForValue().set("name","张三");
    }
    //获取key所对应的值
    @Test
    public void test1(){
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    //删除key以及它所对应的值
    @Test
    public void test2(){
       redisTemplate.delete("name");
    }

    @Test
    public void test3(){
        //存入redis并且设置过期时间,单位为秒：TimeUnit.SECONDS
        redisTemplate.opsForValue().set("name","张三",60,TimeUnit.SECONDS);
    }

    @Test
    public void test4(){

        //hasKey验证key是否存在，存在返回true,不存在返回false
        Boolean name = redisTemplate.hasKey("name");

        if(name){
            String name1 = redisTemplate.opsForValue().get("name");
            System.out.println(name1);
        }else{
            System.out.println("这条数据不存在！");
        }

    }
}
