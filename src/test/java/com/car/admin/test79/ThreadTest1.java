package com.car.admin.test79;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 00:40
 **/
public class ThreadTest1 {
    static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(1);

    static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor
            (10, 20, 1, TimeUnit.MINUTES, blockingQueue);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new TaskBusyWithoutResult();
            threadPoolExecutor.submit(runnable);
        }
    }
}
