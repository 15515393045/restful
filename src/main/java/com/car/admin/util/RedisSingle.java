package com.car.admin.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisSingle {

    private static JedisPool jedis = null;

    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        //建立jedis数据池并且连接远程缓存服务器
        jedis = new JedisPool(jedisPoolConfig,"192.168.154.128",7070);
    }

    public static Jedis getResopnse(){
        return jedis.getResource();
    }

    static{
        initPool();
    }

    private RedisSingle(){}

    //main方法测试
    public static void main(String[] args) {
        getResopnse().set("name", "zhangsan");
        String name = getResopnse().get("name");
        System.out.println(name);
    }

}
