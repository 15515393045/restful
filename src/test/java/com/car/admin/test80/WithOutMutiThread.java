package com.car.admin.test80;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 07:02
 **/
public class WithOutMutiThread {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread.sleep(100L);

        Thread.sleep(150L);

        Thread.sleep(200L);

        Thread.sleep(300L);

        long endTime = System.currentTimeMillis();

        System.out.println("模拟调用四个接口所耗费的时间："+(endTime-startTime)+"毫秒");

    }
    
}
