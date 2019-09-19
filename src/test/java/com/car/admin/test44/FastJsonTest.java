package com.car.admin.test44;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-19 15:33
 **/
public class FastJsonTest {

    public static void main(String[] args) {
        String arr = "[{'name':'张三'},{'name':'赵六'},{'name':'王五'},{'name':'李四'}]";

        Object o = JSON.parseObject(arr, Object.class);
        if(o!=null){
           JSONArray jsonArray = (JSONArray) o;
            for (Object o1 : jsonArray) {
                JSONObject jsonObject = (JSONObject) o1;
                String name = (String) jsonObject.get("name");
                System.out.println(name);
            }
        }

       JSONArray jsonArray3 = (JSONArray) o;
        for (Object o1 : jsonArray3) {
            Map<String,String> map = (Map<String,String>) o1;
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                String s = map.get(key);
                System.out.println(s);
            }
        }

        JSONArray jsonArray = JSON.parseObject(arr, JSONArray.class);
        for (Object o1 : jsonArray) {
           JSONObject jsonObject = (JSONObject) o1;
            Object name = jsonObject.get("name");
            System.out.println(name);
        }

        //lombda表达式
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject o1 = (JSONObject) jsonArray.get(i);
            o1.entrySet().stream().forEach(e->{
                String key = e.getKey();
                Object value = e.getValue();
                System.out.println(key+":"+value);
            });
        }

        List list = JSON.parseObject(arr, List.class);
        for (int i = 0; i < list.size(); i++) {
            JSONObject o1 = (JSONObject) list.get(i);
            Object name = o1.get("name");
            System.out.println(name);
        }

        JSONArray jsonArray1 = (JSONArray) o;
        for (int i = 0; i < jsonArray1.size(); i++) {
            Map<String,String> o1 = (Map<String, String>) jsonArray1.get(i);
            String name = o1.get("name");
            System.out.println(name);
        }

        for (int i = 0; i < jsonArray1.size(); i++) {
            JSONObject o1 = (JSONObject) jsonArray1.get(i);
            Object name = o1.get("name");
            System.out.println(name);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("area","河南");
        jsonObject.put("city","北京");
        jsonObject.put("site","山东");

        Iterator<String> iterator = jsonObject.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            Object o1 = jsonObject.get(next);
            System.out.println(o1+"-"+next);
        }

        Iterator<Map.Entry<String, Object>> iterator1 = jsonObject.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Object> next = iterator1.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println(key+":"+value);
        }

        Map<String, Object> collect = jsonObject.entrySet().stream().filter(e -> checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));
        System.out.println(collect);

        Map<String, Object> collect1 = jsonObject.entrySet().stream().filter(e -> !checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));
        System.out.println(collect1);
    }

    public static boolean checkKey(String key){
        if(key.equals("area")){
            return false;
        }
        return true;
    }
}
