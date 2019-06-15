package com.car.admin.thread;

import com.car.admin.test5.CountDemo;

/**
 * @program: demo-restful
 * @description: 线程
 * @author: zhanyh
 * @create: 2019-06-01 15:46
 **/
public class DemoThread implements Runnable{

    private static int CountDemo = 0;

    @Override
    public void run() {

        getCountDemo();

    }

    public static synchronized void getCountDemo(){

        CountDemo++;
        System.out.println(CountDemo);

    }


}

