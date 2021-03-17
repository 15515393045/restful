package com.car.admin.test77;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-18 23:22
 **/
public class ThreadPoolExecutorDemo {

  private static   ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor
            (5, 10, 1, TimeUnit.SECONDS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        poolExecutor.shutdown();
        boolean shutdown = poolExecutor.isTerminated();
        boolean shutdown1 = poolExecutor.isShutdown();
        System.out.println(shutdown);//true
        System.out.println(shutdown1);//true
    }

}
