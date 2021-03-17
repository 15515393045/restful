package com.car.admin.test78;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-18 23:07
 **/
public class ThreadTest222 {

    public static void main(String[] args) throws InterruptedException {
        int i = 10;
        System.out.println(++i);

        Thread.sleep(3000);
        System.out.println("延迟3秒输出"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("延迟4秒输出"+"====================");
    }

}
