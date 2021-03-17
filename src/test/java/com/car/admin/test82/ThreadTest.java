package com.car.admin.test82;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:50
 **/
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("执行 开始");
        //创建线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //Future<?> future = threadPool.submit(new MyRunnable()) ;
        Future<String> future = threadPool.submit(new MyCallable());//执行
        try {
            // 这里会发生阻塞 3s
            System.out.println(future.get());
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();//关闭线程
        }
        System.out.println("执行 结束");
    }
}


