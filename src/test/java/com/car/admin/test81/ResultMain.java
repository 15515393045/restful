package com.car.admin.test81;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 08:22
 **/
public class ResultMain {

    static BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,1,TimeUnit.SECONDS,blockingQueue);

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();//开始时间

            Callable callableA = new ColdDishCallable();
            Future<String> submitA = poolExecutor.submit(callableA);

            Callable callableB = new BumCallable();
            Future<String> submitB = poolExecutor.submit(callableB);
            //get()方法获取返回值
            System.out.println("ColdDishCallable类线程返回结果："+submitA.get());
            System.out.println("BumCallable类线程返回结果："+submitB.get());

            long entTime = System.currentTimeMillis();

            System.out.println("执行时间："+(entTime-startTime)+"毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            poolExecutor.shutdown();//关闭线程池
        }
    }




}
