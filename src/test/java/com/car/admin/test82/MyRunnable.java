package com.car.admin.test82;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:56
 **/
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyRunnable 线程");
    }
}
