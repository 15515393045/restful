package com.car.admin.test33;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-02 22:40
 **/
public class ThreadTest implements Runnable{

    private static int count = 100;

    @Override
    public void run() {

        int neo = 1;

        if(count>=neo){
            int i = count - neo;
            System.out.println(i);
        }


        //System.out.println("主线程名称："+Thread.currentThread().getName());

        //System.out.println("我是线程里面的RUN方法。");
    }

}
