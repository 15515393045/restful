package com.car.admin.test25;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-08-29 21:27
 **/
public class ThreadDemo extends Thread{

    private static int count = 1;

    @Override
    public  void run() {
        //System.out.println("主线程："+Thread.currentThread().getName());

        setCount();

    }

    public void setCount(){

        System.out.println(count++);

    }
}
