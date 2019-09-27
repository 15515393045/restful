package com.car.admin.test40;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        //Map map = Collections.synchronizedMap(new HashMap<>());
        //有序可以重复
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        System.out.println("List：");
        for (String s : list) {
            System.out.println(s+"====");
        }


        Set<String> set = new LinkedHashSet<String>();
        set.add("张三");
        set.add("李四");
        set.add("李四");
        set.add("王五");
        set.add("赵六");
        System.out.println("Set：");
        for (String s : set) {
            System.out.println(s);
        }
    }

}
