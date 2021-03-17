package com.car.admin.test83;

import java.util.concurrent.*;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2020-05-19 17:31
 **/
public class CallableTest {

    static BlockingQueue blockingQueue = new LinkedBlockingQueue();

    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,2,1,TimeUnit.SECONDS,blockingQueue);

    public static void main(String[] args) {
        Callable<String> callable = new ThreadCallableDemo();
        Future<String> submit = poolExecutor.submit(callable);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            poolExecutor.shutdown();
        }

    }

}
