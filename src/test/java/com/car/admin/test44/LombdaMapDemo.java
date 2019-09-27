package com.car.admin.test44;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-19 14:51
 **/
public class LombdaMapDemo {

    public static void main(String[] args) {
        Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
        map.put("name","张三");
        map.put("age",18);
        map.put("sex","男");
        map.put("area","河南洛阳");
        map.put("birthday",new Date());
        map.put("phone",1536145125);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            System.out.println(key+":"+value);
        }

        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            Object value = map.get(key);
            System.out.println(value+":"+key);
        }


        Map<String, Object> collect = map.entrySet().stream().filter(e -> checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));
        Map<String, Object> collect1 = map.entrySet().stream().filter(e -> !checkKey(e.getKey())).collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue()
        ));
        System.out.println(collect1);
        System.out.println(collect);

        Map<String,String> map1 = new LinkedHashMap();
        map1.put("name","张三");
        map1.put("age","男");
        map1.put("sex","18");

        map1.entrySet().stream().forEach(e->{
            System.out.println(e+"=====================================");
            String key = e.getKey();
            String value = e.getValue();//需要定义泛型
            System.out.println(key+"："+value);
        });

        Iterator iterator2 = map1.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry next = (Map.Entry) iterator2.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println(key+"："+value);
        }

        Iterator iterator3 = map1.keySet().iterator();
        while (iterator3.hasNext()){
            Object key = iterator3.next();
            Object value = map1.get(key);
            System.out.println(value);
        }


    }

    public static boolean checkKey(String key){
        if(key.equals("age")||key.equals("birthday")||key.equals("phone")){
            return false;
        }
        return true;
    }

}
