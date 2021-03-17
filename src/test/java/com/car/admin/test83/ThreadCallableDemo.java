package com.car.admin.test83;

import jdk.nashorn.internal.ir.ReturnNode;
import sun.util.resources.cldr.hu.TimeZoneNames_hu;

import java.util.concurrent.Callable;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 17:28
 **/
public class ThreadCallableDemo implements Callable<String> {

    int count = 0;

    @Override
    public String call() throws Exception {
        int i = setCount();
        System.out.println("主线程："+Thread.currentThread().getName()+"---"+i);
        return "努力努力";
    }

    public int setCount(){
        count++;
        //System.out.println(count);
        return count;
    }
}
