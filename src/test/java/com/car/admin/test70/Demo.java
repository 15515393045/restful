package com.car.admin.test70;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-10-20 19:13
 **/
public class Demo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap();
        map.put("1", "张三");
        map.put("age", "12");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            String key = (String) next.getKey();
            String value = (String) next.getValue();
            System.out.println(key + ":" + value);
        }

        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            String next = (String) iterator1.next();
            String o = (String) map.get(next);
            System.out.println(o);
        }

        map.entrySet().stream().forEach(e -> {
            String value = e.getValue();
            String key = e.getKey();
            System.out.println(key+":"+value);
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        jsonObject.put("age","15");
        jsonObject.put("sex","男");

        Iterator keys = jsonObject.keys();
        while (keys.hasNext()){
            String next = (String) keys.next();
            String string = jsonObject.getString(next);
            System.out.println(next+":"+string);
        }


    }
}