package com.car.admin.test78;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-18 22:54
 **/
public class ThreadTest111 implements Runnable{

    int i = 0;

    @Override
    public void run() {
        test();
    }
    //加锁解决线程安全问题
    public synchronized void test(){
        i++;
        System.out.println(i);
    }

}
