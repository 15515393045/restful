package com.car.admin.test77;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 00:15
 **/
public class ThreadPoolExecutorDemoOne {

    static BlockingQueue blockingQueue=new ArrayBlockingQueue<>(10);

    static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES, blockingQueue);


}
