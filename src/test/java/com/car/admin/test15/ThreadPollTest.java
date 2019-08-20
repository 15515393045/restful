package com.car.admin.test15;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-19 09:11
 **/
public class ThreadPollTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}
