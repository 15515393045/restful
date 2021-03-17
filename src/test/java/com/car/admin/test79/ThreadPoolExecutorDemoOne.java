package com.car.admin.test79;

import java.util.concurrent.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 00:15
 **/
public class ThreadPoolExecutorDemoOne {

    static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(10);


    static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor
            (10, 20, 1, TimeUnit.MINUTES, blockingQueue);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
           Runnable runnable = new TaskWithoutResult(1000);
           //带返回值的执行
           threadPoolExecutor.submit(runnable);
        }
        threadPoolExecutor.shutdown();//不会触发中断
        //threadPoolExecutor.shutdownNow();//会触发中断
    }
}
