package com.car.admin.test86;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.tools.ant.types.CommandlineJava;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-20 18:36
 **/
public class FastJsonDemo {


    public static void main(String[] args) {
        String arr = "[{'name':'张三'},{'name':'赵六'},{'name':'王五'},{'name':'李四'}]";

        Object o1 = JSON.parseObject(arr, Object.class);
        if(null != o1){
            JSONArray array = (JSONArray)o1;
            for (Object o : array) {
                JSONObject obj = (JSONObject)o;
                String name = obj.getString("name");
                System.out.println(name);
            }
        }

        JSONArray array = JSON.parseObject(arr, JSONArray.class);
        if(array.size()>0){
            for (Object o : array) {
                Map<String,String> map = (Map) o;
                String name = map.get("name");
                System.out.println(name);
               /* Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()){
                    String key = iterator.next();
                    System.out.println(key);

                }*/
            }
        }


        for (int i = 0; i < array.size(); i++) {
            JSONObject parse = (JSONObject) array.get(i);
            String name = parse.getString("name");
            System.out.println(name);
        }

        for (int i = 0; i < array.size(); i++) {
            JSONObject o = (JSONObject) array.get(i);
            o.entrySet().stream().forEach(e->{
                String key = e.getKey();
                String value = (String) e.getValue();
                System.out.println(key+"："+value);
            });
        }

        List list = JSON.parseObject(arr, List.class);
        for (int i = 0; i < list.size(); i++) {
            JSONObject object = (JSONObject) list.get(i);
            System.out.println(object.getString("name"));
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("area","河南");
        jsonObject.put("city","北京");
        jsonObject.put("site","山东");

        jsonObject.entrySet().stream().forEach(e->{
            String key = e.getKey();
            String value = (String) e.getValue();
            System.out.println(key+"："+value);
        });

        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println(key+"-"+value);
        }

        Iterator<String> iterator1 = jsonObject.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            Object o = jsonObject.get(key);
            System.out.println(o);
        }

        //lombda表达式循环过滤
        Map<String, Object> collect = jsonObject.entrySet().stream().filter(e -> !checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));
        System.out.println(collect);

    }

    public static boolean checkKey(String key){
        if(key.equals("site")){
            return true;
        }else {
            return false;
        }
    }

}
