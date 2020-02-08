package com.car.admin.test71;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-02-08 17:04
 **/
public class Test {

    public static void main(String[] args) {
        int i1 = 21;
        //移动几位就是2的几次幂
        System.out.println(i1 << 2);//84
        System.out.println(i1 << 3);//168
        System.out.println(i1 << 4);//336
        System.out.println(i1 << 27);//-1476395008   符号位第一位变成了1为复数

        i1 = 2;
        System.out.println(i1 << 2);


        Map map = new HashMap();
        map.put("1", "张三");
        map.put("2", "里斯");
        map.put("3", "王五");

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getValue());
            System.out.println(next.getKey());
        }

        Iterator iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String next = (String) iterator1.next();
            String o = (String) map.get(next);
            System.out.println(o);
            System.out.println(next);
        }

    }


}
