package com.car.admin.test77;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-18 22:20
 **/
public class ThreadTest1 implements Runnable{

    @Override
    public void run() {
        //获取线程名称
        System.out.println(Thread.currentThread().getName()+" 我是一个线程");
    }

}
