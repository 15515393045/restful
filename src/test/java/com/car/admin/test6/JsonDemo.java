package com.car.admin.test6;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-06-06 11:02
 **/
public class JsonDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        User user1 = new User();
        user1.setName("李四");
        user1.setSex("男");
        User user2 = new User();
        user2.setName("小花");
        user2.setSex("女");
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        list.add(user2);
        Task task = new Task();
        task.setFinish(6);
        task.setUndone(3);
        Task task1 = new Task();
        task1.setFinish(8);
        task1.setUndone(4);
        Task task2 = new Task();
        task2.setFinish(4);
        task2.setUndone(2);
        List list1 = new ArrayList();
        list1.add(task);
        list1.add(task1);
        list1.add(task2);
        Map<String,Object> map = new HashMap();
        map.put("Header",list);
        map.put("Foot",list1);
        Map hashMap = new HashMap();
        hashMap.put("data",map);
        hashMap.put("message","成功");
        hashMap.put("code",200);
        Gson gson = new Gson();
        String toJson = gson.toJson(hashMap);
        System.out.println(toJson);
    }

}
