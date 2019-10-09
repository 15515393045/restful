package com.car.admin.test44;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-19 13:30
 **/
public class FastJsonDemo {

    public static void main(String[] args) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        jsonObject.put("age","15");
        jsonObject.put("sex","男");

        //用Iterator迭代器遍历取值，建议用反射机制解析到封装好的对象中
        Iterator keys = jsonObject.keys();
            while (keys.hasNext()){
                String key = (String) keys.next();
                String value = jsonObject.getString(key);
                System.out.println(value);
            }

        Map<String, String> hashMap = Collections.synchronizedMap(new HashMap<>());
        hashMap.put("name", "李四");
        hashMap.put("age", "17");
        hashMap.put("sex", "男");

        //lombda表达式 过滤循环Map
        Map<String, String> collect = hashMap.entrySet().stream().filter((e) -> checkKey(e.getKey())).collect(Collectors.toMap(
                (e) -> (String) e.getKey(),
                (e) -> e.getValue()
        ));
        //lombda表达式 过滤循环Map
        Map<String, String> collect1 = hashMap.entrySet().stream().filter(e -> !checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));

        System.out.println(collect+"----哈哈哈哈");
        System.out.println(collect1+"----呵呵呵呵");

        //lombda表达式遍历Map
        hashMap.entrySet().stream().forEach(e->{
            String key = e.getKey();
            String value = e.getValue();
            System.out.println(key +"====="+ value);
        });



        //遍历Map方法1  用Iterator迭代器遍历取值
        Iterator<Map.Entry<String, String>> iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> next = iterator1.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println(key+"----"+value);
        }
        //遍历Map方法2   用Iterator迭代器遍历取值
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String s = hashMap.get(key);
            System.out.println(s);
        }

        String json = "{\"UserName\":\"kobi\",\"workIn\":\"ALI\",\"age\":\"34\"}";
        Map map = JSON.parseObject(json, Map.class);
        System.out.println(map);
        String s = JSON.toJSONString(hashMap);
        System.out.println(s);
    }

    public static boolean checkKey(String key){
        if(key.equals("name")||key.equals("sex")){
            return false;
        }
        return true;
    }

}
