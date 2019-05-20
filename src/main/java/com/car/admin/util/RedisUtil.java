package com.car.admin.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    //为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除。
    public static  boolean isLimit(String key, int seconds, int maxCount){
        Jedis jedis = null;
        boolean flag = false;
        try {
            jedis = RedisSingle.getResopnse();
            //key map的指针,field 键,value 值
            Long result = jedis.incr(key);
            if(result == 1){
            //第一次
                jedis.expire(key,seconds);
            }
            if(result > maxCount){
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return flag;
    }


    //hash类型存值的方法 将哈希表 key 中的域 field 的值设为 value 。
    public static void hashMapSet(String key, String field, String value){
        Jedis jedis = null;
        try {
            jedis = RedisSingle.getResopnse();
            //key map的指针,field 键,value 值
            jedis.hset(key,field,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

    //hash类型获取值的方法  返回哈希表 key 中给定域 field 的值。
    public static String hashMapGet(String key, String field){
        Jedis jedis = null;
        String result = "";
        try {
            jedis = RedisSingle.getResopnse();
            //key map的指针,field 键,value 值
            result = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return result;
    }

    //get方法
    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisSingle.getResopnse();
            result = jedis.get(key);
            //使用catch就可以在redis缓存服务器宕机的时候不会跳出异常
            //代码可以继续向下走获取数据库中的数据。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return result;
    }

    //set方法
    public static String set(String key, String value){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisSingle.getResopnse();
            result = jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return result;
    }

    //删除方法
    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = RedisSingle.getResopnse();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
    }

    //设置到期时间到期自动删除
    /*返回值：
    设置成功，返回 1 。
    设置失败，返回 0 。*/
    public static boolean setnx(String key, int second){
        Jedis jedis = null;
        boolean flag = false;
        try {
            jedis = RedisSingle.getResopnse();
            //值随便写,因为我们只需判断redis中有没有改nonce
            Long res = jedis.setnx(key, System.currentTimeMillis()+"");
            //判断状态为1则将nonce存入缓存并且设置到期时间
            if(res == 1){
                //第一次
                jedis.expire(key,second);
                flag =  true;
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != jedis){
                jedis.close();
                jedis = null;
            }
        }
        return flag;
    }

}
